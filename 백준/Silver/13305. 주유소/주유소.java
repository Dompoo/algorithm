import java.util.*;
/*
4
2 3 1
1 2 3 4
 */
class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int cityNum = sc.nextInt();
		int[] use = new int[cityNum - 1];
		int[] fill = new int[cityNum];
		for (int i = 0; i < cityNum - 1; i++) {
			use[i] = sc.nextInt();
		}
		for (int i = 0; i < cityNum; i++) {
			fill[i] = sc.nextInt();
		}
		System.out.print(new Main().solution(cityNum, use, fill));
	}
	
	private int solution(int citySize, int[] use, int[] fill) {
		int currentCity = 0;
		int result = 0;
		
		while(true) {
			if (currentCity == citySize - 1) break; //마지막 도시에 도착하였다면 ok
			
			int fillFee = fill[currentCity];
			int nextCity = citySize - 1;
			// 다음 기름 넣을 도시를 고름
			for(int i = currentCity + 1; i < citySize - 1; i++) {
				if (fillFee > fill[i]) {
					nextCity = i;
					break;
				}
			}
			// 현재 기름값으로 해당 도시까지 이동
			for(int i = currentCity; i < nextCity; i++) {
				result += use[i] * fillFee;
			}
			
//			System.out.println("current : " + currentCity + " next : " + nextCity + " result : " + result);
			
			currentCity = nextCity;
		}
		
		return result;
	}
}