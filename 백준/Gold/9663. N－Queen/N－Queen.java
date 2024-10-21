import java.util.*;
import java.io.*;

class Main {

    public static int N;

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int[] chess = new int[N];
        for (int i = 0; i < N; i++) {
            chess[i] = -1;
        }

        System.out.print(dfs(chess, 0));
    }

    public static int dfs(int[] chess, int row) {
        if (N == row) {
            return 1;
        }

        int count = 0;

        for (int col = 0; col < N; col++) {
            if (isValidPosition(chess, row, col)) {
                // i j 위치에 퀸을 둔다.
                chess[row] = col;
                count += dfs(chess, row + 1);
                chess[row] = -1;
            }
        }

        return count;
    }

    private static boolean isValidPosition(int[] chess, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (chess[i] == col || Math.abs(i - row) == Math.abs(chess[i] - col)) {
                return false;
            }
        }
        return true;
    }
}