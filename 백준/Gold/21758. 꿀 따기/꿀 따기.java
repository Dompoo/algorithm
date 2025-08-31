import java.io.*;
import java.util.*;

/*
a b c d e f g h

case1
ah벌 중간꿀
-> bcdefg + X
(b <= X <= g)

case2
a꿀 h벌
-> abcdefg - X + sum(a ~ X-1)
(b <= X <= g)

case3
h꿀 a벌
-> bcdefgh - X + sum(X+1 ~ h)
(b <= X <= g)

모두 계산해서 최대값!
 */
public class Main {

    private static int[] prefixSum;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        prefixSum = new int[N + 1]; // a~b까지의 합을 구하고 싶으면 prefixSum[b+1] - prefixSum[a];
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());
            prefixSum[i + 1] = prefixSum[i] + number;
            arr[i] = number;
        }

        int maxSum = Integer.MIN_VALUE;

        // case1 벌 꿀 벌
        // sum(1~N-1) + arr[i]
        for (int i = 1; i < N -1; i++) {
            int result = arr[i] + sumBetween(1, N-2);
            // System.out.printf("case1, i=%d, result=%d\n", i, result);
            maxSum = Math.max(maxSum, result);
        }

        // case2 꿀 벌 벌
        // sum(0~N-1) - arr[i] + sum(0, i-1)
        for (int i = 1; i < N -1; i++) {
            int result = sumBetween(0, N-2) - arr[i] + sumBetween(0, i-1);
            // System.out.printf("case2, i=%d, result=%d\n", i, result);
            maxSum = Math.max(maxSum, result);
        }

        // case3 벌 벌 꿀
        // sum(1~N) - arr[i] + sum(i+1, N)
        for (int i = 1; i < N -1; i++) {
            int result = sumBetween(1, N-1) - arr[i] + sumBetween(i+1, N-1);
            // System.out.printf("case3, i=%d, result=%d\n", i, result);
            maxSum = Math.max(maxSum, result);
        }

        System.out.println(maxSum);
    }

    private static int sumBetween(int start, int end) {
        return prefixSum[end + 1] - prefixSum[start];
    }
}
