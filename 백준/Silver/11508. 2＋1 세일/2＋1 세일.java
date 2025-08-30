import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

/*
6
4
5
5
5
5

3개 꾸러미 -> 비싼거 2개만 지불하면 OK
공짜를 최대한 비싼걸 해야함, 근데 가장 비싼거 2개는 지불해야 하니까
(1등, 2등, 3등(공짜)) 꾸러미가 이득임
 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        while (N-- > 0) {
            queue.offer(Integer.parseInt(br.readLine()));
        }

        long answer = 0;

        // 비싼거부터 공짜로 보낸다.
        while (queue.size() >= 3) {
            int n1 = queue.poll();
            int n2 = queue.poll();
            queue.poll();
            answer += n1;
            answer += n2;
        }

        // 나머지는 돈주고 사야한다.
        while (!queue.isEmpty()) {
            int n = queue.poll();
            answer += n;
        }

        System.out.println(answer);
    }
}
