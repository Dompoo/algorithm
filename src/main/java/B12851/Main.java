package B12851;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int MAX_SIZE = 100001;
    static int target;
    static int[] minTime = new int[MAX_SIZE];
    static int[] arrival = new int[MAX_SIZE];
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        target = sc.nextInt();

        Arrays.fill(minTime, Integer.MAX_VALUE);

        q.offer(new int[]{n, 0});

        while (!q.isEmpty()) {
            int[] info = q.poll();
            int x = info[0];
            int[] nx = new int[]{x + 1, x * 2, x - 1};
            int time = info[1];

            if (minTime[x] < time) {
                continue;
            } else if (minTime[x] == time) {
                arrival[x]++;
            } else {
                minTime[x] = time;
                arrival[x] = 1;
            }

            for (int i = 0; i < 3; i++) {
                if (0 <= nx[i] && nx[i] < MAX_SIZE) {
                    q.offer(new int[]{nx[i], time + 1});
                }
            }

        }

        System.out.println(minTime[target]);
        System.out.println(arrival[target]);
    }
}
