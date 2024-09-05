package B15486;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] time = new int[n + 1];
        int[] pay = new int[n + 1];
        int[] maxPay = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            time[i] = sc.nextInt();
            pay[i] = sc.nextInt();
        }

        for (int i = 1; i <= n ; i++) {
            int nextDay = i + time[i];

            //상담을 진행할 수 있는 경우
            if (nextDay <= n + 1) {
                maxPay[nextDay] = Math.max(maxPay[nextDay], maxPay[i] + pay[i]);
            }
            maxPay[i + 1] = Math.max(maxPay[i + 1], maxPay[i]);
        }


        System.out.println(maxPay[n + 1]);
    }
}
