import java.util.*;

class Main {

    public int[] solution(String s, char t) {
        int[] answer = new int[s.length()];
        char[] chArr = s.toCharArray();

        for(int i = 0; i < s.length(); i++) {
            int frontLen = 0;
            boolean isFrontExist = false;
            int backLen = 0;
            boolean isBackExist = false;

            //frontLen 구하기
            for(int j = i; j >= 0; j--) {
                if(chArr[j] == t) {
                    isFrontExist = true;
                    break;
                }
                frontLen++;
            }

            //backLen 구하기
            for(int j = i; j < s.length(); j++) {
                if(chArr[j] == t) {
                    isBackExist = true;
                    break;
                }
                backLen++;
            }

            answer[i] = Math.min(
                isFrontExist ? frontLen : Integer.MAX_VALUE, 
                isBackExist ? backLen : Integer.MAX_VALUE
            );
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String c = sc.next();
        char t = c.charAt(0);

        Main T = new Main();
        int[] answer = T.solution(str, t);

        System.out.print(answer[0]);
        for(int i = 1; i < str.length(); i++) {
            System.out.print(" " + answer[i]);
        }
    }
}