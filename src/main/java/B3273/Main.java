package B3273;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1000001;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(in.readLine());

        int[] arr = new int[MAX];

        StringTokenizer s = new StringTokenizer(in.readLine()," ");
        for (int i = 0; i < N; i++) {
            arr[Integer.parseInt(s.nextToken())]++;
        }

        int K = Integer.parseInt(in.readLine());

        int ans = 0;

        //최대 시간 복잡도 O(N)
        for (int i = 1; i < K; i++) {
            int i2 = K - i;
            // i, i2 는 1 ~ K -1 의 범위에 놓인다.
            if (i < MAX && i2 < MAX) {
                ans += arr[i] * arr[i2];
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(ans / 2 + "\n");
        bw.flush();
    }
}
