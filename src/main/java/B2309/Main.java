package B2309;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int sum = 0;
        int[] arr = new int[9];
        boolean isEnd = false;
        int i1 = 0;
        int i2 = 0;

        for (int i = 0; i < 9; i++) {
            arr[i] = sc.nextInt();
            sum += arr[i];
        }

        Arrays.sort(arr);

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == j) {
                    continue;
                }
                if (sum - (arr[i] + arr[j]) == 100) {
                    isEnd = true;
                    i1 = i;
                    i2 = j;
                    break;
                }
            }
            if (isEnd) break;
        }

        for (int i = 0; i < 9; i++) {
            if (i != i1 && i != i2) {
                System.out.println(arr[i]);
            }
        }
    }
}
