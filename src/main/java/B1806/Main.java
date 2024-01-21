package B1806;

import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrLen = sc.nextInt();
        int targetSum = sc.nextInt();
        int[] arr = new int[arrLen];

        for (int i = 0; i < arrLen; i++) {
            arr[i] = sc.nextInt();
        }

        int minLength = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int curSum = 0;

        while (start < arrLen && end <= arrLen) {
            if (curSum < targetSum && end < arrLen) {
                curSum += arr[end++];
            } else if (curSum >= targetSum) {
                minLength = Math.min(minLength, end - start);
                curSum -= arr[start++];
            } else {
                break;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            System.out.println(0);
        } else {
            System.out.println(minLength);
        }

    }
}
