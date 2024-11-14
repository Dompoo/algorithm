import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine());
		int[] size = new int[testcase];
		int maxSize = Integer.MIN_VALUE;
		for (int i = 0; i < testcase; i++) {
			int curSize = Integer.parseInt(br.readLine());
			maxSize = Math.max(maxSize, curSize);
			size[i] = curSize;
		}
		
		int[][] pascal = new int[maxSize][maxSize];
		pascal[0][0] = 1;
		for (int x = 0; x < maxSize; x++) {
			for (int y = 0; y <= x; y++) {
				if (x - 1 >= 0 && y - 1 >= 0) {
					pascal[x][y] += pascal[x - 1][y - 1];
				}
				if (x - 1 >= 0 && y >= 0) {
					pascal[x][y] += pascal[x - 1][y];
				}
			}
		}
		
		for (int i = 1; i <= testcase; i++) {
			sb.append("#").append(i).append("\n");
			int curSize = size[i - 1];
			for (int x = 0; x < curSize; x++) {
				for (int y = 0; y <= x; y++) {
					sb.append(pascal[x][y]);
					if (x != y) {
						sb.append(" ");
					}
				}
				sb.append("\n");
			}
		}
		
		System.out.print(sb);
	}
}