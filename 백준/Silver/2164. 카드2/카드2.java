import java.util.*;

class Main {
	
	private int solution(int target) {
		Queue<Integer> queue = new LinkedList<>();
		for(int i = 1; i <= target; i++) {
			queue.offer(i);
		}
		
		while (queue.size() > 1) {
			queue.poll();
			
			queue.offer(queue.poll());
		}
		
		return queue.poll();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		System.out.println(new Main().solution(target));
	}
}