import java.util.*;

/*
3
KBS1
KBS2
MBC
4

1번 행동 : 아래로 움직이기
2번 행동 : 위로 움직이기
3번 행동 : 현재와 아래와 바꾸고 아래 보기
4번 행동 : 현재와 위를 바꾸고 위 보기
*/

class Main {
	
	public String solution(int size, String[] arr, int kbs1, int kbs2) {
		StringBuilder sb = new StringBuilder();
		if(kbs1 < kbs2) {
			//1로 내려가서 4로 1순위까지 올리기 -> 1번 완료
			for(int i = 0; i < kbs1; i++) sb.append("1");
			for(int i = 0; i < kbs1; i++) sb.append("4");
			//1로 내려가서 4로 2순위까지 올리기 -> 2번 완료
			for(int i = 0; i < kbs2; i++) sb.append("1");
			for(int i = 0; i < kbs2 - 1; i++) sb.append("4"); //2순위 이므로 -1
		} else {
			//1로 내려가서 4로 1순위까지 올리기 -> 1번 완료
			for(int i = 0; i < kbs1; i++) sb.append("1");
			for(int i = 0; i < kbs1; i++) sb.append("4");
			//1로 내려가서 4로 2순위까지 올리기 -> 2번 완료
			for(int i = 0; i < kbs2 + 1; i++) sb.append("1"); //KBS1하느라 한칸 밀렸으므로 + 1
			for(int i = 0; i < kbs2; i++) sb.append("4"); //KBS1하느라 한칸 밀렸으므로 + 1
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		int kbs1 = 0;
		int kbs2 = 0;
		String[] arr = new String[size];
		for (int i = 0; i < size; i++) {
			String str = sc.next();
			if(str.equals("KBS1")) kbs1 = i;
			if(str.equals("KBS2")) kbs2 = i;
			arr[i] = str;
		}
		System.out.println(new Main().solution(size, arr, kbs1, kbs2));
	}
}