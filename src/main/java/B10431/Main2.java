package B10431;

import java.util.Scanner;

public class Main2 {
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

            int curIndex = 1;
            int[] line = new int[20];
            line[0] = input[0];
            for (int i = 1; i < 20; i++) {

                boolean isShifted = false;
                for (int j = 0; j < curIndex; j++) {
                    if (line[j] > input[i]) {
                        //한칸씩 미루고
                        for (int k = curIndex; k > j; k--) {
                            line[k] = line[k - 1];
                        }
                        line[j] = input[i];
                        walk += curIndex - j;
                        isShifted = true;
                        break;
                    }
                }

                if (!isShifted) {
                    line[curIndex] = input[i];
                }
                curIndex++;
            }
            sb.append(testNum).append(" ").append(walk);
            if (t != test - 1) sb.append("\n");
        }

        System.out.println(sb);

    }
}
