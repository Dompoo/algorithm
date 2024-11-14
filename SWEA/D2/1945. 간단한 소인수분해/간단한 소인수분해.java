import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= testcase; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            
            int a = 0; //2
            int b = 0; //3
            int c = 0; //5
            int d = 0; //7
            int e = 0; //11
            
            while(N % 2 == 0) {
                N /= 2;
                a++;
            }
            while(N % 3 == 0) {
                N /= 3;
                b++;
            }
            while(N % 5 == 0) {
                N /= 5;
                c++;
            }
            while(N % 7 == 0) {
                N /= 7;
                d++;
            }
            while(N % 11 == 0) {
                N /= 11;
                e++;
            }
            
            sb.append("#").append(t);
            sb.append(" ").append(a);
            sb.append(" ").append(b);
            sb.append(" ").append(c);
            sb.append(" ").append(d);
            sb.append(" ").append(e);
            sb.append("\n");
        } //tc 끝
        System.out.print(sb);
    }
}