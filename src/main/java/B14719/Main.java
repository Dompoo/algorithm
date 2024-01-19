package B14719;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int height = sc.nextInt();
        int width = sc.nextInt();

        boolean[] isUp = new boolean[width];
        int[] block = new int[width];

        for (int i = 0; i < width; i++) {
            block[i] = sc.nextInt();
            if (i == 0) {
                isUp[i] = true;
            } else {
                isUp[i] = block[i - 1] <= block[i];
            }
        }
        /*
        첫번째 블록은 무조건 +경향
        나머지는 전 블록 보다 크거나 같으면 +
        작으면 -
        + - - + 같은 경향에서
        + 중에 더 작은 블록의 높이 X - 의 개수 : 빈 공간의 크기
        여기에 - 블록의 높이를 모두 빼면 빗물의 높이
        */

        int towerHeight = 0;

        for (int i = 0; i < width; i++) {
            if (isUp[i]) {
                towerHeight = block[i];
            }
        }
    }
}
