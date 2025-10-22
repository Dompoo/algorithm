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

        int[] lecs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            lecs[i] = Integer.parseInt(st.nextToken());
        }

        int result = -1;
        int left = Arrays.stream(lecs).max().getAsInt();
        int right = Arrays.stream(lecs).sum();

        while (left <= right) {
            int mid = (left + right) / 2;

            int cdNeedCount = 1;
            int sum = 0;
            for (int lec : lecs) {
                sum += lec;
                if (sum > mid) {
                    cdNeedCount++;
                    sum = lec;
                }
            }

            if (cdNeedCount <= M) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        System.out.println(result);
    }
}
