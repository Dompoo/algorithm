import java.util.*;
import java.io.*;

/*
4 2
100 10 9 7

 */
class Main {
	
	public static Set<String> set = new HashSet<>();
	public static int[] numbers;
	public static int arrSize;
	public static int targetSize;
	
	private void dfs(int curSize, String cur, int curIndex) {
		if (curSize == targetSize) {
			set.add(cur);
			return;
		}
		
		for (int i = curIndex; i < arrSize; i++) {
			dfs(curSize + 1, cur + (curSize == 0 ? "" : " ") + numbers[i], i);
		}
	}
	
	private String solution() {
		Arrays.sort(numbers);
		dfs(0, "", 0);
		
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
		numbers = new int[arrSize];
		String[] s2 = br.readLine().split(" ");
		for (int i = 0; i < arrSize; i++) {
			numbers[i] = Integer.parseInt(s2[i]);
		}
		System.out.print(new Main().solution());
	}
}