import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
3
3 17 1 39
8 22 5 10
6 53 2 12
 */
class Solution {
	public static class Time {
		int si;
		int bun;
		
		public Time(int si, int bun) {
			this.si = si;
			this.bun = bun;
		}
		
		public Time(String si, String bun) {
			this.si = Integer.parseInt(si);
			this.bun = Integer.parseInt(bun);
		}
		
		public Time add(Time o) {
			int newBun = this.bun + o.bun;
			int newSi = this.si + o.si + (newBun / 60);
			return new Time(newSi % 12 == 0 ? 12 : newSi % 12, newBun % 60);
		}
		
		@Override
		public String toString() {
			return si + " " + bun;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int testcase = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= testcase; t++) {
			String[] inputs = br.readLine().trim().split(" ");
			Time time1 = new Time(inputs[0], inputs[1]);
			Time time2 = new Time(inputs[2], inputs[3]);
			sb.append("#").append(t).append(" ").append(time1.add(time2));
			if (t != testcase) {
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}