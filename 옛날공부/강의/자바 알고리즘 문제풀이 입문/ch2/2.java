import java.util.*;

class Main {

    public int solution(int size, int[] input) {
        int currMax = Integer.MIN_VALUE;
        int result = 0;

        for(int i = 0; i < size; i++) {
            if(currMax < input[i]) {
                result++;
                currMax = input[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputSize = sc.nextInt();
        int[] input = new int[inputSize];

        for(int i = 0; i < inputSize; i++) {
            input[i] = sc.nextInt();
        }

        Main T = new Main();
        int result = T.solution(inputSize, input);

        System.out.println(result);
    }
}