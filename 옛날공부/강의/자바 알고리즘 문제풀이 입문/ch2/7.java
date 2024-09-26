import java.util.*;

class Main {

    public int solution(int size, int[] input) {
        int result = 0;
        int combo = 1;
        for(int i = 0; i < size; i++) {
            if (input[i] == 0) {
                combo = 1;
            } else if (input[i] == 1) {
                result += combo;
                combo++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] input = new int[N];
        for(int i = 0 ; i < N; i++) {
            input[i] = sc.nextInt();
        }

        Main T = new Main();
        int result = T.solution(N, input);
        System.out.println(result);
    }
}