import java.util.*;

class Main {

    static class Brick implements Comparable<Brick> {
        int size;
        int heigth;
        int weigth;

        public Brick(int heigth, int size, int weigth) {
            this.heigth = heigth;
            this.size = size;
            this.weigth = weigth;
        }

        public boolean canStackAfter(Brick other) {
            return this.size >= other.size && this.weigth >= other.weigth;
        }

        @Override
        public int compareTo(Brick o) {
            return this.size - o.size;
        }

        @Override
        public String toString() {
            return this.size + " " + this.heigth + " " + this.weigth;
        }
    }

    public static List<Brick> list = new ArrayList<>();
    public static int size;

    public int solution() {
        Collections.sort(list);
        int[] dp = new int[size];

        // System.out.println(list);

        for(int i = 0; i < size; i++) {
            Brick brick = list.get(i);

            // 이번 블록을 쌓아서 얻을 수 있는 최대 높이를 계산
            int maxLen = brick.heigth;
            for(int j = i - 1; j >= 0; j--) {
                Brick other = list.get(j);
                if(brick.canStackAfter(other)) {
                    maxLen = Math.max(maxLen, dp[j] + brick.heigth);
                }
            }
            dp[i] = maxLen;
        }
        
        int result = 0;
        for(int i = 0; i < size; i++) {
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        for(int i = 0; i < size; i++) {
            int s = sc.nextInt();
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Brick(h, s, w));
        }
        System.out.println(new Main().solution());
    }
}