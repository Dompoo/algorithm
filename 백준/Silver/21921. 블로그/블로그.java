import java.util.*;
import java.io.*;

class Main {
	
	private String solution(int size, int windowSize, int[] arr) {
		int sum = 0;
		for (int i = 0; i < windowSize; i++) {
			sum += arr[i];
		}
		
		int max = sum;
		int maxCount = 1;
		
		int left = 0;
		int right = windowSize - 1;
		
		while (right + 1 < size) {
			
			sum -= arr[left++];
			sum += arr[++right];
			
			if (sum > max) {
				max = sum;
				maxCount = 1;
			} else if (sum == max) {
				maxCount++;
			}
			
		}
		
		if (max == 0) {
			return "SAD";
		} else {
			return max + "\n" + maxCount;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] a = br.readLine().split(" ");
		int size = Integer.parseInt(a[0]);
		int windowSize= Integer.parseInt(a[1]);
		String[] b = br.readLine().split(" ");
		int[] arr = new int[size];
		for(int i = 0; i < size; i++) {
			arr[i] = Integer.parseInt(b[i]);
		}
		bw.write(new Main().solution(size, windowSize, arr));
		bw.flush();
	}
}