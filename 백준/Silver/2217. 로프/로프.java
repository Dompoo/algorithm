import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

/*
6 10 15
---
6 3 -> 18
10 3 -> 30
15 3 -> 45
3개 다 쓰면 18
---
10 2 -> 20
15 2 -> 30
2개만 쓰면 20!!!
어카노...
---
큰 순으로 정렬
15 -> 15*1 = 15
15 10 -> 10*2 = 20
15 10 6 -> 6*3 = 18
15 10 6 5 -> 5*4 = 20
 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> queue = new PriorityQueue<>(); // 작은 순으로 정렬

        while (N-- > 0) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        int maxWeight = Integer.MIN_VALUE;
        while (!queue.isEmpty()) {
            int currentMin = queue.peek();// 가장 가벼운걸 확인
            maxWeight = Math.max(maxWeight, currentMin * queue.size());
            queue.poll();
        }

        System.out.println(maxWeight);
    }
}
