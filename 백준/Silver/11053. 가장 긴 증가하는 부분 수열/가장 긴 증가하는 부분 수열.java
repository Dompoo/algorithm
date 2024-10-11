import java.util.*;
import java.io.*;

/*
3
30 20 10
 */
class Main {
	
	private static int size;
	private static int[] arr;
	
	private String solution() {
		int[] dp = new int[size]; //index로 끝나는 가장 긴 수열의 길이
		
		Arrays.fill(dp, 1);
		
		for(int i = 1; i < size; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
		}
		
		int result = 1;
		for (int i = 0; i < size; i++) {
			result = Math.max(result, dp[i]);
		}
		return String.valueOf(result);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		size = Integer.parseInt(br.readLine());
		arr = new int[size];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		System.out.print(new Main().solution());
	}
}