package B1743;

import java.util.Scanner;

public class Main {
    static int min = Integer.MIN_VALUE;
    static int[] dx = new int[]{0, 0, 1, -1};
    static int[] dy = new int[]{1, -1, 0, 0};
    static boolean[][] map;
    static int n;
    static int m;


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        int k = sc.nextInt();

        map = new boolean[n][m];

        for (int i = 0; i < k; i++) {
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            map[x][y] = true;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (map[i][j]) {
                    int curMin = DFS(i, j);
                    min = Math.max(min, curMin);
                }
            }
        }
        System.out.println(min);
    }

    public static int DFS(int x, int y) {
        int visit = 1;

        map[x][y] = false;
        for (int l = 0; l < 4; l++) {
            int nx = x + dx[l];
            int ny = y + dy[l];
            if (nx >= 0 && ny >= 0 && nx < n && ny < m && map[nx][ny]) {
                visit += DFS(nx, ny);
            }
        }

        return visit;
    }

}
