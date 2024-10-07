import java.util.*;

class Main {
	
	public int solution(int target) {
		int start = 1;
		int end = 1;
		int result = 1;
		while(true) {
			if(start <= target && target <= end) return result;
			// 속하지 않는다면 업데이트
			start = end + 1;
			end += result * 6;
			result++;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		System.out.println(new Main().solution(target));
	}
}