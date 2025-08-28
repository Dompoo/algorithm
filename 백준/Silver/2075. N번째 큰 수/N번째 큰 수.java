import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>((o1, o2) -> o2 - o1);

        String[] inputs;
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                queue.add(Integer.parseInt(inputs[j]));
            }
        }

        for (int i = 0; i < N - 1; i++) {
            queue.poll();
        }


        System.out.println(queue.poll());
    }
}
