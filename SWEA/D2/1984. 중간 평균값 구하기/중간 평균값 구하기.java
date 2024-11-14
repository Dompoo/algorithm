import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int testcase = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= testcase; t++) {
			String[] inputs = br.readLine().split(" ");
			int sum = 0;
			int max = Integer.MIN_VALUE;
			int min = Integer.MAX_VALUE;
			for (int i = 0; i < 10; i ++) {
				int number = Integer.parseInt(inputs[i]);
				sum += number;
				max = Math.max(max, number);
				min = Math.min(min, number);
			}
			
			float i = (sum - max - min) / (float) 8;
			int answer = Math.round(i);
			sb.append("#").append(t).append(" ").append(answer);
			if (t != testcase) {
				sb.append("\n");
			}
		}
		
		System.out.print(sb);
	}
}