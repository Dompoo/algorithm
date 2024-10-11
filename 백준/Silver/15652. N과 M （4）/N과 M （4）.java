import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int maxNum = Integer.parseInt(s[0]);
		int length = Integer.parseInt(s[1]);
		System.out.print(new Main().solution(maxNum, length));
	}
	
	private String solution(int maxNum, int maxLength) {
		
		for (int i = 1; i <= maxNum; i++) {
			dfs(i, 1, String.valueOf(i), maxNum, maxLength);
		}
		
		
		Collections.sort(list);
		StringBuilder sb = new StringBuilder();
		for(String s : list) {
			sb.append(s).append("\n");
		}
		
		return sb.toString();
	}
	
	
	public List<String> list = new ArrayList<>();
	
	private void dfs(int lastNumber, int currentLen, String currentStr, int maxNum, int maxLength) {
		if (currentLen == maxLength) {
			list.add(currentStr);
			return;
		}
		
		for (int i = lastNumber; i <= maxNum; i++) {
			dfs(i, currentLen + 1, currentStr + " " + i, maxNum, maxLength);
		}
	}
}