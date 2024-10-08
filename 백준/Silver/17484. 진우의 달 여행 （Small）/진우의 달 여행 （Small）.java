import java.util.*;
import java.io.*;

class Main {
	
	public static int h;
	public static int w;
	public static int[][] arr;
	public static int minCost = Integer.MAX_VALUE;
	
	private void dfs(int curh, int curw, int dir, int cost) {
		if (curh == h) {
			minCost = Math.min(minCost, cost);
			return;
		}
		
		for(int i = -1; i <= 1; i++) {
			if (0 <= curw + i && curw + i < w && dir != i) {
				dfs(curh + 1, curw + i, i, cost + arr[curh][curw]);
			}
		}
	}
	
	private String solution() {
		for(int i = 0; i < w; i++) {
			dfs(0, i, 10, 0);
		}
		
		return String.valueOf(minCost);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s1 = br.readLine().split(" ");
		h = Integer.parseInt(s1[0]);
		w = Integer.parseInt(s1[1]);
		arr = new int[h][w];
		for(int i = 0; i < h; i++) {
			String[] s2 = br.readLine().split(" ");
			for (int j = 0; j < w; j++) {
				arr[i][j] = Integer.parseInt(s2[j]);
			}
		}
		bw.write(new Main().solution());
		bw.flush();
	}
}