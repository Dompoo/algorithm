import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NM = br.readLine().split(" ");
		
		int N = Integer.parseInt(NM[0]);
		int M = Integer.parseInt(NM[1]);
		
		int[] cards = new int[N];
		boolean[] used = new boolean[N];
		
		String[] numbers = br.readLine().split(" ");
		for(int i = 0; i < N; i++) {
			cards[i] = Integer.parseInt(numbers[i]);
		}
		
		int bestSum = 0;
		for(int i = 0; i < N; i++) {
			for(int j = i + 1; j < N; j++) {
				for(int k = j + 1; k < N; k++) {
					int curSum = cards[i] + cards[j] + cards[k];
					if(curSum <= M) {
						bestSum = Math.max(bestSum, curSum);
					}
				}
			}
		}
		System.out.print(bestSum);
	}
}