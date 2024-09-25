 
 import java.util.*;
 
 class Main {

    public String solution(String input) {
        int leftIndex = 0;
        int rightIndex = input.length() - 1;

        char[] in = input.toCharArray();

        while(true) {
            //update lI
            for(int i = leftIndex; i < input.length(); i++) {
                char ch = in[i];
                if('A' <= ch && ch <= 'Z' || 'a' <= ch && ch <= 'z') {
                    leftIndex = i;
                    break;
                }
            }

            //update rI
            for(int i = rightIndex; i >= 0; i--) {
                char ch = in[i];
                if('A' <= ch && ch <= 'Z' || 'a' <= ch && ch <= 'z') {
                    rightIndex = i;
                    break;
                }
            }

            if(leftIndex >= rightIndex) break;
            else {
                char tmp = in[leftIndex];
                in[leftIndex] = in[rightIndex];
                in[rightIndex] = tmp;
                leftIndex++;
                rightIndex--;
            }
        }

        return String.valueOf(in);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String input = sc.next();

        Main T = new Main();

        System.out.print(T.solution(input));
    }
 }