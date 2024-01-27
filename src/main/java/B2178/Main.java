package B2178;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Queue<int[]> q = new LinkedList<>();
        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] map = new int[n][m];
        int[][] move = new int[n][m];


        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < m; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        int[] dx = {0, 1, 0, -1};
        int[] dy = {-1, 0, 1, 0};

        q.add(new int[]{0, 0});

        while (!q.isEmpty()) {
            int[] current = q.poll();

            int x = current[0];
            int y = current[1];

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && move[nx][ny] == 0 && map[nx][ny] == 1) {
                    q.offer(new int[]{nx, ny});
                    move[nx][ny] = move[x][y] + 1;
                }
            }
        }

        System.out.println(move[n - 1][m - 1] + 1);
    }
}
