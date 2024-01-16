package B3460;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCase = sc.nextInt();
        int[] arr = new int[testCase];

        for (int i = 0; i < testCase; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < testCase; i++) {
            int target = arr[i];

            while (true) {
                System.out.print(target % 2);
                target = target / 2;
                if (target == 0 | target == 1) {
                    break;
                }
                System.out.println();
            }
        }

        sc.close();
    }
}
