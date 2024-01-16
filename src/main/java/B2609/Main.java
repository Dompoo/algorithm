package B2609;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int b = sc.nextInt();
        int s = sc.nextInt();

        //b를 더 크게 만들기 위함
        if (b < s) {
            int temp = s;
            s = b;
            b = temp;
        }

        //최대공약수 구하기
        for (int i = s; i > 0; i--) {
            if (((b % i) == 0) && ((s % i) == 0)) {
                System.out.println(i);
                break;
            }
        }

        //최소공배수 구하기
        for (int i = 1; ; i++) {
            int ll = s * i;
            if (ll % b == 0) {
                System.out.println(ll);
                break;
            }
        }
    }
}
