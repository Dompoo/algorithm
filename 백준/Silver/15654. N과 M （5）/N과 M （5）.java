import java.util.*;
import java.io.*;

/*
3 3
1 11 111
 */
class Main {
	
	private static boolean[] used;
	private static int[] arr;
	private List<String> list = new ArrayList<>();
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int size = Integer.parseInt(s[0]);
		int pick = Integer.parseInt(s[1]);
		arr = new int[size];
		used = new boolean[size];
		
		String[] s2 = br.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(s2[i]);
		}
		System.out.print(new Main().solution(size, pick));
	}
	
	private String solution(int size, int pick) {
		Arrays.sort(arr);
		dfs(0, size, pick, "");
		
		return getResultString();
	}
	
	private void dfs(int curLen, int arrSize, int pick, String str) {
		if (curLen == pick) {
			list.add(str);
			return;
		}
		
		for (int i = 0; i < arrSize; i++) {
			if (!used[i]) {
				used[i] = true;
				dfs(curLen + 1, arrSize, pick, curLen == 0 ? String.valueOf(arr[i]) : str + " " + arr[i]);
				used[i] = false;
			}
		}
	}
	
	private String getResultString() {
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < list.size(); i++) {
			sb.append(list.get(i));
			if (i != list.size() - 1) sb.append("\n");
		}
		return sb.toString();
	}
}