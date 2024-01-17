package B2504;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    static String str;
    static int multiply;
    static int result;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Character> stack = new Stack<>();
        result = 0;
        multiply = 1;

        str = sc.next();

        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '(') {
                stack.push(ch);
                multiply *= 2;
            } else if (ch == '[') {
                stack.push(ch);
                multiply *= 3;
            } else if (ch == ')') {
                if (stack.empty() || stack.peek() != '(') {
                    result = 0;
                    break;
                } else if (str.charAt(i - 1) == '(') {
                    result += multiply;
                }
                stack.pop();
                multiply /= 2;
            } else if (ch == ']') {
                if (stack.empty() || stack.peek() != '[') {
                    result = 0;
                    break;
                } else if (str.charAt(i - 1) == '[') {
                    result += multiply;
                }
                stack.pop();
                multiply /= 3;
            }
        }

        //결과 출력
        if (!stack.isEmpty()) System.out.println(0);
        else System.out.println(result);
    }
}
