import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

/*
3
3 17 1 39
8 22 5 10
6 53 2 12
 */
class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int testcase = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= testcase; t++) {
			int size = Integer.parseInt(br.readLine().trim());
			int[] arr = new int[size];
			
			String[] inputs = br.readLine().trim().split(" ");
			for (int i = 0; i < size; i++) {
				arr[i] = Integer.parseInt(inputs[i]);
			}
			
			Arrays.sort(arr);
			sb.append("#").append(t).append(" ");
			for (int i = 0; i < size; i++) {
				sb.append(arr[i]);
				if (i != size - 1) {
					sb.append(" ");
				}
			}
			if (t != testcase) {
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}