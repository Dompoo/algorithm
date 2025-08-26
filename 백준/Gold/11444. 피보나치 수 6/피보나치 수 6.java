import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger N = new BigInteger(br.readLine());

        int result = fibo(N);

        System.out.print(result);
    }

    private static final int MOD = 1_000_000_007;

    /*
    F(2k) = F(k) * (2*F(k+1) − F(k))
    F(2k+1) = F(k)^2 + F(k+1)^2
     */

    private static int fibo(BigInteger N) {
        long a = 0;
        long b = 1;
        long c, d;

        for (int i = N.bitLength() - 1; i >= 0; i--) {
            long twoBminusA = ((2 * b) % MOD - a + MOD) % MOD;
            c = (a * twoBminusA) % MOD;
            d = ((a * a) % MOD + (b * b) % MOD) % MOD;

            // 2) 해당 비트가 1이면 한 칸 전진(2k -> 2k+1)
            if (N.testBit(i)) {
                a = d;
                b = (c + d) % MOD;
            } else {
                a = c;
                b = d;
            }
        }
        return (int) a;
    }
}
