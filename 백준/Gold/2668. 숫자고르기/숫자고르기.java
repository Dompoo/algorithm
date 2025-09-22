import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

//https://www.acmicpc.net/problem/13023
@SuppressWarnings("ALL")
public class Main {

    static int N;
    static List<Integer>[] graph;
    static Set<Integer> loopSet = new HashSet<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new List[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int from = 0; from < N; from++) {
            int to = Integer.parseInt(br.readLine()) - 1;
            graph[from].add(to);
        }

        for (int i = 0; i < N; i++) {
            boolean[] visitied = new boolean[N];
            visitied[i] = true;
            checkLoop(i, i, visitied);
        }

        StringBuilder sb = new StringBuilder();
        sb.append(loopSet.size()).append("\n");
        loopSet.stream().sorted().forEach(i -> sb.append(i).append("\n"));
        System.out.print(sb);
    }

    public static void checkLoop(int start, int last, boolean[] visited) {
        for (int next : graph[last]) {
            if (next == start) {
                // 루프 완성됨, 해당 리스트를 넣기
                for (int i = 0; i < N; i++) if (visited[i]) loopSet.add(i + 1);
            } else {
                if (visited[next]) continue;
                visited[next] = true;
                checkLoop(start, next, visited);
                visited[next] = false;
            }
        }
    }
}
