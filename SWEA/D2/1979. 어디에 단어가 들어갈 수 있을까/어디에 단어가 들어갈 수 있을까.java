import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
1
10 2
87 59 88
99 94 78
94 86 86
99 100 99
69 76 70
76 89 96
98 95 96
74 69 60
98 84 67
85 84 91
 */
class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int testcase = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= testcase; t++) {
			String[] NK = br.readLine().trim().split(" ");
			int N = Integer.parseInt(NK[0]);
			int K = Integer.parseInt(NK[1]);
			boolean[][] arr = new boolean[N][N];
			
			for (int i = 0; i < N; i++) {
				String[] in = br.readLine().trim().split(" ");
				for (int j = 0; j < N; j++) {
					arr[i][j] = in[j].equals("1");
				}
			}
			
			int count = 0;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					boolean canFitRow = true;
					if ((j - 1 < 0 || !arr[i][j - 1]) && (j + K > N - 1 || !arr[i][j + K]) && (j + K <= N)) {
						for (int l = 0; l < K; l++) {
							if (!arr[i][j + l]) {
								canFitRow = false;
								break;
							}
						}
						if (canFitRow) {
							count++;
						}
					}
					
					boolean canFitCol = true;
					if ((i - 1 < 0 || !arr[i - 1][j]) && (i + K > N - 1 || !arr[i + K][j]) && (i + K <= N)) {
						for (int l = 0; l < K; l++) {
							if (!arr[i + l][j]) {
								canFitCol = false;
								break;
								
							}
						}
						if (canFitCol) {
							count++;
						}
					}
				}
			}
			
			sb.append("#").append(t).append(" ").append(count);
			if (t != testcase) {
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}