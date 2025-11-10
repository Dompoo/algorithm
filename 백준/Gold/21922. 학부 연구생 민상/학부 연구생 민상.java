import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("ALL")
public class Main {

    /*
    물건 종류
    1 : |
    2 : -
    3 : /
    4 : \

    방향 종류
    1 : up
    2 : right
    3 : down
    4 : left
     */

    static boolean[][] colored;
    static int[][] arr;
    static int N;
    static int M;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        colored = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (arr[i][j] == 9) colored[i][j] = true;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 9) {
                    color(i - 1, j, 1);
                    color(i, j + 1, 2);
                    color(i + 1, j, 3);
                    color(i, j - 1, 4);
                }
            }
        }

        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (colored[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }

    public static void color(int x, int y, int direction) {
        if (x < 0 || x >= N || y < 0 || y >= M || arr[x][y] == 9) return;

        colored[x][y] = true;
        int nextDirection = nextDirection(arr[x][y], direction);
        if (nextDirection == -1) return;

        if (nextDirection == 1) color(x - 1, y, nextDirection);
        else if (nextDirection == 2) color(x, y + 1, nextDirection);
        else if (nextDirection == 3) color(x + 1, y, nextDirection);
        else if (nextDirection == 4) color(x, y - 1, nextDirection);
    }

    public static int nextDirection(int type, int curDirection) {
        if (type == 0) return curDirection;
        else if (type == 1) {
            if (curDirection == 1 || curDirection == 3) return curDirection;
            return -1;
        } else if (type == 2) {
            if (curDirection == 2 || curDirection == 4) return curDirection;
            return -1;
        } else if (type == 3) {
            if (curDirection == 1) return 2;
            if (curDirection == 2) return 1;
            if (curDirection == 3) return 4;
            return 3;
        } else if (type == 4) {
            if (curDirection == 1) return 4;
            if (curDirection == 4) return 1;
            if (curDirection == 2) return 3;
            return 2;
        }
        throw new RuntimeException("오류");
    }
}
