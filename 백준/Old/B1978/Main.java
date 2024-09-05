package B1978;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int testCase = sc.nextInt();
        int number = 0;
        boolean isPrime = true;
        int ans = 0;

        for (int i = 0; i < testCase; i++) {
            number = sc.nextInt();
            isPrime = true;

            if (number == 1) {
                continue;
            }

            for (int j = 1; j < number; j++) {
                if (number % j == 0 && j != 1) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                ans++;
            }
        }
        System.out.println(ans);
    }
}
