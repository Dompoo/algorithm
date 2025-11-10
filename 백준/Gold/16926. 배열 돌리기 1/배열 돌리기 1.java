import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = (Integer.parseInt(st.nextToken()));
        int layers = Math.min(N, M) / 2;

        int[][] arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        // 돌린다!
        for (int layer = 0; layer < layers; layer++) {
            List<Integer> list = new ArrayList<>();
            int top = layer;
            int bottom = M - layer - 1;
            int left = layer;
            int right = N - layer - 1;

            for (int i = left + 1; i <= right; i++) {
                list.add(arr[i][top]);
            }
            for (int i = top + 1; i <= bottom; i++) {
                list.add(arr[right][i]);
            }
            for (int i = right - 1; i >= left; i--) {
                list.add(arr[i][bottom]);
            }
            for (int i = bottom - 1; i >= top; i--) {
                list.add(arr[left][i]);
            }

            Collections.rotate(list, (R % list.size()));

            int index = 0;
            for (int i = left + 1; i <= right; i++) {
                arr[i][top] = list.get(index++);
            }
            for (int i = top + 1; i <= bottom; i++) {
                arr[right][i] = list.get(index++);
            }
            for (int i = right - 1; i >= left; i--) {
                arr[i][bottom] = list.get(index++);
            }
            for (int i = bottom - 1; i >= top; i--) {
                arr[left][i] = list.get(index++);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j] + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
