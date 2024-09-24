package B13913;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] way;
    static boolean isFirst = true;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int target = sc.nextInt();

        final int MAX_SIZE = 100001;
        boolean[] check = new boolean[MAX_SIZE];
        int[] time = new int[MAX_SIZE];
        way = new int[MAX_SIZE];
        Queue<Integer> q = new ArrayDeque<>();

        q.offer(start);
        check[start] = true;

        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == target) {
                break;
            }
            //목적지에 도달하지 못했을 경우에만 큐 삽입
            for (int nx : new int[]{x + 1, x - 1, x * 2}) {
                if (0 <= nx && nx < MAX_SIZE && !check[nx]) {
                    q.offer(nx);
                    check[nx] = true;
                    time[nx] = time[x] + 1;
                    way[nx] = x;
                }
            }
        }

        System.out.println(time[target]);
        printPath(start, target);
        System.out.println();
    }

    public static void printPath(int n, int m) {
        if (n != m) {
            printPath(n, way[m]);
        }
        if (isFirst) {
            isFirst = false;
            System.out.print(m);
        } else {
            System.out.print(" " + m);
        }
    }
}
