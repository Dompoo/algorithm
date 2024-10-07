import java.util.*;

class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int inputSize = sc.nextInt();
		int myScore = sc.nextInt();
		int max = sc.nextInt();
		int[] arr = new int[inputSize + 1];
		for (int i = 0; i < inputSize; i++) {
			arr[i] = sc.nextInt();
		}
		arr[inputSize] = -1;
		System.out.println(new Main().solution(inputSize, arr, myScore, max));
	}
	
	private int solution(int inputSize, int[] arr, int myScore, int max) {
		/*
		3 90 10
		100 90 ^ 80 -1
		- index 3 -> 2
		 */
		/*
		10 1 10
		10 9 8 7 6 5 4 3 2 1 ^ -1
		- index 11 -> -1
		 */
		/*
		10 1 10
		10 9 8 7 6 5 4 3 3 ^ 0 -1
		- index 10 -> 10
		 */
		/*
		0 0 50
		^ -1
		- index 1 -> 1
		 */
		
		// index가 올라갈 수 있는 경우에는
		// 같은 등수까지 계산하여 그것을 점수로 함
		// index가 올라가지 못하는 경우에는 -1
		
		int index = -1;
		int sameScoreIndex = -1;
		boolean shouldRecordSameScoreStart = true;
		for(int i = 0; i <= inputSize; i++) {
			if(shouldRecordSameScoreStart && arr[i] == myScore) {
				sameScoreIndex = i + 1;
				shouldRecordSameScoreStart = false;
			}
			if(arr[i] < myScore) {
				index = i + 1;
				break;
			}
		}
		
//		System.out.println(sameScoreIndex + " " + index);
		if(index == -1 || index > max) return -1;
		else return sameScoreIndex == -1 ? index : sameScoreIndex;
	}
}