import java.util.*;

class Main {

    public String solution(String input) {
        char[] chArr = input.toCharArray();

        char lastChar = chArr[0];
        int combo = 0;
        String result = "";
        
        for(int i = 0; i < input.length(); i++) {
            if(chArr[i] == lastChar) {
                combo++;
            } else {
                result += lastChar;
                if(combo != 1) result += combo;
                combo = 1;
                lastChar = chArr[i];
            }
        }

        result += lastChar;
        if(combo != 1) result += combo;

        return result;
    }

    public static void main(String[] args) { 
        Scanner sc = new Scanner(System.in);
        String input = sc.next();

        Main T = new Main();
        System.out.print(T.solution(input));
    }
}