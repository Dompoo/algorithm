package B10870;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int small = 0;
        int temp = 0;
        int big = 1;

        /*
        0 1 1 2 3 5

        a가 1일때 1번돔 -> 1 1
        1
        a가 2일때
        1
         */
        for (int i = 0; i < a; i++) {
            temp = small;
            small = big;
            big = temp + big;
        }
        System.out.println(small);
    }
}
