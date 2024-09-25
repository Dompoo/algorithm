import java.util.*;

class Main {

    public String solution(String input) {
        String in = input.toLowerCase();

        int leftIndex = 0;
        int rightIndex = in.length() - 1;

        char[] chars = in.toCharArray();

        boolean result = true;

        while(true) {
            for(int i = leftIndex; i < in.length(); i++) {
                if('a' <= chars[i] && chars[i] <= 'z') {
                    leftIndex = i;
                    break;
                }
            }
            for(int i = rightIndex; i >= 0; i--) {
                if('a' <= chars[i] && chars[i] <= 'z') {
                    rightIndex = i;
                    break;
                }
            }

            if(leftIndex >= rightIndex) break;
            if(chars[leftIndex] != chars[rightIndex]) {
                result = false;
                break;
            }
            
            leftIndex++;
            rightIndex--;
        }

        if(result) {
            return "YES";
        } else {
            return "NO";
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.nextLine();

        Main T = new Main();

        System.out.println(T.solution(input));
    }
}