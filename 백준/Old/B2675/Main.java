package B2675;

import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        int T = Integer.parseInt(in.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer s = new StringTokenizer(in.readLine()," ");
            int N = Integer.parseInt(s.nextToken());
            String str = s.nextToken();


            for (int j = 0; j < str.length(); j++) {
                char curChar = str.charAt(j);
                for (int k = 0; k < N; k++) {
                    out.write(curChar);
                }
            }
            out.write("\n");
        }

        out.flush();
    }
}
