import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Base64;
import java.util.Scanner;

/*
1
1
 */
class Solution {
	
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int testcase = sc.nextInt();
		for (int t = 1; t <= testcase; t++) {
			sc.nextInt();
			
			int[] score = new int[101];
			for (int i = 0; i < 1_000; i++) {
				score[sc.nextInt()]++;
			}
			
			int maxScore = Integer.MIN_VALUE;
			int maxIndex = 0;
			for (int i = 0; i < 100; i++) {
				if (score[i] >= maxScore) {
					maxScore = score[i];
					maxIndex = i;
				}
			}
			
			sb.append("#").append(t).append(" ").append(maxIndex).append("\n");
		}
		System.out.print(sb);
	}
}