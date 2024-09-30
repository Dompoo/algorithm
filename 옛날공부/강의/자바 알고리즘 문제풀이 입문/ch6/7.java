import java.util.*;

class Main {

    public static class Point implements Comparable<Point> {
        public int x;
        public int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point other) {
            if(this.x == other.x) {
                return this.y - other.y;
            } else {
                return this.x - other.x;
            }
        }

        @Override
        public String toString() {
            return this.x + " " + this.y;
        }
    }

    public String solution(int size, List<Point> list) {
        Collections.sort(list);

        String result = "";
        for(Point point : list) {
            result += (point + "\n");
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        List<Point> list = new ArrayList<>();
        for(int i = 0; i < size; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            list.add(new Point(x, y));
        }
        System.out.println(new Main().solution(size, list));
    }
}