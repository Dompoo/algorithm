import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		float[] juices = new float[3];
		float[] ratio = new float[3];
		
		for (int i = 0; i < 3; i++) {
			juices[i] = sc.nextFloat();
		}
		
		for (int i = 0; i < 3; i++) {
			ratio[i] = sc.nextFloat();
		}
		
		float bestCocktailNumber = 500;
		
		for (int i = 0; i < 3; i++) {
			if (bestCocktailNumber > juices[i] / ratio[i]) {
				bestCocktailNumber = juices[i] / ratio[i];
			}
		}
		
		for (int i = 0; i < 3; i++) {
			System.out.println(juices[i] - ratio[i] * bestCocktailNumber);
		}
	}
}