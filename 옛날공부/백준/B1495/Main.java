package B1495;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int songNum = sc.nextInt();
        int startVol = sc.nextInt();
        int maxVol = sc.nextInt();

        int[] V = new int[songNum + 1];

        for (int i = 1; i <= songNum; i++) {
            V[i] = sc.nextInt();
        }

        boolean[][] dp = new boolean[songNum + 1][maxVol + 1];


        dp[0][startVol] = true;

        for (int i = 1; i <= songNum; i++) {
            for (int j = 0; j <= maxVol ; j++) {
                if (dp[i - 1][j]) {
                    if (0 <= j - V[i]) {
                        dp[i][j - V[i]] = true;
                    }
                    if (j + V[i] <= maxVol) {
                        dp[i][j + V[i]] = true;
                    }
                }
            }
        }

        int result = -1;
        for (int i = 0; i <= maxVol; i++) {
            if (dp[songNum][i]) {
                result = i;
            }
        }
        System.out.println(result);
    }
}
