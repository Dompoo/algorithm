import java.util.*;

class Main {

    public int solution(String input) {
        String result = "";

        char[] chars = input.toCharArray();

        for(int i = 0; i < input.length(); i++) {
            if('0' <= chars[i] && chars[i] <= '9') {
                result += chars[i];
            }
        }

        return Integer.parseInt(result);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        Main T = new Main();

        System.out.print(T.solution(input));
    }
}