package B11722;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        int[] dp = new int[N]; //i번째까지 고려했을 때,

        Arrays.fill(dp, 1);

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] < arr[j] && dp[j] + 1 > dp[i]) {
                    //dp[j] + 1 > dp[i] :
                    //현재까지의 최대 길이 수열에 해당 j번째 수를 더해서 나온 수열의 길이가
                    //그냥 현재 j번째 수열의 길이보다 길다면
                    // ->
                    dp[i] = dp[j] + 1;
                }
            }
        }

        System.out.println(Arrays.stream(dp).max().getAsInt());
    }
}
