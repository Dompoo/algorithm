import java.util.*;

class Main {

    public String solution(String input) {
        String lowercase = input.toLowerCase();

        String reversed = new StringBuilder(lowercase).reverse().toString();

        if(lowercase.equals(reversed)) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        Main T = new Main();

        System.out.println(T.solution(input));
    }
}