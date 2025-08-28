import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(N);

        String[] inputs;
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                int target = Integer.parseInt(inputs[j]);
                if (queue.size() < N) {
                    queue.add(target);
                } else if (queue.size() == N && target > queue.peek()) {
                    queue.poll();
                    queue.add(target);
                }
            }
        }

        System.out.println(queue.poll());
    }
}
