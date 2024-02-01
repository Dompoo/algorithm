package B12101;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt() - 1;

        if (K >= 504) {
            System.out.println(-1);
            System.exit(0);
        }

        ArrayList<String>[] dp = new ArrayList[N + 3];

        for (int i = 0; i < N + 3; i++) {
            dp[i] = new ArrayList<String>();
        }

        //점화식으로 구하기
        dp[1].add("1");
        dp[2].add("1+1");
        dp[2].add("2");
        dp[3].add("1+1+1");
        dp[3].add("1+2");
        dp[3].add("2+1");
        dp[3].add("3");

        for (int i = 4; i <= N; i++) {
            for (int j = 1; j <= 3; j++) {
                for (String str : dp[i - j]) {
                    dp[i].add(str + "+" + j);
                }
            }
        }

        if (dp[N].size() <= K) {
            System.out.println(-1);
        } else {
            Collections.sort(dp[N]);
            System.out.println(dp[N].get(K));
        }

    }
}
