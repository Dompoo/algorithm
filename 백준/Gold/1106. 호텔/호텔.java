import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int maxClient = Integer.MIN_VALUE;
        int[][] arr = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int client = Integer.parseInt(st.nextToken());
            maxClient = Math.max(maxClient, client);
            arr[i] = new int[]{cost, client};
        }

        int[] minCost = new int[C + maxClient];
        Arrays.fill(minCost, -9);
        minCost[0] = 0;
        for (int i = 1; i < C + maxClient; i++) {
            for (int cityIndex = 0; cityIndex < N; cityIndex++) {
                int cost = arr[cityIndex][0];
                int client = arr[cityIndex][1];
                if (i - client < 0 || minCost[i - client] == -9) continue; // cityIndex번째 도시를 경유하는 상황이 불가능하면 포기

                int currentCost = minCost[i - client] + cost; // cityIndex번째 도시를 경유하고, 나머지 고객은 최적화했을 때의 cost

                if (minCost[i] == -9) minCost[i] = currentCost; // 해당 minCost를 계산한적 없다면 무조건 삽입
                else minCost[i] = Math.min(minCost[i], currentCost);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = C; i < C + maxClient; i++) {
            if (minCost[i] == -9) continue;
            result = Math.min(result, minCost[i]);
        }
        System.out.println(result);
    }
}
