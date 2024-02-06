package B5557;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N - 1]; // 0 ~ N-2 까지

        for (int i = 0; i < N - 1; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        long[][] dp = new long[N - 1][21];
        dp[0][arr[0]] = 1;

        for (int i = 0; i < N - 2; i++) {
            for (int j = 0; j <= 20; j++) {
                if (dp[i][j] == 0) continue;
                if (j + arr[i + 1] <= 20) dp[i + 1][j + arr[i + 1]] += dp[i][j];
                if (j - arr[i + 1] >= 0) dp[i + 1][j - arr[i + 1]] += dp[i][j];
            }
        }

        System.out.println(dp[N - 2][target]);
    }
}
