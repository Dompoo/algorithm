package B11058;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        long[] dp = new long[N + 1];

        // 초기값 설정
        dp[1] = 1;

        for (int i = 2; i <= N; i++) {
            dp[i] = dp[i - 1] + 1;  // Ctrl-A C V V ... 마지막에 A출력

            // Ctrl A C V V ...
            for (int j = 2; j <= i - 2; j++) {
                dp[i] = Math.max(dp[i], dp[j - 2] * (i - j + 1));
            }
        }

        System.out.println(dp[N]);
    }
}
