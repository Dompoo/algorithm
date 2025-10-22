import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3079
@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] times = new long[n];
        long maxTime = 0;

        for (int i = 0; i < n; i++) {
            times[i] = Long.parseLong(br.readLine());
            maxTime = Math.max(maxTime, times[i]);
        }

        // 이분 탐색 범위 설정
        long left = 1;
        long right = maxTime * m;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            // mid 시간 동안 처리할 수 있는 사람 수 계산
            long sum = 0;
            for (int i = 0; i < n; i++) {
                sum += mid / times[i];

                // 오버플로우 방지
                if (sum >= m) {
                    break;
                }
            }

            if (sum >= m) {
                // m명 이상 처리 가능하면 시간을 줄여본다
                answer = mid;
                right = mid - 1;
            } else {
                // m명 처리 불가능하면 시간을 늘린다
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
