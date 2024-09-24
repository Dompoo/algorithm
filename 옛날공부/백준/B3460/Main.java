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
            boolean isFirst = true;

            for (int j = 0; target > 0; j++) {

                if (target % 2 == 1) {
                    if (!isFirst) {
                        System.out.print(" ");
                    }
                    System.out.print(j);
                    isFirst = false;
                }

                target = target / 2;
            }
            System.out.println();
        }

        sc.close();
    }
}
