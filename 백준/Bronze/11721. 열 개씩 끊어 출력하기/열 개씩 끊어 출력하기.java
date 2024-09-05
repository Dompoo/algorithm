import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.next();
		for (int start = 0; start < input.length(); start += 10) {
			int end = 0;
			if (start + 10 > input.length()) {
				end = input.length();
			} else {
				end = start + 10;
			}
			
			System.out.println(input.substring(start, end));
		}
		
	}
}
