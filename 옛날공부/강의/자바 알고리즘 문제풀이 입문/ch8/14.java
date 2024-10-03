import java.util.*;

class Main {

    public static int size;
    public static int targetPizza;
    public static int startPizza;
    public static int[][] arr;
    public int minPizzaLength = Integer.MAX_VALUE;
    public static List<Point> pizzas = new ArrayList<>();

    public static class Point {
        int x;
        int y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public int calculatePizzaLength() {
        int result = 0;
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(arr[i][j] == 1) {
                    int minPizzaLength = Integer.MAX_VALUE;
                    for(Point pizza : pizzas) {
                        minPizzaLength = Math.min(minPizzaLength, Math.abs(i - pizza.x) + Math.abs(j - pizza.y));
                    }
                    result += minPizzaLength;
                }
            }
        }
        return result;
    }

    public void dfs(int currentPizza) {
        if(currentPizza == targetPizza) {
            //현재 거리 계산, 업데이트
            minPizzaLength = Math.min(minPizzaLength, calculatePizzaLength());
        } else {
            //제거할 다음 피자집 탐색
            for(int i = 0; i < pizzas.size(); i++) {
                Point pizza = pizzas.get(i);
                pizzas.remove(i);
                arr[pizza.x][pizza.y] = 0;
                dfs(currentPizza - 1);
                pizzas.add(i, pizza);
                arr[pizza.x][pizza.y] = 2;
            }
        }
    }

    public int solution() {
        dfs(startPizza);
        return minPizzaLength;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        arr = new int[size][size];
        targetPizza = sc.nextInt();
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                int input = sc.nextInt();
                if(input == 2) {
                    startPizza++;
                    pizzas.add(new Point(i, j));
                }
                arr[i][j] = input;
            }
        }
        System.out.println(new Main().solution());
    }
}