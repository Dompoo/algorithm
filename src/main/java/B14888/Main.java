package B14888;

import java.util.Scanner;

public class Main {
    static int maxResult;
    static int minResult;
    static int arrSize;
    static int[] number;
    static int[] operator;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        arrSize = sc.nextInt();
        number = new int[arrSize];
        operator = new int[4];
        maxResult = Integer.MIN_VALUE;
        minResult = Integer.MAX_VALUE;

        //숫자 저장
        for (int i = 0; i < arrSize; i++) {
            number[i] = sc.nextInt();
        }

        //연산자 저장
        for (int i = 0; i < 4; i++) {
            operator[i] = sc.nextInt();
        }

        //연산
        DFS(operator[0], operator[1], operator[2], operator[3], number[0], 1);

        //결과 출력
        System.out.println(maxResult);
        System.out.println(minResult);

    }

    private static void DFS(int p, int m, int x, int d, int result, int index) {
        if (index == arrSize) {
            maxResult = Math.max(maxResult, result);
            minResult = Math.min(minResult, result);
            return;
        }

        if (p > 0) DFS(p - 1, m, x, d, result + number[index], index + 1);
        if (m > 0) DFS(p, m - 1, x, d, result - number[index], index + 1);
        if (x > 0) DFS(p, m, x - 1, d, result * number[index], index + 1);
        if (d > 0) DFS(p, m, x, d - 1, result / number[index], index + 1);
    }
}
