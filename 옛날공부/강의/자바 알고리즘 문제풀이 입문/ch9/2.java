import java.util.*;

class Main {

    public static int maxTime;
    public static List<Meeting> list = new ArrayList<>();

    static class Meeting implements Comparable<Meeting> {
        int start;
        int end;

        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting other) {
            if(this.end == other.end) {
                return this.start - other.start;
            } else {
                return this.end - other.end;
            } 
        }

        @Override
        public String toString() {
            return this.start + " " + this.end;
        }
    }

    public int dpSolution() {
        Collections.sort(list, (a, b) -> a.start - b.start);

        int[] dp = new int[maxTime + 1]; //n시까지 끝나는 최대 회의 수
        int result = Integer.MIN_VALUE;

        for(Meeting meet : list) {
            // 해당 회의가 시작하기 전까지 할 수 있는 회의의 최대 수
            int maxMeeting = Integer.MIN_VALUE;
            for(int i = 0; i <= meet.start; i++) {
                maxMeeting = Math.max(maxMeeting, dp[i]);
            }

            dp[meet.end] = Math.max(maxMeeting + 1, dp[meet.end]);
            result = Math.max(result, dp[meet.end]);
        }

        return result;
    }

    public int solution() {
        Collections.sort(list);

        int result = 0;
        int lastEndTime = 0;
        for(Meeting meet : list) {
            if(meet.start >= lastEndTime) {
                result++;
                lastEndTime = meet.end;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for(int i = 0; i < size; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            maxTime = Math.max(end, maxTime);
            list.add(new Meeting(start, end));
        }
        System.out.println(new Main().solution());
    }
}