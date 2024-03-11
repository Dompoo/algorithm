package B10158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int maxX;
    static int maxY;

    static int curX;
    static int curY;

    static int time;

    public static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(in.readLine()," ");
        maxX = Integer.parseInt(s.nextToken());
        maxY = Integer.parseInt(s.nextToken());

        s = new StringTokenizer(in.readLine()," ");
        curX = Integer.parseInt(s.nextToken());
        curY = Integer.parseInt(s.nextToken());

        s = new StringTokenizer(in.readLine()," ");
        time = Integer.parseInt(s.nextToken());
    }

    public static void solve() {
        int timeX = time % (maxX * 2);
        int dx = 1;
        for (int i = 0; i < timeX; i++) {
            if (curX + dx > maxX || curX + dx < 0) {
                dx = -dx;
            }
            curX += dx;
        }

        int timeY = time % (maxY * 2);
        int dy = 1;
        for (int i = 0; i < timeY; i++) {
            if (curY + dy > maxY || curY + dy < 0) {
                dy = -dy;
            }
            curY += dy;
        }
    }

    public static void output() {
        System.out.printf("%d %d\n", curX, curY);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }
}
