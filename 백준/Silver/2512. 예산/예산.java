import java.util.*;
import java.io.*;

/*
4
1000 1000 1000 1000
420
 */
class Main {
	
	private String solution(int size, int[] arr, int total) {
		int left = 0;
		int right = Integer.MIN_VALUE;
		int result = 0;
		
		for(int i = 0; i < size; i++) {
			right = Math.max(arr[i], right);
		}
		
		while(left <= right) {
			int middle = (left + right) / 2;
			
			// 예산 최대값을 middle로 두고 총 예산 계산
			long curTotal = 0;
			for(int i = 0; i < size; i++) {
				if (arr[i] > middle) {
					curTotal += middle;
				} else {
					curTotal += arr[i];
				}
			}
			if (curTotal <= total) {
				left = middle + 1;
				result = middle;
			} else {
				right = middle - 1;
			}
		}
		
		return String.valueOf(result);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int size = Integer.parseInt(br.readLine());
		int[] arr = new int[size];
		String[] s = br.readLine().split(" ");
		for (int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		int total = Integer.parseInt(br.readLine());
		
		bw.write(new Main().solution(size, arr, total));
		bw.flush();
	}
}