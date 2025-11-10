import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        boolean[][] fall = new boolean[N][M];
        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int point = 0;
        while (R-- > 0) {
            st = new StringTokenizer(br.readLine());
            int h = Integer.parseInt(st.nextToken()) - 1;
            int w = Integer.parseInt(st.nextToken()) - 1;
            String dir = st.nextToken();

            if (dir.equals("E")) {
                int end = w + arr[h][w] - 1;
                for (int i = w; i <= end && i < M; i++) {
                    if (!fall[h][i]) {
                        fall[h][i] = true;
                        end = Math.max(end, i + arr[h][i] - 1);
                        point++;
                    }
                }
            } else if (dir.equals("N")) {
                int end = h - arr[h][w] + 1;
                for (int i = h; i >= end && i >= 0; i--) {
                    if (!fall[i][w]) {
                        fall[i][w] = true;
                        end = Math.min(end, i - arr[i][w] + 1);
                        point++;
                    }
                }
            } else if (dir.equals("W")) {
                int end = w - arr[h][w] + 1;
                for (int i = w; i >= end && i >= 0; i--) {
                    if (!fall[h][i]) {
                        fall[h][i] = true;
                        end = Math.min(end, i - arr[h][i] + 1);
                        point++;
                    }
                }
            } else if (dir.equals("S")) {
                int end = h + arr[h][w] - 1;
                for (int i = h; i <= end && i < N; i++) {
                    if (!fall[i][w]) {
                        fall[i][w] = true;
                        end = Math.max(end, i + arr[i][w] - 1);
                        point++;
                    }
                }
            }

            // ---
            st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken()) - 1;
            w = Integer.parseInt(st.nextToken()) - 1;
            fall[h][w] = false;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(point).append("\n");
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(fall[i][j] ? "F" : "S").append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
