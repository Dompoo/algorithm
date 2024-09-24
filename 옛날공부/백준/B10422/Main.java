package B10422;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] testCase = new int[T];

        int maxCase = Integer.MIN_VALUE;
        for (int i = 0; i < T; i++) {
            testCase[i] = sc.nextInt();
            maxCase = Math.max(maxCase, testCase[i]);
        }

        long[] dp = new long[maxCase + 1];
        dp[0] = 1; //0개로 만들 수 있는 올바른 괄호열은 본래 0개지만 계산을 위해
        dp[2] = 1;
        for (int n = 4; n <= maxCase; n += 2) {
            for (int i = 1; i < n; i++) {
                dp[n] += dp[i - 1] * dp[n - i - 1]; // ( + i-1괄호열 + ) + n-i-1괄호열
                dp[n] %= 1000000007;
            }
        }


        for (int i = 0; i < T; i++) {
            if (testCase[i] % 2 == 1) {
                System.out.println(0);
            } else {
                System.out.println(dp[testCase[i]]);
            }
        }
    }
}
