import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/*

 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        PriorityQueue<Long> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            long next = Long.parseLong(st.nextToken());
            minHeap.offer(next);
            maxHeap.offer(next);
        }


        long answer = 0;
        // 운동기구를 하나만 쓰는 날에는 최대한 큰걸 쓰는게 이득
        if (N % 2 == 1) {
            Long max = maxHeap.poll();
            minHeap.remove(max);
            answer = max;
        }
        while (!minHeap.isEmpty() || !maxHeap.isEmpty()) {
            Long min = minHeap.poll();
            Long max = maxHeap.poll();
            answer = Math.max(answer, min + max);
        }
        System.out.println(answer);
    }
}
