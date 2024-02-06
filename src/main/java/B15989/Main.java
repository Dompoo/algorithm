package B15989;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] ans = new int[T];
        int maxAns = Integer.MIN_VALUE;

        for (int i = 0; i < T; i++) {
            ans[i] = sc.nextInt();
            if (ans[i] > maxAns) maxAns = ans[i];
        }

        int[][] dp = new int[4][maxAns + 1];
        //dp[i][j] = 1~i의 숫자로 j를 만들 수 있는 경우의 수
        //-> dp[i][j]   += dp[i][j-i] : i가 무조건 포함되는 방법
        //              += dp[i-1][j] : i가 무조건 포함되지 않는 방법

        dp[1][1] = 1; // 1

        dp[2][1] = 1; // 1+1
        dp[2][2] = 2; // 2, 1+1

        dp[3][1] = 1; // 1+1+1
        dp[3][2] = 2; // 2+1, 1+1+1
        dp[3][3] = 3; // 3, 2+1, 1+1+1

        for (int i = 1; i <= 3; i++) {
            for (int j = i + 1; j <= maxAns; j++) {
                dp[i][j] = (j >= i ? dp[i][j - i] : 0) + dp[i - 1][j];
            }
        }

        for (int i = 0; i < T; i++) {
            System.out.println(dp[3][ans[i]]);
        }

    }
}
