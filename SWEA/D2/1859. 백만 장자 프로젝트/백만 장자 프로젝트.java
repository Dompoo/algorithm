import java.util.*;
import java.io.*;

class Solution
{
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int test_case = 1; test_case <= T; test_case++) {
            int days = Integer.parseInt(br.readLine());
            int[] money = new int[days];
            String[] inputs = br.readLine().split(" ");
            for (int i = 0; i < days; i ++) {
                money[i] = Integer.parseInt(inputs[i]);
            }

            long answer = 0;
            int max = 0;
            for (int i = days - 1; i >= 0; i--) {
                if (max < money[i]) {
                    max = money[i];
                } else {
                    answer += max - money[i];
                }
            }

            sb.append("#")
                    .append(test_case)
                    .append(" ")
                    .append(answer);
            if (test_case != T) {
                sb.append("\n");
            }
        }
        System.out.print(sb);
    }
}