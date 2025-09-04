import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> prices = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            prices.add(Integer.parseInt(st.nextToken()));
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] = Math.max(dp[i], dp[i - j] + prices.get(j - 1));
            }
            /*
            5
            1 dp[4] + p[1]
            2 dp[3] + p[2] <
            3 dp[2] + p[3] <
            4 dp[1] + p[4]
            5 dp[0] + 
             */
        }

        System.out.println(dp[n]);
    }
}
