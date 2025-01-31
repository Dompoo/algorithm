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
		String[] NM = br.readLine().split(" ");
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		String[] arr = br.readLine().split(" ");
		int[] sum = new int[N + 1]; // i~j 합 = sum[j + 1] - sum[i]
		for (int i = 0; i < N; i++) {
			sum[i + 1] = sum[i] + Integer.parseInt(arr[i]);
		}
		
		int result = 0;
		int left = 0;
		int right = 0;
		while (left < N + 1 && right < N) {
			int curSum = sum[right + 1] - sum[left];
			if (curSum == M) {
				result++;
				right++;
			}
			else if (curSum < M) {
				right++;
			}
			else {
				left++;
			}
		}
		
		System.out.print(result);
	}
}
