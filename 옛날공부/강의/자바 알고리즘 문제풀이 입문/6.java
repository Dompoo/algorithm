
import java.util.*;

class Main {

    public String solution(String input) {
        boolean[] exsist = new boolean[26];
        String output = "";
        for(char x : input.toCharArray()) {
            if(!exsist[x - 'a']) {
                output += x;
                exsist[x - 'a'] = true;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        Main T = new Main();
        System.out.println(T.solution(input));
    }
}