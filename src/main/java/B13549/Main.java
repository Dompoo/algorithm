package B13549;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX_SIZE = 100001;
        Queue<int[]> q = new ArrayDeque<>();
        int[] minTime = new int[MAX_SIZE];

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();

        Arrays.fill(minTime, Integer.MAX_VALUE);

        q.offer(new int[]{n, 0});

        while (!q.isEmpty()) {
            int[] info = q.poll();
            int x = info[0];
            int[] nx = new int[]{x + 1, x - 1, x * 2};
            int time = info[1];

            if (time < minTime[x]) {
                minTime[x] = time;
                for (int i = 0; i < 3; i++) {
                    if (0 <= nx[i] && nx[i] < MAX_SIZE) {
                        q.offer(new int[]{nx[i], i == 2 ? time : time + 1});
                    }
                }
            }
        }

        System.out.println(minTime[target]);
    }
}
