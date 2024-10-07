import java.util.*;

class Main {
	
	private long solution(int citySize, long[] use, long[] fill) {
		long minFee = fill[0];
		long result = 0;
		
		for(int i = 0; i < citySize - 1; i++) {
			if (minFee > fill[i]) {
				minFee = fill[i];
			}
			
			result += minFee * use[i];
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int cityNum = sc.nextInt();
		long[] use = new long[cityNum - 1];
		long[] fill = new long[cityNum];
		
		for (int i = 0; i < cityNum - 1; i++) {
			use[i] = sc.nextLong();
		}
		
		for (int i = 0; i < cityNum; i++) {
			fill[i] = sc.nextLong();
		}
		
		System.out.print(new Main().solution(cityNum, use, fill));
	}
}