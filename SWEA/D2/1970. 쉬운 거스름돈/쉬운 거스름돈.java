import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;

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
		/*
		50,000 원 : 0개
10,000 원 : 3개
5,000 원 : 0개
1,000 원 : 2개
500 원 : 1개
100 원 : 3개
50 원 : 1개
10 원 : 0개
		 */
		for (int t = 1; t <= testcase; t++) {
			int money = Integer.parseInt(br.readLine().trim());
			int t50000 = money / 50000;
			money %= 50000;
			int t10000 = money / 10000;
			money %= 10000;
			int t5000 = money / 5000;
			money %= 5000;
			int t1000 = money / 1000;
			money %= 1000;
			int t500 = money / 500;
			money %= 500;
			int t100 = money / 100;
			money %= 100;
			int t50 = money / 50;
			money %= 50;
			int t10 = money / 10;
			
			sb.append("#").append(t).append("\n");
			sb.append(t50000).append(" ");
			sb.append(t10000).append(" ");
			sb.append(t5000).append(" ");
			sb.append(t1000).append(" ");
			sb.append(t500).append(" ");
			sb.append(t100).append(" ");
			sb.append(t50).append(" ");
			sb.append(t10);
			if (t != testcase) {
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}