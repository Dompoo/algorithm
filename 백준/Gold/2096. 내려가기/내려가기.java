import java.util.*;
import java.io.*;

/*
3
1 2 3
4 5 6
4 9 0
 */
class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[N][3];
		for (int i = 0; i < N; i++) {
			String[] s = br.readLine().split(" ");
			for (int j = 0; j < 3; j++) {
				arr[i][j] = Integer.parseInt(s[j]);
			}
		}
		
		int[][] maxDP = new int[N][3];
		int[][] minDP = new int[N][3];
		for (int j = 0; j < 3; j++) {
			maxDP[0][j] = arr[0][j];
			minDP[0][j] = arr[0][j];
		}
		
		for (int i = 1; i < N; i++) {
			maxDP[i][0] = Math.max(maxDP[i - 1][0], maxDP[i - 1][1]) + arr[i][0];
			maxDP[i][1] = Math.max(Math.max(maxDP[i - 1][0], maxDP[i - 1][1]), maxDP[i - 1][2]) + arr[i][1];
			maxDP[i][2] = Math.max(maxDP[i - 1][1], maxDP[i - 1][2]) + arr[i][2];
			
			minDP[i][0] = Math.min(minDP[i - 1][0], minDP[i - 1][1]) + arr[i][0];
			minDP[i][1] = Math.min(Math.min(minDP[i - 1][0], minDP[i - 1][1]), minDP[i - 1][2]) + arr[i][1];
			minDP[i][2] = Math.min(minDP[i - 1][1], minDP[i - 1][2]) + arr[i][2];
		}
		
		System.out.print(Math.max(Math.max(maxDP[N - 1][0], maxDP[N - 1][1]), maxDP[N - 1][2]) + " " + Math.min(Math.min(minDP[N - 1][0], minDP[N - 1][1]), minDP[N - 1][2]));
	}
}