package B2581;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int min = sc.nextInt();
        int max = sc.nextInt();
        int minPrime = -1;
        int sumPrime = 0;
        boolean isFirstPrime = true;

        for (int i = min; i <= max; i++) {
            if (isPrime(i)) {
                if (isFirstPrime) {
                    minPrime = i;
                    isFirstPrime = false;
                }
                sumPrime += i;
            }
        }

        //결과 출력
        if (minPrime != -1) {
            System.out.println(sumPrime);
        }
        System.out.println(minPrime);

    }

    private static boolean isPrime(int number) {
        boolean isPrime = true;

        if (number == 1) {
            return false;
        }

        for (int i = 1; i < number; i++) {
            if (number % i == 0 && i != 1) {
                isPrime = false;
                break;
            }
        }

        return isPrime;
    }
}
