package B2281;

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int M;
    static int[] name;
    static int[] dp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();
        name = new int[N];
        dp = new int[N];

        for (int i = 0; i < N; i++) {
            name[i] = sc.nextInt();
        }

        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[N - 1] = 0; // 마지막 단어는 무조건 마지막 줄 -> 비용 0

        System.out.println(getDP(0));
    }

    public static int getDP(int step) {

        if (dp[step] != Integer.MAX_VALUE) { //이미 계산된 경우
            return dp[step];
        }

        int remain = M - name[step];

        for (int i = step + 1; i <= N && remain >= 0; i++) {
            if (i == N) { //해당 칸에 다 적어버린 경우
                dp[step] = 0;
                break;
            }

            dp[step] = Math.min(dp[step], remain * remain + getDP(i));
            remain -= (name[i] + 1);
        }

        return dp[step];
    }
}
