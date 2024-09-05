package B3085;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static char[][] arr;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer s = new StringTokenizer(in.readLine(), " ");
        n = Integer.parseInt(s.nextToken());
        arr = new char[n][n];
        int max = 1;

        String str;
        for (int i = 0; i < n; i++) {
            str = in.readLine();
            for (int j = 0; j < n; j++) {
                arr[i][j] = str.charAt(j);
            }
        }

        //swap 전 체크
        for (int i = 0; i < n; i++) {
            max = Math.max(checkRow(i), max);
        }
        for (int i = 0; i < n; i++) {
            max = Math.max(checkCol(i), max);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i + 1 < n) {
                    swap(i, j, i + 1, j);
                    max = Math.max(checkRow(i), max);
                    max = Math.max(checkRow(i + 1), max);
                    max = Math.max(checkCol(j), max);
                    swap(i, j, i + 1, j);
                }
                if (j + 1 < n) {
                    swap(i, j, i, j + 1);
                    max = Math.max(checkRow(i), max);
                    max = Math.max(checkCol(j), max);
                    max = Math.max(checkCol(j + 1), max);
                    swap(i, j, i, j + 1);
                }
            }
        }
        System.out.println(max);
    }

    public static int checkRow(int x) {
        int oldMax = 1;
        int curMax = 1;

        char ch = arr[x][0];
        for(int i = 1; i < n; i++) {
            if(arr[x][i] != ch) {
                ch = arr[x][i];
                oldMax = Math.max(oldMax, curMax);
                curMax = 1;
            } else curMax++;
        }
        return Math.max(oldMax,  curMax);
    }

    public static int checkCol(int y) {
        int oldMax = 1;
        int curMax = 1;

        char ch = arr[0][y];
        for(int i = 1; i < n; i++) {
            if(arr[i][y] != ch) {
                ch = arr[i][y];
                oldMax = Math.max(oldMax, curMax);
                curMax = 1;
            } else curMax++;
        }
        return Math.max(oldMax,  curMax);
    }

    public static void swap(int x1, int y1, int x2, int y2) {
        char tmp = arr[x1][y1];
        arr[x1][y1] = arr[x2][y2];
        arr[x2][y2] = tmp;
    }
}
