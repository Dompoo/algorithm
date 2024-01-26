package B2294;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int target = sc.nextInt();

        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int[] dp = new int[target + 1];

        Arrays.fill(dp, 10001);
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= target; i++) {
                dp[i] = Math.min(dp[i - coin] + 1, dp[i]);
            }
        }

        System.out.println(dp[target] == 10001 ? -1 : dp[target]);
    }
}
