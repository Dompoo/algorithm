import java.util.*;

class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		String game = sc.next();
		String[] arr = new String[size];
		for (int i = 0; i < size; i++) {
			arr[i] = sc.next();
		}
		System.out.print(solution(size, game, arr));
	}
	
	private static int solution(int size, String game, String[] arr) {
		int otherPlayer;
		switch (game) {
			case "Y": otherPlayer = 1; break;
			case "F": otherPlayer = 2; break;
			case "O": otherPlayer = 3; break;
			default: return -1;
		}
		
		Set<String> set = new HashSet<>();
		
		for(String str : arr) {
			set.add(str);
		}
		
		return set.size() / otherPlayer;
	}
}