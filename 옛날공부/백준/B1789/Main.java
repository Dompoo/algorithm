package B1789;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long maxSum = sc.nextLong();

        long sum = 0;
        long addNumber = 1;
        long N = 0;

        while (sum <= maxSum) {
            sum += addNumber++;
            N++;
        }

        System.out.println(N - 1);
    }
}
