import java.util.*;

class Main {
    public String solution(String input) {
        int count = 0;
        String result = "";
        for(char ch : input.toCharArray()) {
            if(ch == '(') count++;
            else if(ch == ')') count--;
            else if(count == 0) result += ch;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(new Main().solution(str));
    }
}