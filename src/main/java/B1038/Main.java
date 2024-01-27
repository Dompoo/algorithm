package B1038;

import java.util.Scanner;

public class Main {
    static long[][] dp;
    static long[] row;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        dp = new long[11][10];
        row = new long[11];

        // 초기화
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        row[1] = sum(dp[1]);

        // dp 배열과 row_count 배열 초기화
        for (int i = 2; i < 11; i++) {
            for (int j = 1; j < 10; j++) {
                dp[i][j] = dp[i - 1][j - 1] + dp[i][j - 1];
            }
            row[i] = row[i - 1] + sum(dp[i]);
        }

        // 결과 출력
        System.out.println(find(n + 1));
    }

    private static String find(int n) {
        int count = 0;
        int lastCount = 0;
        int length = 0;
        int number = 0;

        for (length = 1; length < 11; length++) {
            for (number = 0; number < 10; number++) {
                lastCount = count;
                count += dp[length][number];

                if (count >= n) break;
            }

            if (count >= n) break;
        }

        if (count < n) {
            return "-1";
        }

        if (length == 1) {
            return Integer.toString(number);
        }

        return number + find((int) (row[length - 2] + (n - lastCount)));
    }

    private static long sum(long[] arr) {
        long sum = 0;
        for (long num : arr) {
            sum += num;
        }
        return sum;
    }
}
