package B2606;

import java.util.Scanner;

public class Main {
    static boolean[][] comArr;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        n = sc.nextInt();
        int k = sc.nextInt();
        comArr = new boolean[n][n];
        visited = new boolean[n];

        for (int i = 0; i < k; i++) {
            int com1 = sc.nextInt() - 1;
            int com2 = sc.nextInt() - 1;
            comArr[com1][com2] = true;
            comArr[com2][com1] = true;
        }

        int num = DFS(0);

        System.out.println(num - 1);
    }

    public static int DFS(int com) {
        visited[com] = true;
        int connect = 1;

        for (int i = 0; i < n; i++) {
            if (comArr[com][i] && !visited[i]) {
                connect += DFS(i);
            }
        }

        return connect;
    }
}
