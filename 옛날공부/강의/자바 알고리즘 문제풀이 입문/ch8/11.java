import java.util.*;

class Main {

    public static int N = 7;
    public static int[][] arr = new int[N][N];
    public boolean[][] isChecked = new boolean[N][N];
    public int[] dx = new int[] {0, 0, 1, -1};
    public int[] dy = new int[] {1, -1, 0, 0};

    public class Point {

        int x;
        int y;
        int length;

        public Point(int x, int y, int length) {
            this.x = x;
            this.y = y;
            this.length = length;
        }

        public List<Point> getNearPoints() {
            List<Point> points = new ArrayList<>();
            for(int i = 0; i < 4; i++) {
                int nx = this.x + dx[i];
                int ny = this.y + dy[i];
                if(0 <= nx && nx < N && 0 <= ny && ny < N) {
                    points.add(new Point(nx, ny, this.length + 1));
                }
            }
            return points;
        }
    }

    public int solution() {
        isChecked[0][0] = true;
        Queue<Point> queue = new LinkedList<>();

        queue.offer(new Point(0, 0, 0));
        
        int result = 0;

        while(!queue.isEmpty()) {
            Point point = queue.poll();
            if(point.x == N - 1 && point.y == N - 1) {
                return point.length;
            }

            for(Point nearPoint : point.getNearPoints()) {
                if(arr[nearPoint.x][nearPoint.y] == 0 && !isChecked[nearPoint.x][nearPoint.y]) {
                    isChecked[nearPoint.x][nearPoint.y] = true;
                    queue.offer(nearPoint);
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < N; i++) {
            String input = sc.nextLine();
            String[] inputs = input.split(" ");
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        System.out.println(new Main().solution());
    }
}