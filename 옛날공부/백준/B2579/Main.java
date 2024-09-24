package B2579;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            arr[i] = sc.nextInt();
        }

        int[][] dp = new int[N + 1][2]; //i번재 계단을 j번째로 1칸 올랐을 때 최대 점수

        dp[1][0] = arr[1];

        for (int i = 2; i <= N; i++) {
            dp[i][1] = Math.max(dp[i - 1][0] + arr[i], dp[i][1]);
            dp[i][0] = Math.max(dp[i - 2][0] + arr[i], dp[i - 2][1] + arr[i]);
        }

        System.out.println(Math.max(dp[N][0] , dp[N][1]));
    }
}
