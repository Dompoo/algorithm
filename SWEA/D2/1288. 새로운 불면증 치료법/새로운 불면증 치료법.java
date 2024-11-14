import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

/*
5
1
2
11
1295
1692
 */
class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= testcase; t++) {
			
			int N = Integer.parseInt(br.readLine().trim());
			boolean[] flag = new boolean[10];
			int xCount = 1;
			while(true) {
				String value = String.valueOf(N * xCount);
				for (int i = 0; i < value.length(); i++) {
					flag[Integer.parseInt(String.valueOf(value.charAt(i)))] = true;
				}
				
				int flagCount = 0;
				for (int i = 0; i < 10; i++) {
					if (flag[i]) flagCount++;
				}
				if (flagCount == 10) break;
				else {
					xCount++;
				}
			}
			
			sb.append("#").append(t).append(" ").append(xCount * N).append("\n");
		}
		System.out.print(sb);
	}
}