import java.util.*;

class Main {

    public int solution(int end) {
        boolean[] isPrime  = new boolean[end + 1];

        Arrays.fill(isPrime, true);

        /*
        2 -> 4 6 8 10 ... x
        3 -> 9 12 ... x
        5
        */
        for(int i = 2; i * i <= end; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= end; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int result = 0;
        for(int i = 2; i <= end; i++) {
            if(isPrime[i]) result++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int end = sc.nextInt();

        Main T = new Main();
        int result = T.solution(end);

        System.out.print(result);
    }
}