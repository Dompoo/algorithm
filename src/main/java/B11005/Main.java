package B11005;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(in.readLine()," ");

        int N = Integer.parseInt(s.nextToken()); // 변환할 수
        int B = Integer.parseInt(s.nextToken()); // 진법
        String str = "";

        do {
            int D = N % B;
            if (D < 10) str += D;
            else str += (char) ('A' + D - 10);

            N /= B;
        } while (N > 0);

        for (int i = str.length() - 1; i >= 0; i--) {
            System.out.print(str.charAt(i));
        }

        System.out.println();
    }
}
