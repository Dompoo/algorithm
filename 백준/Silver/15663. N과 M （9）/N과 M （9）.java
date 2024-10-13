import java.util.*;
import java.io.*;

/*
4 2
100 10 9 7

 */
class Main {
	
	public static Set<String> set = new HashSet<>();
	public static int[] arr;
	public static boolean[] selected;
	public static int arrSize;
	public static int targetSize;
	
	private void dfs(int curSize, String cur) {
		if (curSize == targetSize) {
			set.add(cur);
			return;
		}
		
		for (int i = 0; i < arrSize; i++) {
			if (!selected[i]) {
				selected[i] = true;
				dfs(curSize + 1, cur + (curSize == 0 ? "" : " ") + arr[i]);
				selected[i] = false;
			}
			
		}
	}
	
	private String solution() {
		Arrays.sort(arr);
		selected = new boolean[arrSize];
		dfs(0, "");
		
		List<String> results = new ArrayList<>(set);
		Collections.sort(results, (a,b) -> {
			String[] arrA = a.split(" ");
			String[] arrB = b.split(" ");
			for (int i = 0; i < targetSize; i++) {
				int intA = Integer.parseInt(arrA[i]);
				int intB = Integer.parseInt(arrB[i]);
				if (intA != intB) return intA - intB;
			}
			return 0;
		});
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < results.size(); i++) {
			sb.append(results.get(i));
			if (i != results.size() - 1) sb.append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		arrSize = Integer.parseInt(s[0]);
		targetSize = Integer.parseInt(s[1]);
		arr = new int[arrSize];
		String[] s2 = br.readLine().split(" ");
		for (int i = 0; i < arrSize; i++) {
			arr[i] = Integer.parseInt(s2[i]);
		}
		System.out.print(new Main().solution());
	}
}