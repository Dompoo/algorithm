import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*
0 40
5 10
15 30
*/
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        PriorityQueue<Long> queue = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        for (int i = 0; i < N - 1; i++) {
            queue.offer((long) (arr[i + 1] - arr[i]));
        }

        for (int i = 0; i < K - 1; i++) {
            queue.poll();
        }

        long result = queue.stream().reduce(0L, Long::sum);

        System.out.println(result);
    }
}
