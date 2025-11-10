import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

@SuppressWarnings("ALL")
public class Main {

    static class Job implements Comparable<Job> {

        int start;
        int end;

        public Job(int start, int end) {
            this.start = start;
            this.end = end;
        }

        public int compareTo(Job other) {
            if (this.start != other.start) return this.start - other.start;
            return (other.end - other.start) - (this.end - this.start);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Job> pq = new PriorityQueue<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            pq.offer(new Job(start, end));
        }

        int[] calendar = new int[365];
        while (!pq.isEmpty()) {
            Job job = pq.poll();
            for (int i = job.start; i <= job.end; i++) {
                calendar[i]++;
            }
        }

        int sum = 0;
        int curMax = 0;
        int continueStartDate = 0;
        boolean isContinued = false;
        for (int i = 0; i < 365; i++) {
            // 끊기는 경우
            if (calendar[i] == 0 && isContinued) {
                isContinued = false;
                sum += (i - continueStartDate) * curMax;
            } else if (calendar[i] != 0 && isContinued) {
                curMax = Math.max(curMax, calendar[i]);
            } else if (calendar[i] != 0 && !isContinued) {
                isContinued = true;
                continueStartDate = i;
                curMax = calendar[i];
            }
        }
        if (isContinued) {
            sum += (365 - continueStartDate) * curMax;
        }
        System.out.println(sum);
    }
}
