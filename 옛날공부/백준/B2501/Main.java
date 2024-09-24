package B2501;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int[] arr = new int[a];
        int c = 0;

        for (int i = 1; i <= a; i++) {
            if (a % i == 0) {
                arr[c] = i;
                c++;
            }
        }

        System.out.println(arr[b-1]);
    }
}