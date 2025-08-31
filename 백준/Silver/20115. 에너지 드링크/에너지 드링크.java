import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        PriorityQueue<Double> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            pq.offer(Double.parseDouble(st.nextToken()));
        }
        double result = 0;
        while (pq.size() > 1) {
            result += pq.poll() / 2;
        }
        result += pq.poll();
        System.out.println(result);
    }
}
