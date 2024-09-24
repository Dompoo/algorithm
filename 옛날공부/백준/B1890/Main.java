package B1890;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] map = new int[N][N];
        long[][] way = new long[N][N];


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        way[0][0] = 1;
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                if (x == N - 1 && y == N - 1) break;

                int jumpDx = x + map[x][y];
                int jumpRy = y + map[x][y];

                if (jumpDx < N) way[jumpDx][y] += way[x][y];
                if (jumpRy < N) way[x][jumpRy] += way[x][y];
            }
        }

        System.out.println(way[N - 1][N - 1]);
    }
}
