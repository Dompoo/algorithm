import java.util.*;
import java.io.*;

/*
33 44 = 11 44 - 11 24 - 11 42 + 11 22
 */
class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int testcase = Integer.parseInt(s[1]);
		int[][] arr = new int[N + 1][N + 1];
		for (int i = 1; i <= N; i++) {
			String[] s2 = br.readLine().split(" ");
			for (int j = 1; j <= N; j++) {
				arr[i][j] = Integer.parseInt(s2[j - 1]);
			}
		}
		int[][] dp = new int[N + 1][N + 1]; // 1 1 ~ i j 까지합
		// dp에서 i j = i-1 j + i j-1 - i-1 j-1 + arr[i][j]
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + arr[i][j];
			}
		}
		
		StringBuilder sb = new StringBuilder();
		while(testcase-- > 0) {
			String[] s3 = br.readLine().split(" ");
			int x1 = Integer.parseInt(s3[0]);
			int y1 = Integer.parseInt(s3[1]);
			int x2 = Integer.parseInt(s3[2]);
			int y2 = Integer.parseInt(s3[3]);
			int result = dp[x2][y2] - dp[x1 - 1][y2] - dp[x2][y1 - 1] + dp[x1 - 1][y1 - 1];
			sb.append(result).append("\n");
		}
		System.out.print(sb);
	}
}