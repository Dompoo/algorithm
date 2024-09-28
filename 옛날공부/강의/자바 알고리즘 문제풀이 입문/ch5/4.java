// 352+*9-

import java.util.*;

class Main {

    public int solution(String input) {
        Stack<Integer> stack = new Stack<>();

        for(char ch : input.toCharArray()) {
            if('1' <= ch && ch <= '9') {
                stack.push(Integer.valueOf(ch - '0'));
            } else {
                int num1 = stack.pop();
                int num2 = stack.pop();
                int result = 0;
                switch(ch) {
                    case '+': result = num1 + num2; break;
                    case '-': result = num2 - num1; break;
                    case '*': result = num1 * num2; break;
                    case '/': result = num1 / num2; break;
                    default: throw new RuntimeException();
                }
                stack.push(result);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(new Main().solution(input));
    }
}