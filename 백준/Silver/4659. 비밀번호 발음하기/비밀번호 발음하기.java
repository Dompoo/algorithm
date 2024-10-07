import java.util.*;

class Main {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<String> list = new ArrayList<>();
		while(true) {
			String str = sc.nextLine();
			if (str.equals("end")) break;
			else list.add(str);
		}
		solution(list);
	}
	
	private static boolean isMoem(char ch) {
		return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch == 'u';
	}
	
	private static void solution(List<String> list) {
		StringBuilder sb = new StringBuilder();
		
		for (int t = 0; t < list.size(); t++) {
			String str = list.get(t);
			
			sb.append("<").append(str).append("> is ");
			char[] arr = str.toCharArray();
			boolean hasMoem = false;
			boolean isOk = true;
			
			for (int i = 0; i < str.length(); i++) {
				if(i - 2 >= 0) { // 3연속 자음 모음 안된다.
					if (isMoem(arr[i]) && isMoem(arr[i - 1]) && isMoem(arr[i - 2]) ||
							!isMoem(arr[i]) && !isMoem(arr[i - 1]) && !isMoem(arr[i - 2])) {
						isOk = false;
						break;
					}
				}
				if(i - 1 >= 0) { // ee oo 제외 연속 글자 안된다.
					if (arr[i] == arr[i - 1] && arr[i] != 'e' && arr[i] != 'o') {
						isOk = false;
						break;
					}
				}
				if (isMoem(arr[i])) hasMoem = true;
			}
			
			if(!isOk || !hasMoem) {
				sb.append("not ");
			}
			sb.append("acceptable.\n");
		}
		
		System.out.println(sb);
	}
}