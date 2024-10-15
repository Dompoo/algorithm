import java.util.*;
import java.io.*;

/*
3
5
50 10 100 20 40
30 50 70 10 60
7
10 30 10 50 100 20 40
20 40 30 50 60 20 80
1
20
30
 */
class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine());
		StringBuilder result = new StringBuilder();
		while(testcase-- > 0) {
			int N = Integer.parseInt(br.readLine());
			int[][] point = new int[N][2];
			String[] up = br.readLine().split(" ");
			String[] down = br.readLine().split(" ");
			for (int i = 0; i < N; i++) {
				point[i][0] = Integer.parseInt(up[i]);
				point[i][1] = Integer.parseInt(down[i]);
			}
			if (N == 1) {
				result.append(Math.max(point[0][0], point[0][1])).append("\n");
				continue;
			}
			
			int[][] dp = new int[N][2];
			dp[0][0] = point[0][0];
			dp[0][1] = point[0][1];
			dp[1][1] = point[1][1] + point[0][0];
			dp[1][0] = point[1][0] + point[0][1];
			for (int i = 2; i < N; i++) {
				// [i][0] 스티커의 최대값 -> [i-2][1], [i-1][1] 중 최대값 + point[i][0]
				dp[i][0] = Math.max(dp[i - 2][1], dp[i - 1][1]) + point[i][0];
				dp[i][1] = Math.max(dp[i - 2][0], dp[i - 1][0]) + point[i][1];
			}
			
			int maxPoint = Math.max(dp[N - 1][0], dp[N - 1][1]);
			result.append(maxPoint).append("\n");
		}
		System.out.print(result);
	}
}