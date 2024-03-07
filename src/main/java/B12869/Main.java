package B12869;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        int iMax = sc.nextInt();
        int jMax = 0;
        int kMax = 0;
        if (N >= 2) jMax = sc.nextInt();
        if (N >= 3) kMax = sc.nextInt();

        int[][][] dp = new int[71][71][71]; // dp[i][j][k] : i j k 체력을 없애기 위한 최소 횟수
        for (int i = 0; i <= 70; i++) {
            for (int j = 0; j <= 70; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        dp[0][0][0] = 0;
        int minAns = Integer.MAX_VALUE;
        int[] di = new int[]{9, 9, 3, 3, 1, 1};
        int[] dj = new int[]{3, 1, 9, 1, 9, 3};
        int[] dk = new int[]{1, 3, 1, 9, 3, 9};

        for (int i = 0; i <= 70; i++) {
            for (int j = 0; j <= 70; j++) {
                for (int k = 0; k <= 70; k++) {
                    if (dp[i][j][k] == Integer.MAX_VALUE) continue;
                    if (i >= iMax && j >= jMax && k >= kMax) { // 모든 scv를 처치했을 때,
                        minAns = Math.min(minAns, dp[i][j][k]); // 최소 횟수를 저장
                    }
                    for (int l = 0; l < 6; l++) {
                        if (i + di[l] <= 70 && j + dj[l] <= 70 && k + dk[l] <= 70) {
                            dp[i + di[l]][j + dj[l]][k + dk[l]] = dp[i][j][k] + 1;
                        }
                    }
                }
            }
        }

        System.out.println(minAns);

    }
}
