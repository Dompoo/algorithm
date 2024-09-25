
import java.util.*;

class Main {

    public String solution(String str) {
        String[] strs = str.split(" ");
        int maxLength = Integer.MIN_VALUE;
        String answer = strs[0];

        for(String x : strs) {
            if(x.length() > maxLength) {
                maxLength = x.length();
                answer = x;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.print(new Main().solution(str));
    }
}