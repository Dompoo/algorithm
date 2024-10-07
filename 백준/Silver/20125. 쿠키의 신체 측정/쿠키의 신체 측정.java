import java.util.*;
/*
10
__________
_____*____
********__
_____*____
_____*____
_____*____
____*_*___
____*_____
____*_____
____*_____
 */
class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		char[][] cookie = new char[size][size];
		for (int i = 0; i < size; i++) {
			String str = sc.next();
			for (int j = 0; j < size; j++) {
				cookie[i][j] = str.charAt(j);
			}
		}
		System.out.println(new Main().solution(size, cookie));
	}
	
	public String solution(int size, char[][] cookie) {
		
		//머리를 찾는다.
		//머리 바로 아래가 심장이다.
		int heartX = 0;
		int heartY = 0;
		boolean headFound = false;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (cookie[i][j] == '*') {
					heartX = i + 1;
					heartY = j;
					headFound = true;
					break;
				}
			}
			if(headFound) break;
		}
		
		//심장 기준 왼쪽으로 왼팔 길이를 잰다.
		int leftHandSize = 0;
		for (int i = heartY - 1; i >= 0; i--) {
			if (cookie[heartX][i] == '*') leftHandSize++;
			else break;
		}
		
		//심장 기준 오른쪽으로 오른팔 길이를 잰다.
		int rightHandSize = 0;
		for (int i = heartY + 1; i < size; i++) {
			if (cookie[heartX][i] == '*') rightHandSize++;
			else break;
		}
		
		//심장 기준 아래쪽으로 허리 길이를 재고, 허리 끝을 찾는다.
		int huriSize = 0;
		int huriEndX = 0;
		for (int i = heartX + 1; i < size; i++) {
			if (cookie[i][heartY] == '*') huriSize++;
			else {
				huriEndX = i - 1;
				break;
			}
		}
		
		//허리끝을 기준으로 왼다리와 오른다리 길이를 잰다.
		int leftLegSize = 0;
		for (int i = huriEndX + 1; i < size; i++) {
			if (cookie[i][heartY - 1] == '*') leftLegSize++;
			else break;
		}
		
		int rightLegSize = 0;
		for (int i = huriEndX + 1; i < size; i++) {
			if (cookie[i][heartY + 1] == '*') rightLegSize++;
			else break;
		}
		
		return new StringBuilder()
				.append(heartX + 1).append(" ")
				.append(heartY + 1).append("\n")
				.append(leftHandSize).append(" ")
				.append(rightHandSize).append(" ")
				.append(huriSize).append(" ")
				.append(leftLegSize).append(" ")
				.append(rightLegSize)
				.toString();
 	}
}