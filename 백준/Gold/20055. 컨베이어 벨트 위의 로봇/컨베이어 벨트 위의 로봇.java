import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        List<Integer> belt = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * N; i++) {
            belt.add(Integer.parseInt(st.nextToken()));
        }

        int step = 0;
        int zeroCount = 0;
        List<Boolean> robots = new ArrayList<>();
        for (int i = 0; i < 2 * N; i++) {
            robots.add(false);
        }
        while (zeroCount < K) {
            step++;

            Collections.rotate(belt, 1);
            Collections.rotate(robots, 1);
            robots.set(N - 1, false); // 회전 후 내릴 수 있으면 내리기

            for (int i = N - 2; i >= 0; i--) {
                if (!robots.get(i)) continue;

                if (!robots.get(i + 1) && belt.get(i + 1) > 0) {
                    robots.set(i, false);
                    if (i + 1 != N - 1) robots.set(i + 1, true);
                    belt.set(i + 1, belt.get(i + 1) - 1);
                    if (belt.get(i + 1) == 0) zeroCount++;
                }
            }

            robots.set(N - 1, false); // 회전 후 내릴 수 있으면 내리기

            if (belt.get(0) > 0) {
                robots.set(0, true);
                belt.set(0, belt.get(0) - 1);
                if (belt.get(0) == 0) zeroCount++;
            }
        }

        System.out.println(step);
    }
}
