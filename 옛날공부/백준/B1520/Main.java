package B1520;

import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] dp;
    static int[][] arr;
    static int[] dx = new int[]{0, 0, -1, 1};
    static int[] dy = new int[]{1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
                dp[i][j] = -1;
            }
        }

        int result = DFS(0, 0);

        System.out.println(result);
    }

    public static int DFS(int x, int y) {
        if (x == N - 1 && y == M - 1) return 1;
        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < N && ny < M) {
                if (arr[nx][ny] < arr[x][y]) {
                    dp[x][y] += DFS(nx, ny);
                }
            }
        }

        return dp[x][y];
    }
}
