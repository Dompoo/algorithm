import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int testcase = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= testcase; t++) {
			final int number = Integer.parseInt(br.readLine().trim());
			int answer = 0;
			answer -= number / 2;
			answer += number % 2 == 0 ? 0 : number;
			
			sb.append("#").append(t).append(" ").append(answer);
			if (t != testcase) sb.append("\n");
		}
		
		System.out.print(sb);
	}
}