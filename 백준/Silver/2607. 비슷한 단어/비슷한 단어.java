import java.util.*;
import java.io.*;
/*
2
DDOG
CCOG
DOGKG

 */

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine()) - 1;
		String target = br.readLine();
		String[] arr = new String[size];
		for (int i = 0; i < size; i++) {
			arr[i] = br.readLine();
		}
		System.out.print(new Main().solution(size, target, arr));
	}
	
	private int solution(int size, String target, String[] arr) {
		
		int[] targetArr = new int[26];
		for(char ch : target.toCharArray()) {
			targetArr[ch - 'A']++;
		}
		
		int result = 0;
		for(int i = 0; i < size; i++) {
			int[] currentArr = new int[26];
			for(char ch : arr[i].toCharArray()) {
				currentArr[ch - 'A']++;
			}
			
			int diffCount = 0;
			int sumDiff = 0;
			boolean onlyChanedBetweenOneTwo = true;
			
			for (int j = 0; j < 26; j++) {
				int diff = targetArr[j] - currentArr[j];
				
				if (diff != 0) {
					diffCount++;
					sumDiff += diff;
				}
				
				if (Math.abs(diff) >= 2) {
					onlyChanedBetweenOneTwo = false;
				}
			}
			
			if (onlyChanedBetweenOneTwo && (
					diffCount == 0 || //동일한 구성
					diffCount == 1 && (sumDiff == 1 || sumDiff == -1) || //하나가 다르고, 하나가 더하거나 빠질 때
					diffCount == 2 && sumDiff == 0) // 1개씩이 문자가 바뀔 때
			) {
				result++;
			}
		}
		
		
		return result;
	}
}