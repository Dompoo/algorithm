package B15988;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] testCase = new int[T];
        int maxCase = Integer.MIN_VALUE;
        int div = 1000000009;

        for (int i = 0; i < T; i++) {
            testCase[i] = sc.nextInt();
            if (testCase[i] > maxCase) {
                maxCase = testCase[i];
            }
        }

        long[] dp = new long[maxCase + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= maxCase; i++) {
            dp[i] = (dp[i - 3] + dp[i - 2] + dp[i - 1]) % div;
        }

        for (int i = 0; i < T; i++) {
            System.out.println(dp[testCase[i]]);
        }
    }
}
