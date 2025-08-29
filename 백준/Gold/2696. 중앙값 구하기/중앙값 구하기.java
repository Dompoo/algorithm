import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
A+B*C-D/E


ABC*+DE-/

 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        List<Integer> list = new ArrayList<>();
        while (T-- > 0) {

            int count = Integer.parseInt(br.readLine());

            MedianQueue medianQueue = new MedianQueue();
            for (int i = 0; i < count; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                int number = Integer.parseInt(st.nextToken());
                medianQueue.add(number);
                if (i % 2 == 0) {
                    int result = medianQueue.median();
                    list.add(result);
                }
            }

            sb.append(list.size());
            for (int i = 0; i < list.size(); i++) {
                if (i % 10 == 0) {
                    sb.append("\n");
                }
                sb.append(list.get(i)).append(" ");
            }
            sb.append("\n");
            list.clear();
        }
        System.out.println(sb);
    }

    // 입력 수 중복 가능
    /*
    1 2 3 4 5 6 7 8 9


    max 3 2 1
    min 4 5
     */
    static class MedianQueue {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public void add(int number) {
            maxHeap.offer(number);
            minHeap.offer(maxHeap.poll());
            if (maxHeap.size() < minHeap.size()) { // 균형 맞추기
                maxHeap.offer(minHeap.poll());
            }
        }

        public int median() {
            if (maxHeap.size() == minHeap.size()) {
                throw new IllegalStateException();
            } else {
                return maxHeap.peek();
            }
        }
    }
}
