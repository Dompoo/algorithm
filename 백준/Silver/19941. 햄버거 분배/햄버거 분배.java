import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String[] s = br.readLine().split(" ");
		int size = Integer.parseInt(s[0]);
		int len = Integer.parseInt(s[1]);
		String str = br.readLine();
		bw.write(new Main().solution(size, len, str));
		bw.flush();
	}
	
	private String solution(int size, int len, String str) {
		char[] arr = str.toCharArray();
		int result = 0;
		
		for(int i = 0; i < size; i++) {
			if(arr[i] == 'P') {
				//왼쪽에서부터 최대한 멀리 있는 거 먹기
				for(int h = i - len; h <= i + len; h++) {
					if (0 <= h && h < size && arr[h] == 'H') {
						arr[h] = '-';
						result++;
						break;
					}
				}
			}
		}
		
		return String.valueOf(result);
	}
}