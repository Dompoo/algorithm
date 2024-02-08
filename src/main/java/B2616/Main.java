package B2616;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N + 1]; // 각 칸의 누적 승객수

        for (int i = 1; i <= N; i++) {
            arr[i] = arr[i - 1] + sc.nextInt();
        }

        int T = sc.nextInt();

        int[][] dp = new int[4][N + 1];

        for (int i = 1; i <= 3; i++) {
            for (int j = i * T; j <= N; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - T] + arr[j] - arr[j - T]);
            }
        }

        System.out.println(dp[3][N]);
    }
}
