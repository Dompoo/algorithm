import java.util.*;
/*
1
15
1 2 3 3 1 3 2 4 1 1 3 1 3 3 1
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14

1팀 : 0 4 8 9 -> 21
3팀 : 2 3 5 10 -> 20

1 2 3 4
6 2 6 1
6명의 주자가 참여해야함
점수는 상위 4명
동점이라면 5번째 사람

1
18
1 2 3 1 2 3 1 2 3 3 3 3 2 2 2 1 1 1
 */
class Main {
	
	private int solution(int size, int[] arr) {
		Map<Integer, Integer> numberMap = new HashMap<>();
		Map<Integer, Integer> scoreMap = new HashMap<>();
		Map<Integer, Integer> fivemanIndexMap = new HashMap<>();
		
		// 인원수 계산하여 6명 안되는 팀 삭제
		for(int i = 0; i < size; i++) {
			numberMap.put(arr[i], numberMap.getOrDefault(arr[i], 0) + 1);
		}
		List<Integer> removeTeam = new ArrayList<>();
		for(int team : numberMap.keySet()) {
			if (numberMap.get(team) < 6) {
				removeTeam.add(team);
			}
		}
		for (int team : removeTeam) {
			numberMap.remove(team);
		}
		removeTeam.clear();
		
//		System.out.println("number: " + numberMap);
//		System.out.println("score: " + scoreMap);
//		System.out.println("five: " + fivemanIndexMap);
		
		// 남은 팀들 점수 계산
		int addScore = 1;
		for(int i = 0; i < size; i++) {
//			System.out.println("> number: " + numberMap);
//			System.out.println("> score : " + scoreMap);
//			System.out.println("> addScore : " + addScore);
//			System.out.println();
			
			// 6명 이상 팀일 때
			if (numberMap.containsKey(arr[i])) {
				int memberNumber = numberMap.get(arr[i]);
				if (memberNumber > 2) { // 6 5 4 3 2x 1x
					scoreMap.put(arr[i], scoreMap.getOrDefault(arr[i], 0) + addScore);
				} else if (memberNumber == 2) { // 5번째 사람의 index 등록
					fivemanIndexMap.put(arr[i], i);
				}
				addScore++;
				numberMap.put(arr[i], memberNumber - 1);
			}
		}
		
//		System.out.println("number: " + numberMap);
//		System.out.println("score: " + scoreMap);
//		System.out.println("five: " + fivemanIndexMap);
		
		// 점수와 동점여부를 확인하고
		int minScore = Integer.MAX_VALUE;
		List<Integer> bestTeams = new ArrayList<>();
		
		for (int score : scoreMap.values()) {
			minScore = Math.min(score, minScore);
		}
		
		for (int team : scoreMap.keySet()) {
			if (minScore == scoreMap.get(team)) {
				bestTeams.add(team);
			} else {
				removeTeam.add(team);
			}
		}
		for (int team : removeTeam) {
			fivemanIndexMap.remove(team);
		}
		removeTeam.clear();
		
//		System.out.println("number: " + numberMap);
//		System.out.println("score: " + scoreMap);
//		System.out.println("five: " + fivemanIndexMap);
		
		// 동점 팀이 존재한다면 계산
		if (bestTeams.size() == 1) {
			return bestTeams.get(0);
		} else {
			int minFivemanIndex = Integer.MAX_VALUE;
			int minTeam = -1;
			for (int team : fivemanIndexMap.keySet()) {
				if (minFivemanIndex > fivemanIndexMap.get(team)) {
					minFivemanIndex = fivemanIndexMap.get(team);
					minTeam = team;
				}
			}
			
			return minTeam;
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int testCase = Integer.parseInt(sc.nextLine());
		
		StringBuilder result = new StringBuilder();
		
		for(int i = 0; i < testCase; i++) {
			int size = Integer.parseInt(sc.nextLine());
			
			int[] arr = new int[size];
			
			String[] str = sc.nextLine().split(" ");
			
			for (int j = 0; j < size; j++) {
				arr[j] = Integer.parseInt(str[j]);
			}
			
			result.append(new Main().solution(size, arr));
			if(i != testCase - 1) result.append("\n");
		}
		
		System.out.print(result);
	}
}