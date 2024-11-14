import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
1
6
6 9 4 7 0 5
8 9 9 2 6 5
6 8 5 4 9 8
2 2 7 7 8 4
7 5 1 9 7 9
8 9 3 9 7 6
 */
class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int testcase = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= testcase; t++) {
			int size = Integer.parseInt(br.readLine().trim());
			int[][] arr = new int[size][size];
			
			for (int i = 0; i < size; i++) {
				String[] inputs = br.readLine().trim().split(" ");
				for (int j = 0; j < size; j++) {
					arr[i][j] = Integer.parseInt(inputs[j]);
				}
			}
			sb.append("#").append(t).append("\n");
			
			for (int i = 0; i < size; i++) {
				//90도
				for (int k = 0; k < size; k++) {
					sb.append(arr[size - k - 1][i]);
				}
				sb.append(" ");
				//180도
				for (int k = 0; k < size; k++) {
					sb.append(arr[size - i - 1][size - k - 1]);
				}
				sb.append(" ");
				//270도
				for (int k = 0; k < size; k++) {
					sb.append(arr[k][size - i - 1]);
				}
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}