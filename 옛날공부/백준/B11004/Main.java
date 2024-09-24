package B11004;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer s = new StringTokenizer(in.readLine()," ");
        int N = Integer.parseInt(s.nextToken());
        int K = Integer.parseInt(s.nextToken());

        s = new StringTokenizer(in.readLine()," ");

        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(s.nextToken());
        }

        Arrays.sort(arr);

        out.write(arr[K - 1] + "\n");
        out.flush();
    }
}
