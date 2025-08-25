import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = br.readLine();
        String str2 = br.readLine();

        int result = solution(str1, str2);

        System.out.print(result);
    }

    private static int solution(String str1, String str2) {
        int N = str1.length();
        int M = str2.length();
        int[][] dp = new int[N + 1][M + 1];
        for (int i = 0; i <= N; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i <= M; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i <= N; i++) {
            char ca = str1.charAt(i - 1);
            for (int j = 1; j <= M; j++) {
                char cb = str2.charAt(j - 1);
                if (ca == cb) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[N][M];
    }
}
