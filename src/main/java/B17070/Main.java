package B17070;

import java.util.Scanner;

public class Main {
    static int[][] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        dp = new int[n + 2][n + 2];

        //-1은 벽
        for (int i = 0; i < n + 2; i++) {
            dp[0][i] = -1;
            dp[i][0] = -1;
            dp[n + 1][i] = -1;
            dp[i][n + 1] = -1;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                dp[i][j] = sc.nextInt() == 1 ? -1 : 0;
            }
        }

        DFS(1, 2, 0);

        System.out.println(dp[n][n] == -1 ? 0 : dp[n][n]);
    }

    // dir : → 0 / ↘ 1 / ↓ 2
    public static void DFS(int x, int y, int dir) {
        dp[x][y]++; //방문

        boolean empty0 = dp[x][y + 1] != -1;
        boolean empty2 = dp[x + 1][y] != -1;
        boolean empty1 = dp[x + 1][y + 1] != -1 && empty0 && empty2;

        if (dir == 0 || dir == 1) {
            if (empty0) DFS(x, y + 1, 0);
        }
        if (dir == 1 || dir == 2) {
            if (empty2) DFS(x + 1, y, 2);
        }
        if (empty1) DFS(x + 1, y + 1, 1);
    }
}
