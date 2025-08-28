import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((i1, i2) -> i2 - i1);
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int input = Integer.parseInt(br.readLine());
            if (input == 0) {
                Integer polled = pq.poll();
                if (polled == null) {
                    sb.append("0").append("\n");
                } else {
                    sb.append(polled).append("\n");
                }
            } else {
                pq.offer(input);
            }
        }
        System.out.print(sb);
    }
}
