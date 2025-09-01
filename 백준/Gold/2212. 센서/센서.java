import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
0 40
5 10
15 30
*/
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        List<Integer> list = new ArrayList<>(set);
        Collections.sort(list);

        PriorityQueue<Integer> diffs = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < list.size() - 1; i++) {
            int diff = list.get(i + 1) - list.get(i);
            diffs.offer(diff);
        }

        for (int i = 0; i < K - 1; i++) {
            diffs.poll();
        }

        Integer result = diffs.stream().reduce(0, Integer::sum);
        System.out.println(result);
    }
}
