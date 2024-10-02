// n C r = n - 1 C r - 1 + n - 1 C r

// 재귀로 풀고 싶다...

import java.util.*;

class Main {

    private static int[][] dp = new int[34][34]; // 3 ~ 33

    private int calculate(int n, int r) {
        if(n == r) return 1;
        if(r == 0) return 1;

        // 아직 계산 안된 값
        if(dp[n][r] == 0) {
            dp[n][r] = calculate(n - 1, r) + calculate(n - 1, r - 1);
        }
        return dp[n][r];
    }

    private int solution(int n, int r) {
        
        for(int i = 1; i <= 33; i++) {
            dp[i][i] = 1;
            dp[i][0] = 1;
        }

        calculate(n, r);


        return dp[n][r];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(new Main().solution(n, r));
    }
}