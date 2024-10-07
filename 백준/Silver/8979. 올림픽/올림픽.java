import java.util.*;


/*
4 3
1 0 0 0
2 0 0 0
3 0 0 0
4 0 0 0
 */
class Main {
	
	public static class Medal implements Comparable<Medal> {
		int number;
		int gold;
		int silver;
		int bronze;
		
		public Medal(int number, int gold, int silver, int bronze) {
			this.number = number;
			this.gold = gold;
			this.silver = silver;
			this.bronze = bronze;
		}
		
		@Override
		public int compareTo(Medal o) {
			if(o.gold != this.gold) return o.gold - this.gold;
			else if (o.silver != this.silver) return o.silver - this.silver;
			else return o.bronze - this.bronze;
		}
	}
	
	public static List<Medal> list = new ArrayList<>();
	
	public int solution(int targetNumber) {
		Collections.sort(list); // 메달 순위대로 정렬
		
		int rank = 1; // 첫 번째 순위는 1등부터 시작
		int sameRankCount = 0; // 동일한 순위를 가진 국가의 수를 기록
		
		Medal prevMedal = list.get(0); // 첫 번째 국가 정보
		for (int i = 0; i < list.size(); i++) {
			Medal currentMedal = list.get(i);
			
			// 이전 국가와 비교하여 메달 수가 동일하지 않으면 순위 갱신
			if (prevMedal.compareTo(currentMedal) != 0) {
				rank += sameRankCount; // 이전에 같은 순위를 가졌던 국가 수만큼 순위 증가
				sameRankCount = 1; // 새로운 순위를 가진 국가이므로 카운트 초기화
			} else {
				sameRankCount++; // 동일한 순위를 가진 국가일 경우 증가
			}
			
			// target 국가의 등수를 찾으면 반환
			if (currentMedal.number == targetNumber) {
				return rank;
			}
			
			prevMedal = currentMedal; // 현재 메달 정보를 이전 메달로 업데이트
		}
		
		return -1; // 찾지 못한 경우
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int target = sc.nextInt();
		
		for (int i = 0; i < size; i++) {
			int number = sc.nextInt();
			int gold = sc.nextInt();
			int silver = sc.nextInt();
			int bronze = sc.nextInt();
			
			list.add(new Medal(number, gold, silver, bronze));
			
		}
		System.out.println(new Main().solution(target));
	}
}