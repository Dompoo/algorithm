import java.util.*;

/**
 * 4 3
 * 1 1 2 0
 * 2 0 1 0
 * 3 0 1 0
 * 4 0 0 1
 */
class Main {
	
	public static class Medal implements Comparable<Medal> {
		
		int state;
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
		
		public boolean sameState(Medal o) {
			return o.gold == this.gold && o.silver == this.silver && o.bronze == this.bronze;
		}
		
		@Override
		public String toString() {
			return "Medal{" +
					"state=" + state +
					", number=" + number +
					", gold=" + gold +
					", silver=" + silver +
					", bronze=" + bronze +
					'}';
		}
	}
	
	public static List<Medal> list = new ArrayList<>();
	
	public int solution(int target) {
		Collections.sort(list);
		
		list.get(0).state = 1;
		
		for (int i = 1; i < list.size(); i++) {
			
			Medal curr = list.get(i);
			Medal prev = list.get(i - 1);
			
			if(curr.sameState(prev)) curr.state = prev.state;
			else curr.state = prev.state + 1;
			
//			System.out.println(list);
			
			if(curr.number == target) return curr.state;
		}
		
		return -1;
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