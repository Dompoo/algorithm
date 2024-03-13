package B10991;

import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(in.readLine());

        for (int i = 0; i < N; i++) {
            //앞에 띄어쓰기 부분
            for (int j = 1; j < N - i; j++) {
                out.write(" ");
            }
            //별과 띄어쓰기 부분
            for (int j = 0; j <= i; j++) {
                out.write("*");
                if (j != i) {
                    out.write(" ");
                }
            }
            out.newLine();
        }
        out.flush();
    }
}
