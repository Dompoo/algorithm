package B17086;

import java.util.Scanner;

public class Main {
    static int N;
    static int M;
    static int[][] arr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int max = Integer.MIN_VALUE;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) {
                    max = Math.max(DFS(i, j, 1), max);
                }
            }
        }

        System.out.println(max);
    }

    public static int DFS(int n, int m, int depth) {
        boolean isSafe = true;

        int x1 = Math.max(n - depth, 0);
        int x2 = Math.min(n + depth, N - 1);
        int y1 = Math.max(m - depth, 0);
        int y2 = Math.min(m + depth, M - 1);

        for (int x = x1; x <= x2; x++) {
            if (arr[x][y1] == 1) {
                isSafe = false;
                break;
            }
        }
        for (int x = x1; x <= x2; x++) {
            if (arr[x][y2] == 1) {
                isSafe = false;
                break;
            }
        }
        for (int y = y1; y <= y2; y++) {
            if (arr[x1][y] == 1) {
                isSafe = false;
                break;
            }
        }
        for (int y = y1; y <= y2; y++) {
            if (arr[x2][y] == 1) {
                isSafe = false;
                break;
            }
        }

        if (isSafe) {
            return DFS(n, m, depth + 1);
        } else {
            return depth;
        }

    }
}
