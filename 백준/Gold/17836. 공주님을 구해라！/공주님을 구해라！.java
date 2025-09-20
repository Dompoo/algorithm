import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/17836
@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        int[][] castle = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};

        int[][][] minTime = new int[N][M][2];
        Hero initHero = new Hero(0, 0, false, 0);
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                minTime[i][j][0] = Integer.MAX_VALUE;
                minTime[i][j][1] = Integer.MAX_VALUE;
            }
        }
        minTime[0][0][0] = 0;
        Deque<Hero> heroes = new ArrayDeque<>();
        heroes.addLast(initHero);
        while (!heroes.isEmpty()) {
            Hero current = heroes.pollFirst();
            for (int i = 0; i < 4; i++) {
                int nx = current.x + dx[i];
                int ny = current.y + dy[i];
                if (nx < 0 || nx >= N || ny < 0 || ny >= M) continue;
                if (!current.hasGram && castle[nx][ny] == 1) continue;
                boolean gonnaHasGram = current.hasGram || castle[nx][ny] == 2;
                if (minTime[nx][ny][gonnaHasGram ? 1 : 0] <= current.time + 1) continue;
                heroes.addLast(new Hero(nx, ny, gonnaHasGram, current.time + 1));
                minTime[nx][ny][gonnaHasGram ? 1 : 0] = current.time + 1;
            }
        }
        int min = Math.min(minTime[N - 1][M - 1][0], minTime[N - 1][M - 1][1]);
        if (min == Integer.MAX_VALUE || min > T) {
            System.out.println("Fail");
        } else {
            System.out.println(min);
        }
    }

    static class Hero {

        int x;
        int y;
        boolean hasGram;
        int time;

        Hero(int x, int y, boolean hasGram, int time) {
            this.x = x;
            this.y = y;
            this.hasGram = hasGram;
            this.time = time;
        }
    }
}
