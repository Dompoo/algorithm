package B10431;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int test = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int t = 0; t < test; t++) {
            int testNum = sc.nextInt();
            int[] input = new int[20];
            for (int i = 0; i < 20; i++) {
                input[i] = sc.nextInt();
            }

            int walk = 0;

            for (int i = 0; i < 20; i++) {
                int curWalk = 0;
                for (int j = 0; j < i; j++) {
                    if (input[i] < input[j]) {
                        curWalk++;
                    }
                }
                walk += curWalk;
            }
            sb.append(testNum).append(" ").append(walk);
            if (t != test - 1) sb.append("\n");
        }

        System.out.println(sb);
    }
}
