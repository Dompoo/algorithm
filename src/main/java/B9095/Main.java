package B9095;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] target = new int[N];
        int M = Integer.MIN_VALUE;

        for (int i = 0; i < N; i++) {
            target[i] = sc.nextInt();
            if (target[i] > M) {
                M = target[i];
            }
        }

        int[] dp = new int[M + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= M; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        for (int i = 0; i < N; i++) {
            System.out.println(dp[target[i]]);
        }
    }
}
