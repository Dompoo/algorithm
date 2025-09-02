import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        System.out.println(lisLength(arr)); // O(N log N)
    }

    // 최장 "증가" 부분수열 길이 (strictly increasing)
    static int lisLength(int[] a) {
        int n = a.length;
        int[] tails = new int[n];
        int len = 0;
        for (int x : a) {
            int pos = lowerBound(tails, 0, len, x); // 첫 >= x 위치
            tails[pos] = x;
            if (pos == len) len++;
        }
        return len;
    }

    // Arrays.binarySearch로 lower_bound 구현
    static int lowerBound(int[] arr, int from, int to, int key) {
        int idx = Arrays.binarySearch(arr, from, to, key);
        return (idx < 0) ? -idx - 1 : idx; // 첫 >= key 위치
    }
}
