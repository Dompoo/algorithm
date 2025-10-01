import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/9663
@SuppressWarnings("ALL")
public class Main {

    static boolean[] col;
    static boolean[] leftup;
    static boolean[] rightup;
    static int N;
    static int count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        col = new boolean[N];
        leftup = new boolean[2 * N - 1];
        rightup = new boolean[2 * N - 1];

        dfs(0);
        System.out.println(count);
    }

    private static void dfs(int row) {
        if (row == N) { // N개의 row에 모두 놓았음
            count++;
            return;
        }
        for (int nextCol = 0; nextCol < N; nextCol++) {
            int lu = row + nextCol;
            int ru = row - nextCol + (N - 1);

            if (col[nextCol] || leftup[lu] || rightup[ru]) continue;

            col[nextCol] = true;
            leftup[lu] = true;
            rightup[ru] = true;
            dfs(row + 1);
            col[nextCol] = false;
            leftup[lu] = false;
            rightup[ru] = false;
        }
    }
}
