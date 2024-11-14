import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testcase = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= testcase; t++) {
			String input = br.readLine().trim();
			
			boolean isHeumoon = true;
			for (int i = 0; i <= (input.length() / 2); i++) {
				if (input.charAt(i) != input.charAt(input.length() - i - 1)) {
					isHeumoon = false;
					break;
				}
			}
			sb.append("#").append(t).append(" ").append(isHeumoon ? "1" : "0");
			if (t != testcase) sb.append("\n");
		}
		
		System.out.print(sb);
	}
}