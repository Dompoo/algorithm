package B1303;

import java.util.Scanner;

public class Main {
    static int n;
    static int m;
    static int[][] arr;
    static boolean[][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt(); //가로
        m = sc.nextInt(); //세로

        arr = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < m; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                arr[j][i] = str.charAt(j) == 'W' ? 0 : 1;
            }
        }

        int score0 = 0;
        int score1 = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!visited[i][j]) {
                    if (arr[i][j] == 0) {
                        score0 += (int) Math.pow(DFS(i, j, arr[i][j]), 2);
                    } else {
                        score1 += (int) Math.pow(DFS(i, j, arr[i][j]), 2);
                    }
                }
            }
        }

        System.out.println(score0 + " " + score1);
    }

    public static int DFS(int x, int y, int team) {
        visited[x][y] = true;

        int power = 1;

        if (x > 0 && arr[x - 1][y] == team && !visited[x - 1][y]) {
            power += DFS(x - 1, y, team);
        }
        if (y > 0 && arr[x][y - 1] == team && !visited[x][y - 1]) {
            power += DFS(x, y - 1, team);
        }
        if (x < n - 1 && arr[x + 1][y] == team && !visited[x + 1][y]) {
            power += DFS(x + 1, y, team);
        }
        if (y < m - 1 && arr[x][y + 1] == team && !visited[x][y + 1]) {
            power += DFS(x, y + 1, team);
        }

        return power;
    }
}
