package B12026;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        String str = sc.next();

        int[] dp = new int[N];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;

        for (int i = 0; i < N; i++) {
            char cur = str.charAt(i);
            char nextChar;

            if (cur == 'B') {
                nextChar = 'O';
            } else if (cur == 'O') {
                nextChar = 'J';
            } else {
                nextChar = 'B';
            }

            for (int j = i + 1; j < N; j++) {
                if (str.charAt(j) == nextChar) {
                    dp[j] = (int) Math.min(dp[j], dp[i] + Math.pow(j - i, 2));
                }
            }
        }

        if (dp[N - 1] == Integer.MAX_VALUE) {
            System.out.println(-1);
        } else {
            System.out.println(dp[N - 1]);
        }
    }
}
