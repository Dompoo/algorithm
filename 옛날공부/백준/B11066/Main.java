package B11066;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int[] answer = new int[T];
        int answerindex = 0;

        for (int t = 0; t < T; t++) {

            int size = sc.nextInt();
            int[][] dp = new int[size + 1][size + 1];
            int[] sum = new int[size + 1];
            int[] file = new int[size + 1];

            for (int i = 1; i <= size; i++) {
                file[i] = sc.nextInt();
            }

            for (int i = 1; i <= size; i++) {
                sum[i] = sum[i - 1] + file[i];
            }

            for (int len = 2; len <= size; len++) {
                for (int start = 1; start + len - 1 <= size; start++) {
                    int end = start + len - 1;
                    dp[start][end] = Integer.MAX_VALUE;

                    for (int k = start; k < end; k++) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][k] + dp[k + 1][end]);
                    }

                    dp[start][end] += sum[end] - sum[start - 1];
                }
            }

            answer[answerindex++] = dp[1][size];
        }

        for (int i = 0; i < T; i++) {
            System.out.println(answer[i]);
        }
    }
}
