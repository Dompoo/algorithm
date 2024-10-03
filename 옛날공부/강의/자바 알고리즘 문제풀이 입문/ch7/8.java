import java.util.*;

class Main {

    public static int hyun;
    public static int song;
    public int[] dx = new int[] {1, -1, 5};

    public class Point {

        public int hyun;
        public int attemps;

        public Point(int hyun, int attemps) {
            this.hyun = hyun;
            this.attemps = attemps;
        }

        public List<Point> getNextPoints() {
            List<Point> list = new ArrayList<>();
            for(int i = 0; i < 3; i++) {
                int next = this.hyun + dx[i];
                if(1 <= next && next <= 10000) {
                    list.add(new Point(next, this.attemps + 1));
                }
            }
            return list;
        }
    }

    public int solution() {
        // 좌표점 1 ~ 10000
        int result = 0;

        // song 최적화 :
        /*
        5 14
        ->
        10 14 하고 attemp 1개 추가하기
        */
        int preAttemps = 0;
        int preHyun = hyun;

        if(hyun < song) {
            // 작은 상태라면 5개씩 점프해서 가깝게 접근
            while(song - preHyun >= 5) {
                preHyun += 5;
                preAttemps++;
            }
        } else if(hyun > song) {
            // 큰 상태라면 -1로 그냥 return해버리기
            return hyun - song;
        }
        

        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(preHyun, preAttemps));

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            // System.out.println(point.hyun + " " + song);
            if(point.hyun == song) {
                result = point.attemps;
                break;
            } else {
                for(Point nextPoint : point.getNextPoints()) {
                    queue.offer(nextPoint);
                }
            }
        }

        return result;
    }

    // 수학적 접근
    public int solution2() {
        int preAttemps = 0;
        int preHyun = hyun;

        if(hyun < song) {
            // 작은 상태라면 5개씩 점프해서 가깝게 접근
            while(song - preHyun >= 5) {
                preHyun += 5;
                preAttemps++;
            }
        } else if(hyun > song) {
            // 큰 상태라면 -1로 그냥 return해버리기
            return hyun - song;
        }

        int nextAttemps = 0;
        switch(song - preHyun) {
            case 4: nextAttemps = 2; break;
            case 3: nextAttemps = 3; break;
            case 2: nextAttemps = 2; break;
            case 1: nextAttemps = 1; break;
            case 0: nextAttemps = 0; break;
        }

        return preAttemps + nextAttemps;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        hyun = sc.nextInt();
        song = sc.nextInt();
        System.out.println(new Main().solution2());
    }
}