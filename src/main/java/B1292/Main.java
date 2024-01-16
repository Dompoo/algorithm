package B1292;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int start = sc.nextInt();
        int end = sc.nextInt();

        //arr 구축
        int[] arr = new int[end];
        int num = 1;
        int maxindex = 1;
        for (int index = 0; index < end; index++) {
            if (index == maxindex) {
                num++;
                maxindex += num;
            }
            arr[index] = num;
        }

        //ans 구하기
        int ans = 0;
        for (int number = start - 1; number < end; number++) {
            ans += arr[number];
        }

        System.out.println(ans);
    }
}
