package B2460;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int in = 0;
        int out = 0;
        int curr = 0;
        int max = 0;

        do {
            out = sc.nextInt();
            in = sc.nextInt();
            curr -= out;
            curr += in;
            if (curr > max) {
                max = curr;
            }
        } while (curr != 0);
        System.out.println(max);

    }
}
