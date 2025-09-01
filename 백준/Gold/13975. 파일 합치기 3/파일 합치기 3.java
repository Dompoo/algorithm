import java.io.*;
import java.util.*;

/*
10 a
20 b
40 c
50 d

(a+b) + (a+b+c) + (a+b+c+d)
10 20   10 20 40


최대 + 가장큰거 빼고 + 2번째로 큰거 뺴고 + ... (2개까지)
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int N = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            PriorityQueue<Long> pq = new PriorityQueue<>();
            for (int i = 0; i < N; i++) {
                long current = Long.parseLong(st.nextToken());
                pq.offer(current);
            }

            long answer = 0;
            while (pq.size() > 1) {
                Long i1 = pq.poll();
                Long i2 = pq.poll();
                answer += i1;
                answer += i2;
                pq.offer(i1 + i2);
            }
            System.out.println(answer);
        }
    }
}
