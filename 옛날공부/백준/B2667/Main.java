package B2667;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static boolean[][] checked;
    static int[][] arr;
    static int n;
    static int complexNum = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();

        arr = new int[n][n];
        checked = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j) - '0';
            }
        }

        ArrayList<Integer> complex = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!checked[i][j] && arr[i][j] == 1) {
                    int complexSize = DFS(i, j);
                    complex.add(complexSize);
                    complexNum++;
                }
            }
        }

        Collections.sort(complex);
        System.out.println(complexNum);
        for (Integer size : complex) {
            System.out.println(size);
        }
    }

    public static int DFS(int i, int j) {
        checked[i][j] = true;
        int ans = 1;

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int k = 0; k < 4; k++) {
            int x = i + dx[k];
            int y = j + dy[k];
            if (x >= 0 && x < n && y >= 0 && y < n) {
                if (arr[x][y] == 1 && !checked[x][y]) {
                    ans += DFS(x, y);
                }
            }
        }

        return ans;
    }
}
