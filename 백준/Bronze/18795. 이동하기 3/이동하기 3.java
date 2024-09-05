import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int i = sc.nextInt();
		int j = sc.nextInt();
		
		int time = i + j;
		
		long sum = 0;
		for (int k = 0; k < time; k++) {
			sum += sc.nextInt();
		}
		
		System.out.println(sum);
	}
}