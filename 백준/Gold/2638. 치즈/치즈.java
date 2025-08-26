import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    private static final int EMPTY = 0;

    /*
8 9
0 0 0 0 0 0 0 0 0
0 0 0 0 0 0 0 0 0
0 1 1 0 0 0 1 1 0
0 1 0 1 1 1 0 1 0
0 1 0 0 1 0 0 1 0
0 1 0 1 1 1 0 1 0
0 1 1 0 0 0 1 1 0
0 0 0 0 0 0 0 0 0

    4방향 중에 2방향 이상이 0인 치즈 조각에 대해서만
    해당 0인 칸들이 실제 밖으로 이어지는 0인지, 아니면 내부에 갇힌 0인지 확인해야 한다.
    밖으로 이어지는 0의 개수가 또한 2개 이상이라면 해당 치즈는 제거해야 한다.
     */

    private static int N;
    private static int M;
    private static final int CHEESE = 1;
    private static final int OUTER = 2;
    private static final int[] DX = new int[]{0, 0, 1, -1};
    private static final int[] DY = new int[]{1, -1, 0, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        M = Integer.parseInt(inputs[1]);
        int[][] arr = new int[N][M];

        int cheeseCount = 0;
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < M; j++) {
                int input = Integer.parseInt(inputs[j]);
                if (input == 1) cheeseCount++;
                arr[i][j] = input;
            }
        }

        int fullMeltTime = 0;

        while (cheeseCount > 0) {
            fullMeltTime++;

            // 0 : 빈 공간
            // 1 : 치즈
            // 2 : 외부와 연결된 공간
            int[][] nextArr = new int[N][M];
            for (int x = 0; x < N; x++) {
                for (int y = 0; y < M; y++) {
                    if (arr[x][y] == CHEESE) {
                        nextArr[x][y] = CHEESE;
                    }
                    if (isOuterPosition(x, y)) {
                        nextArr[x][y] = OUTER;
                    }
                }
            }
            fillConnectedToOuter(nextArr);

            // 테스트용 출력
//            StringBuilder sb = new StringBuilder();
//            for (int i = 0; i < N; i++) {
//                for (int j = 0; j < M; j++) {
//                    char out;
//                    if (nextArr[i][j] == 0) {
//                        out = ' ';
//                    } else if (nextArr[i][j] == 1) {
//                        out = 'c';
//                    } else {
//                        out = '*';
//                    }
//                    sb.append(out).append(" ");
//                }
//                sb.append("\n");
//            }
//            System.out.println(sb);

            for (int x = 1; x < N - 1; x++) {
                for (int y = 1; y < M - 1; y++) {
                    if (nextArr[x][y] == 0 || nextArr[x][y] == 2) continue;

                    // 4방향을 체크한다.
                    int outerCount = 0;
                    for (int i = 0; i < 4; i++) {
                        int nx = x + DX[i];
                        int ny = y + DY[i];
                        if (nextArr[nx][ny] == OUTER) {
                            outerCount++;
                        }
                    }

                    // 2개 이상이라면 녹는다.
                    if (outerCount >= 2) {
                        nextArr[x][y] = EMPTY;
                        cheeseCount--;
                    }
                }
            }

            arr = nextArr;
        }

        System.out.print(fullMeltTime);
    }

    private static void fillConnectedToOuter(int[][] arr) {
        Queue<Point> queue = new ArrayDeque<>();
        boolean[][] checked = new boolean[N][M];

        for (int j = 0; j < M; j++) {
            queue.offer(new Point(0, j));
            checked[0][j] = true;
            queue.offer(new Point(N - 1, j));
            checked[N - 1][j] = true;
        }
        for (int i = 0; i < N; i++) {
            queue.offer(new Point(i, 0));
            checked[i][0] = true;
            queue.offer(new Point(i, M - 1));
            checked[i][M - 1] = true;
        }

        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = curPoint.x + DX[i];
                int ny = curPoint.y + DY[i];

                if (isOutOfArray(nx, ny)) continue;
                if (checked[nx][ny]) continue;
                checked[nx][ny] = true;

                if (arr[nx][ny] == EMPTY) {
                    arr[nx][ny] = OUTER;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    private static boolean isOutOfArray(int x, int y) {
        return x < 0 || x > N - 1 || y < 0 || y > M - 1;
    }

    private static boolean isOuterPosition(int x, int y) {
        return x == 0 || x == N - 1 || y == 0 || y == M - 1;
    }
}
