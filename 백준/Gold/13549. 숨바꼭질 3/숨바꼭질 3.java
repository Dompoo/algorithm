import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/13549
@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] minTime = new int[100_001];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        Deque<int[]> deque = new ArrayDeque<>();
        deque.offerLast(new int[]{K, 0});
        minTime[K] = 0;
        while (!deque.isEmpty()) {
            int[] current = deque.pollFirst();
            int curPos = current[0];
            int curTime = current[1];
            if (curPos == N) {
                System.out.println(curTime);
                break;
            } else {
                int teleportPos = curPos / 2;
                int frontPos = curPos + 1;
                int backPos = curPos - 1;

                if (curPos % 2 == 0 && teleportPos <= 100_000 && minTime[teleportPos] > curTime) {
                    deque.offerFirst(new int[]{teleportPos, curTime});
                    minTime[teleportPos] = curTime;
                }
                if (backPos >= 0 && minTime[backPos] > curTime + 1) {
                    deque.offerLast(new int[]{backPos, curTime + 1});
                    minTime[backPos] = curTime + 1;
                }
                if (frontPos <= 100_000 && minTime[frontPos] > curTime + 1) {
                    deque.offerLast(new int[]{frontPos, curTime + 1});
                    minTime[frontPos] = curTime + 1;
                }
            }
        }
    }
}
