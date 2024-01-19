package B14719;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int[] block;
    static int[] rainArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int width = sc.nextInt();

        block = new int[width];
        rainArr = new int[width];

        for (int i = 0; i < width; i++) {
            block[i] = sc.nextInt();
        }

        //모든 i < j 쌍에 대해서 물 높이를 구한다.
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if (i < j) {
                    getRain(i, j);
                }
            }
        }

        System.out.println(Arrays.stream(rainArr).sum());
    }

    public static void getRain(int index1, int index2) {

        int maxRain = Math.min(block[index1], block[index2]);
        int rain;

        //i와 j 사이의 블록에 대하여 물 높이를 구한다.
        //모든 index1 과 index2에 대해서 함수가 작동하므로.
        //결국 최대 물 높이가 나온다.
        for (int i = index1 + 1; i < index2; i++) {
            rain = maxRain - block[i];
            rainArr[i] = Math.max(rainArr[i], rain);
        }
    }
}
