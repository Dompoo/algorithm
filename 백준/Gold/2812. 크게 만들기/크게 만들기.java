import java.io.*;
import java.util.*;

/*
10 4
4177252841

4
4177252841

41   7!!

K = 3
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        char[] input = br.readLine().toCharArray();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = input[i] - '0';
        }

        Deque<Integer> deque = new ArrayDeque<>();
        deque.push(arr[0]);
        for (int i = 1; i < N; i++) {
            int current = arr[i];
            if (deque.peek() < current) {
                while (!deque.isEmpty() && deque.peek() < current && K != 0) {
                    deque.pop();
                    K--;
                }
            }
            deque.push(current);
        }

        while (K-- > 0) {
            deque.pop();
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }
        System.out.println(sb);
    }
}
