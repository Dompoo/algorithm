import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int row = sc.nextInt();
		int col = sc.nextInt();
		
		int[] ninesOfRow = new int[row];
		int[] ninesOfCol = new int[col];
		
		int ninesSum = 0;
		
		for (int i = 0; i < row; i++) {
			int tempSum = 0;
			for (int j = 0; j < col; j++) {
				String number = sc.next();
				
				int nineInTheString = 0;
				for (int k = 0; k < number.length(); k++) {
					if (number.charAt(k) == '9') {
						nineInTheString++;
					}
				}
				
				tempSum += nineInTheString;
				ninesOfCol[j] += nineInTheString;
				ninesSum += nineInTheString;
			}
			ninesOfRow[i] = tempSum;
		}
		
		int maxNine = 0;
		
		for (int i = 0; i < row; i++) {
			if (ninesOfRow[i] > maxNine) {
				maxNine = ninesOfRow[i];
			}
		}
		
		for (int i = 0; i < col; i++) {
			if (ninesOfCol[i] > maxNine) {
				maxNine = ninesOfCol[i];
			}
		}
		
		System.out.println(ninesSum - maxNine);
		
	}
}