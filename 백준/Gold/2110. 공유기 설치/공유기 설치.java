import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3079
@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] house = new int[N];

        for (int i = 0; i < N; i++) {
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);

        int minDiff = Integer.MAX_VALUE;
        for (int i = 0; i < N - 1; i++) {
            minDiff = Math.min(minDiff, house[i + 1] - house[i]);
        }

        int result = -1;
        int left = minDiff;
        int right = house[N - 1] - house[0];

        while (left <= right) {
            int mid = (left + right) / 2;

            int sharerCount = 1;
            int lastShaererPos = house[0];
            for (int i = 1; i < N; i++) {
                if (mid <= house[i] - lastShaererPos) {
                    lastShaererPos = house[i];
                    sharerCount++;
                }
            }

            if (sharerCount >= M) {
                result = mid; // 더 많이 설치했어? 좀 더 빡세게(거리 멀게) 설치해봐
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        System.out.println(result);


    }
}
