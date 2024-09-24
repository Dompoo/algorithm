
import java.util.Scanner;

class Main {

    public String solution(String input) {
        String output = "";

        for(int i = input.length() - 1; i >= 0; i--) {
            output += input.charAt(i);
        }

        return output;
    }

    public String solution2(String input) {
        return new StringBuilder(input).reverse().toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputSize = sc.nextInt();

        Main T = new Main();

        for (int i = 0; i < inputSize; i++) {
            System.out.println(T.solution(sc.next()));
        }
    }
}