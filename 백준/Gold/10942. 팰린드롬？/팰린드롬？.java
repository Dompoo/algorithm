import java.io.*;
import java.util.*;

public class Main {
    
    static int N;
    static int[] arr;
    static boolean[][] dp;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        
        dp = new boolean[N + 1][N + 1];
        
        fillDP();
        
        int M = Integer.parseInt(br.readLine());
        
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
            sb.append(dp[S][E] ? "1\n" : "0\n");
        }
        
        System.out.print(sb);
    }
    
    private static void fillDP() {
        for (int i = 1; i <= N; i++) {
            dp[i][i] = true;
        }
        
        for (int i = 1; i < N; i++) {
            if (arr[i] == arr[i + 1]) {
                dp[i][i + 1] = true;
            }
        }
        
        for (int len = 3; len <= N; len++) {
            for (int left = 1; left <= N - len + 1; left++) {
                int right = left + len - 1;
                if (arr[left] == arr[right] && dp[left + 1][right - 1]) {
                    dp[left][right] = true;
                }
            }
        }
    }
}
