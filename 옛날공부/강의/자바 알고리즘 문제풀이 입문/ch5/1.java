import java.util.*;

class Main {
    public String solution(String input) {
        int cur = 0;
        boolean isValid = true;

        for(char ch : input.toCharArray()) {
            if(ch == '(') {
                cur++;
            } else if(ch == ')') {
                cur--;
            }
            if(cur < 0) return "NO";
        }

        if(cur == 0) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(new Main().solution(input));
    }
}