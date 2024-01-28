package B14226;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static final int MAX_SIZE = 1001;

    static boolean[][] visited = new boolean[MAX_SIZE][MAX_SIZE];
    static int[][] minTime = new int[MAX_SIZE][MAX_SIZE];
    static Queue<int[]> q = new ArrayDeque<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        for (int i = 0; i < MAX_SIZE; i++) {
            Arrays.fill(minTime[i], Integer.MAX_VALUE);
        }

        q.offer(new int[]{1, 0});
        minTime[1][0] = 0;
        visited[1][0] = true;

        while (!q.isEmpty()) {
            int[] info = q.poll();
            int disp = info[0];
            int clip = info[1];
            int curMinTime = minTime[disp][clip];

            if (disp == target) {
                break;
            }

            //클립보드 저장
            if (!visited[disp][disp]) {
                q.offer(new int[]{disp, disp});
                minTime[disp][disp] = curMinTime + 1;
                visited[disp][disp] = true;
            }

            //클립보드 -> 디스플레이
            if (isInBound(disp+ clip) && !visited[disp + clip][clip]) {
                q.offer(new int[]{disp + clip, clip});
                minTime[disp + clip][clip] = curMinTime + 1;
                visited[disp + clip][clip] = true;
            }

            //디스플레이 1개 삭제
            if (isInBound(disp - 1) && !visited[disp - 1][clip]) {
                q.offer(new int[]{disp - 1, clip});
                minTime[disp - 1][clip] = curMinTime + 1;
                visited[disp - 1][clip] = true;
            }
        }

        int min = Integer.MAX_VALUE;
        for (int i = 0; i < MAX_SIZE; i++) {
            if (minTime[target][i] < min) {
                min = minTime[target][i];
            }
        }
        System.out.println(min);
    }

    static boolean isInBound(int n) {
        return 0 <= n && n < MAX_SIZE;
    }
}
