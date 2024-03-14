package B10448;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        int[] triangle = new int[1001]; //삼각형 수 1 ~ 1000
        for (int i = 1; i < 1001; i++) {
            triangle[i] = triangle[i - 1] + i;
        }

        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(in.readLine());
        for (int t = 0; t < T; t++) {
            int K = Integer.parseInt(in.readLine());
            int possible = 0;

            //K는 세개의 삼각형 수가 될 수 있을 것인가?
            for (int i = 1; i <= K - 2 && possible == 0; i++) {
                for (int j = 1; j <= K - 2 && possible == 0; j++) {
                    for (int k = 1; k <= K - 2 && possible == 0; k++) {
                        if (triangle[i] + triangle[j] + triangle[k] == K) possible = 1;
                    }
                }
            }

            out.write(possible + "\n");
        }

        out.flush();
    }
}
