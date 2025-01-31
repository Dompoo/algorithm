import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	/*
	1 2 3 4 2  5  3   1   1   2
	0 1 3 6 10 15 18  19  20  22 24
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]);
		int K = Integer.parseInt(NK[1]);
		String[] arr = br.readLine().split(" ");
		int[] sum = new int[N + 1]; // i~j 합 = sum[j + 1] - sum[i]
		for (int i = 0; i < N; i++) {
			sum[i + 1] = sum[i] + Integer.parseInt(arr[i]);
		}
		
		int maxSum = Integer.MIN_VALUE;
		
		for (int i = 0; i + K < N + 1; i++) {
			int curSum = sum[i + K] - sum[i];
			maxSum = Math.max(curSum, maxSum);
		}
		
		System.out.print(maxSum);
	}
}
