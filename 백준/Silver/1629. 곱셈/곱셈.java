import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] inputs = br.readLine().split(" ");
        int A = Integer.parseInt(inputs[0]);
        int B = Integer.parseInt(inputs[1]);
        int C = Integer.parseInt(inputs[2]);

        System.out.print(pow(A, B, C));
    }

    public static long pow(int a, int b, int c) {
        if (b == 0) return 1 % c;
        if (b == 1) return a % c;
        
        long x = pow(a, b / 2, c);
        long res = (x * x) % c;

        if ((b & 1) == 1) {
            res = (res * (a % c)) % c; // a도 줄여서 곱하기
        }

        return res;
    }
}
