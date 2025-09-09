import java.io.*;
import java.util.*;

/*
7
3 10
5 20
1 10
1 20
2 15
4 40
2 200

1일에 일하면

4일에는 10원을 들고 있을 수 있다.

1일에 일하지 않으면 넘어가기
2일에 일하면 ...
*/
public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int[][] input = new int[N][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int time = Integer.parseInt(st.nextToken());
			int money = Integer.parseInt(st.nextToken());
			input[i] = new int[]{time, money};
		}

		int[] dp = new int[N + 1];
		for (int i = 0; i < N; i++) {
			if (i > 0) {
				dp[i] = Math.max(dp[i], dp[i - 1]);
			}
			// 해당 날짜에 일하는 경우
			int time = input[i][0];
			int money = input[i][1];
			int nextTime = i + time;
			if (nextTime > N) continue; // 끝내지 못하는 경우는 패스
			dp[nextTime] = Math.max(dp[nextTime], dp[i] + money);
		}

		Arrays.sort(dp);
		System.out.println(dp[N]);
	}
}