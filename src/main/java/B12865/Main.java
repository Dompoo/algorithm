package B12865;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int productNum = sc.nextInt();
        int maxWeight = sc.nextInt();

        int[] weight = new int[productNum + 1];
        int[] value = new int[productNum + 1];

        for (int i = 1; i <= productNum; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        int[][] dp = new int[productNum + 1][maxWeight + 1];
        // dp[i][j] : i번째 상품까지 고려했을 때 j가 max무게인 경우 최고 value

        for (int i = 1; i <= productNum; i++) {
            for (int j = 0; j <= maxWeight; j++) {
                // i번 물품까지 고려됐고 j만큼 무게를 썼을 때 최고 value
                if (0 <= j - weight[i]) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        System.out.println(dp[productNum][maxWeight]);


    }
}
