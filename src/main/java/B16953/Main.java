package B16953;

import java.util.Scanner;

public class Main {
    static int target;
    static int minCal = Integer.MAX_VALUE;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        target = sc.nextInt();

        DFS(n, 1);

        System.out.println(minCal == Integer.MAX_VALUE ? -1 : minCal);
    }

    public static void DFS(int num, int curCal) {
        if (num == target) {
            minCal = Math.min(curCal, minCal);
        }

        long mul2Num = num * 2L;
        long add1Num = Long.parseLong(String.valueOf(num) + '1');

        boolean canMul2 = mul2Num < Integer.MAX_VALUE;
        boolean canAdd1 = add1Num < Integer.MAX_VALUE;

        if (canMul2 && (mul2Num <= target)) {
            DFS((int) mul2Num, curCal + 1);
        }
        if (canAdd1 && (add1Num <= target)) {
            DFS((int) add1Num, curCal + 1);
        }
    }
}
