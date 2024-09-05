package B11049;

import java.util.Scanner;

public class Main {
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        arr = new int[N][2];

        for (int i = 0; i < N; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int[][] dp = new int[N][N]; // i 부터 j 까지 행렬곱셈 값의 최솟값

        for (int len = 2; len <= N; len++) {
            for (int start = 0; start + len - 1 < N; start++) {
                int end = start + len - 1;

                dp[start][end] = Integer.MAX_VALUE;

                for (int middle = start; middle < end; middle++) {
                    int val = dp[start][middle] + dp[middle + 1][end]
                            + (arr[start][0] * arr[middle][1] * arr[end][1]);
                    dp[start][end] = Math.min(dp[start][end], val);
                }
            }
        }

        System.out.println(dp[0][N - 1]);
    }
}
