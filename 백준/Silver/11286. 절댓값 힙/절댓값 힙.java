import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        Comparator<Integer> mycomp = (i1, i2) -> {
            int abs1 = Math.abs(i1);
            int abs2 = Math.abs(i2);
            if (abs1 != abs2) {
                return abs1 - abs2;
            } else {
                return i1 - i2;
            }
        };
        PriorityQueue<Integer> pq = new PriorityQueue<>(mycomp);
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
