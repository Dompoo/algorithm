package B1038;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Queue<Integer> deque = new ArrayDeque<>();
        int count = -1;

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if (n > 1021) {
            System.out.println(-1);
            System.exit(0);
        }

        for (int i = 0; i < 10; i++) {
            deque.offer(i);
        }

        while (!deque.isEmpty()) {
            int curNum = deque.poll();
            count++;

            if (count == n) {
                System.out.println(curNum);
                return;
            }

            for (int i = 0; i < curNum % 10; i++) {
                deque.offer(curNum * 10 + i);
            }
        }
    }
}
