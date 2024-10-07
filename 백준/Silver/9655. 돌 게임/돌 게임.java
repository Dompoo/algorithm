import java.io.*;
import java.util.*;

class Main {
	
	// 1개 일때 상 승
	// 2개 일때 창 승
	// 3개 일때 상 승
	// 4개 일때 상1 창3 창승리 / 상3 창1 창승리
	// 5개 일때 상1 창1 상3 / 상3 1 상 승리
	// 5 상근
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		
		System.out.println(target % 2 == 0 ? "CY" : "SK");
	}
}