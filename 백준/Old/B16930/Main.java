package B16930;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] info;
    static int x, y;
    static int nx, ny, nk;
    static int[] dx = new int[]{-1, 0, +1, 0};
    static int[] dy = new int[]{0, +1, 0, -1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); //행개수
        int m = sc.nextInt(); //열개수
        int k = sc.nextInt(); //최대 이동길이

        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = sc.next().toCharArray();
        }

        int startX = sc.nextInt() - 1;
        int startY = sc.nextInt() - 1;
        int endX = sc.nextInt() - 1;
        int endY = sc.nextInt() - 1;

        int[][] minTime = new int[n][m]; // x , y
        for (int i = 0; i < n; i++) {
            Arrays.fill(minTime[i], Integer.MAX_VALUE);
        }

        Queue<int[]> q = new ArrayDeque<>();
        minTime[startX][startY] = 0;
        q.offer(new int[]{startX, startY});

        while (!q.isEmpty()) {
            info = q.poll();
            x = info[0];
            y = info[1];

            for (int i = 0; i < 4; i++) {
                nx = x + dx[i];
                ny = y + dy[i];
                nk = 1;

                while (nk <= k
                        && 0 <= nx && nx < n //nx가 map을 넘어가지 않는지 확인
                        && 0 <= ny && ny < m //ny가 map을 넘어가지 않는지 확인
                        && minTime[nx][ny] > minTime[x][y] //앞으로 이동할 곳이 더 작다면 연산 필요 없음 -> 속도 향상
                        && map[nx][ny] == '.') //map에서 막혀있지 않는다면, 조금씩 증가하므로 막히면 바로 while문 나가짐
                {
                    //새로 밟는 곳이면 추가, 아니면 일단 넘어감
                    if (minTime[nx][ny] == Integer.MAX_VALUE) {
                        minTime[nx][ny] = minTime[x][y] + 1;
                        q.offer(new int[]{nx, ny});
                    }
                    nx += dx[i];
                    ny += dy[i];
                    nk++;
                }

            }
        }

        if (minTime[endX][endY] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(minTime[endX][endY]);
        }
    }
}
