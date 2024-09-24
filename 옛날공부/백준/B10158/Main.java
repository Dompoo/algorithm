package B10158;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static int maxX;
    static int maxY;

    static int X;
    static int Y;

    static int time;

    static int ansX;
    static int ansY;

    public static void input() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(in.readLine()," ");
        maxX = Integer.parseInt(s.nextToken());
        maxY = Integer.parseInt(s.nextToken());

        s = new StringTokenizer(in.readLine()," ");
        X = Integer.parseInt(s.nextToken());
        Y = Integer.parseInt(s.nextToken());

        s = new StringTokenizer(in.readLine()," ");
        time = Integer.parseInt(s.nextToken());
    }

    public static void solve() {
        ansX = (X + time) % (maxX * 2);
        if (ansX > maxX) {
            ansX = (maxX * 2) - ansX;
        }

        ansY = (Y + time) % (maxY * 2);
        if (ansY > maxY) {
            ansY = (maxY * 2) - ansY;
        }
    }

    public static void output() {
        System.out.printf("%d %d\n", ansX, ansY);
    }

    public static void main(String[] args) throws IOException {
        input();
        solve();
        output();
    }
}
