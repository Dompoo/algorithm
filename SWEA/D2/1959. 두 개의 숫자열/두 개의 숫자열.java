import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
1
7 6
6 0 5 5 -1 1 6
-4 1 8 7 -9 3
 */
class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int testcase = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= testcase; t++) {
			String[] NM = br.readLine().trim().split(" ");
			final int N = Integer.parseInt(NM[0]);
			final int M = Integer.parseInt(NM[1]);
			int[] window = new int[N];
			int[] arr = new int[M];
			String[] windowStr = br.readLine().trim().split(" ");
			for (int i = 0; i < N; i++) {
				window[i] = Integer.parseInt(windowStr[i]);
			}
			String[] arrStr = br.readLine().trim().split(" ");
			for (int i = 0; i < M; i++) {
				arr[i] = Integer.parseInt(arrStr[i]);
			}
			
			int maxSum = Integer.MIN_VALUE;
			if (M > N) {
				for (int offset = 0; offset <= M - N; offset++) {
					int curSum = 0;
					for (int i = 0; i < N; i++) {
						curSum += window[i] * arr[i + offset];
					}
					maxSum = Math.max(maxSum, curSum);
				}
			} else {
				for (int offset = 0; offset <= N - M; offset++) {
					int curSum = 0;
					for (int i = 0; i < M; i++) {
						curSum += window[i + offset] * arr[i];
					}
					maxSum = Math.max(maxSum, curSum);
				}
			}
			
			sb.append("#").append(t).append(" ").append(maxSum);
			if (t != testcase) {
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}