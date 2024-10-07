import java.util.*;

class Main {
	
	private int solution(int length, int size, int[] position) {
		int maxBeside = Integer.MIN_VALUE;
		
		for(int i = 1; i < size; i++) {
			maxBeside = Math.max(position[i] - position[i - 1], maxBeside);
		}
		
		// maxBeside는 /2 올림이 필요함
		
		int middle = (maxBeside / 2) + (maxBeside % 2 == 0 ? 0 : 1);
		int left = position[0]; // 왼쪽 오른쪽은 그대로 필요함
		int right = length - position[size - 1];
		
		return Math.max(middle, Math.max(left, right));
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int length = sc.nextInt();
		int size = sc.nextInt();
		int[] position = new int[size];
		for(int i = 0; i < size; i++) {
			position[i] = sc.nextInt();
		}
		
		System.out.println(new Main().solution(length, size, position));
	}
}