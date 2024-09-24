package B9252;

import java.util.Scanner;

public class Main {
    static int[][] dp;
    static String str1;
    static String str2;
    static int N;
    static int M;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        str1 = sc.next();
        str2 = sc.next();

        N = str1.length();
        M = str2.length();

        //str1의 i번째 글자가 str2의 j번째 글자와 매칭되었을 때, 길이
        dp = new int[N + 1][M + 1];

        //dp 채우기
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i + 1][j + 1] = dp[i][j] + 1;
                } else {
                    dp[i + 1][j + 1] = Math.max(dp[i][j + 1], dp[i + 1][j]);
                }
            }
        }
        
        //dp 출력
        System.out.println(dp[N][M]);
        print(N, M);
        System.out.println();
    }

    public static void print(int i, int j) {
        if (dp[i][j] == 0) {
            return;
        } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
            print(i - 1, j - 1);
            System.out.print(str1.charAt(i-1));
        } else {
            if (dp[i - 1][j] > dp[i][j - 1]) {
                print(i - 1, j);
            } else {
                print(i, j - 1);
            }
        }
    }
    
}
