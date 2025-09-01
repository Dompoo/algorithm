import java.io.*;
import java.util.*;

/*
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long amountSum = 0;
        long[][] arr = new long[N][2];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long position = Integer.parseInt(st.nextToken());
            long amount = Integer.parseInt(st.nextToken());
            arr[i] = new long[]{position, amount};
            amountSum += amount;
        }

        Arrays.sort(arr, Comparator.comparingLong(a -> a[0])); // 위치순으로 정렬
        long target = (amountSum + 1) / 2;
        long currentSum = 0;

        for (int i = 0; i < N; i++) {
            long currentPosition = arr[i][0];
            long currentAmount = arr[i][1];
            currentSum += currentAmount;
            if (currentSum >= target) {
                System.out.println(currentPosition);
                return;
            }
        }
    }
}
