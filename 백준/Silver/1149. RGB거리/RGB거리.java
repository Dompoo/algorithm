import java.util.*;
import java.io.*;

/*
3
26 40 83
49 60 57
13 89 99
 */
class Main {
	
	public static int[][] cost;
	public static int[][] dp; // 1~n집을 칠했을 때, n번째 집을 i색으로 칠할 최소 비용
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int size = Integer.parseInt(br.readLine());
		cost = new int[size][3];
		for (int i = 0; i < size; i++) {
			String[] s = br.readLine().split(" ");
			cost[i][0] = Integer.parseInt(s[0]);
			cost[i][1] = Integer.parseInt(s[1]);
			cost[i][2] = Integer.parseInt(s[2]);
		}
		
		dp = new int[size][3];
		for (int i = 1; i < size; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		dp[0][0] = cost[0][0];
		dp[0][1] = cost[0][1];
		dp[0][2] = cost[0][2];
		
		for (int i = 1; i < size; i++) {
			for (int curColor = 0; curColor < 3; curColor++) {
				for (int prevColor = 0; prevColor < 3; prevColor++) {
					if (curColor != prevColor) {
						dp[i][curColor] = Math.min(dp[i][curColor], dp[i - 1][prevColor] + cost[i][curColor]);
					}
				}
			}
		}
		
		System.out.print(Math.min(dp[size - 1][0], Math.min(dp[size - 1][1], dp[size - 1][2])));
		
		br.close();
	}
}