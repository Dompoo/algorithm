import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// dp[X] = X원을 만들때 동전 최소 개수
// dp[X] = Math.min(
//              dp[X - arr[0]] + 1,
//              dp[X - arr[1]] + 1,
//              ...
//
// 즉, 0번째 동전을 사용했을 때, 남은 금액을 처리하는 최적 방법, 1번재 동전을 사용했을 때, 남은 금액을 처리하는 최적 방법
// 등등을 구하는 것이다.

// 예상 시간 복잡도 : N*K = 1_000_000 -> 1초 처리 가능!
@SuppressWarnings("ALL")
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());
            arr[i] = num;
        }

        int[] dp = new int[K + 1];
        Arrays.fill(dp, -1); // -1은 채우는게 불가능하다는 뜻이다.
        dp[0] = 0;

        for (int dpIndex = 1; dpIndex <= K; dpIndex++) {
            int totalMin = Integer.MAX_VALUE;
            for (int compareIndex = 0; compareIndex < N; compareIndex++) {
                if (dpIndex - arr[compareIndex] < 0) continue; // dp범위를 벗어나면 X
                if (dp[dpIndex - arr[compareIndex]] == -1) continue; // 최적해가 존재하지 않으면 X
                int currentMin = dp[dpIndex - arr[compareIndex]] + 1;
                totalMin = Math.min(totalMin, currentMin);
            }
            if (totalMin == Integer.MAX_VALUE) continue; // 최적해가 존재하지 않으면 X
            dp[dpIndex] = totalMin;
        }

        System.out.println(dp[K]);
    }
}
