import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;

/*
2
2
-100 100
3
-5 -1 3
 */
class Solution {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine().trim());
		for (int t = 1; t <= testcase; t++) {
			String[] inputs = br.readLine().trim().split(" ");
			int P = Integer.parseInt(inputs[0]);
			
			int Q = Integer.parseInt(inputs[1]);
			int R = Integer.parseInt(inputs[2]);
			int S = Integer.parseInt(inputs[3]);
			
			int W = Integer.parseInt(inputs[4]);
			
			int money1 = W * P;
			int money2 = Q;
			if (W > R) {
				money2 += S * (W - R);
			}
			
			sb.append("#").append(t).append(" ").append(Math.min(money1, money2)).append("\n");
		}
		System.out.print(sb);
	}
}