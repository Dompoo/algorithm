import java.util.*;

class Main {

    static class Problem {
        int time;
        int score;

        public Problem(int score, int time) {
            this.score = score;
            this.time = time;
        }
        
    }

    public static int size;
    public static int time;
    public static List<Problem> list = new ArrayList<>();

    public int solution() {
        /*
        10 5
        25 12
        15 8
        6 3
        7 4
        */
        int[] dp = new int[time + 1];

        for(Problem problem : list) {
            for(int i = time; i >= 0; i--) {
                int clearTime = i + problem.time;
                if(clearTime <= time) {
                    dp[clearTime] = Math.max(dp[clearTime], dp[i] + problem.score);
                }
            }
            // for(int i = 0; i <= time; i++) System.out.print(dp[i] + " ");
            // System.out.println();

        }

        return dp[time];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        time = sc.nextInt();
        for(int i = 0; i < size; i++) {
            int score = sc.nextInt();
            int time = sc.nextInt();
            list.add(new Problem(score, time));
        }
        System.out.println(new Main().solution());
    }
}