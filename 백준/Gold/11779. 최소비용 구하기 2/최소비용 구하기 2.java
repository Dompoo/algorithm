import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {
        input();
        System.out.print(solution());
    }

    private static final int INF_BUS_FEE = 1_000_000_000;

    private static int CITY_COUNT;
    private static int BUS_COUNT;
    private static int[][] BUS_FEES;
    private static int START_CITY;
    private static int END_CITY;

    private static void input() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        CITY_COUNT = Integer.parseInt(br.readLine());
        BUS_COUNT = Integer.parseInt(br.readLine());

        BUS_FEES = new int[CITY_COUNT + 1][CITY_COUNT + 1];
        for (int i = 0; i <= CITY_COUNT; i++) {
            Arrays.fill(BUS_FEES[i], INF_BUS_FEE);
        }
        String[] inputs;
        for (int i = 0; i < BUS_COUNT; i++) {
            inputs = br.readLine().split(" ");
            int startCity = Integer.parseInt(inputs[0]);
            int endCity = Integer.parseInt(inputs[1]);
            int busFee = Integer.parseInt(inputs[2]);
            BUS_FEES[startCity][endCity] = Math.min(busFee, BUS_FEES[startCity][endCity]);
        }
        for (int i = 1; i <= CITY_COUNT; i++) BUS_FEES[i][i] = 0;

        inputs = br.readLine().split(" ");
        START_CITY = Integer.parseInt(inputs[0]);
        END_CITY = Integer.parseInt(inputs[1]);
    }

    private static String solution() {
        int[] dist = new int[CITY_COUNT + 1];
        int[] prev = new int[CITY_COUNT + 1];
        boolean[] visited = new boolean[CITY_COUNT + 1];

        Arrays.fill(dist, INF_BUS_FEE);
        Arrays.fill(prev, -1);
        dist[START_CITY] = 0;

        while (true) {
            int u = -1;
            int best = INF_BUS_FEE;
            for (int i = 1; i <= CITY_COUNT; i++) {
                if (!visited[i] && dist[i] < best) {
                    u = i;
                    best = dist[i];
                }
            }

            if (u == -1) break;
            visited[u] = true;

            for (int v = 1; v <= CITY_COUNT; v++) {
                if (BUS_FEES[u][v] == INF_BUS_FEE) continue;

                if (dist[u] + BUS_FEES[u][v] < dist[v]) {
                    dist[v] = dist[u] + BUS_FEES[u][v];
                    prev[v] = u;
                }
            }
        }

        List<Integer> path = new ArrayList<>();
        for (int cur = END_CITY; cur != -1; cur = prev[cur]) path.add(cur);
        Collections.reverse(path);

        StringBuilder sb = new StringBuilder();
        sb.append(dist[END_CITY]).append("\n");
        sb.append(path.size()).append("\n");
        for (int i = 0; i < path.size(); i++) {
            sb.append(path.get(i));
            if (i < path.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}
