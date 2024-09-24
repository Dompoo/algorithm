package B1236;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(s.nextToken());
        int M = Integer.parseInt(s.nextToken());

        boolean[] guardX = new boolean[N];
        boolean[] guardY = new boolean[M];

        for (int i = 0; i < N; i++) {
            s = new StringTokenizer(in.readLine()," ");
            String str = s.nextToken();
            for (int j = 0; j < M; j++) {
                char ch = str.charAt(j);
                if (ch == 'X') {
                    guardX[i] = true;
                    guardY[j] = true;
                }
            }
        }

        int needGuardX = 0;
        for (int i = 0; i < N; i++) {
            if (!guardX[i]) needGuardX++;
        }

        int needGuardY = 0;
        for (int i = 0; i < M; i++) {
            if (!guardY[i]) needGuardY++;
        }

        System.out.println(Math.max(needGuardX, needGuardY));
    }
}
