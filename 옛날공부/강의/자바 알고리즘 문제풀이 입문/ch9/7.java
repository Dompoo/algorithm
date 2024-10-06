import java.util.*;

class Main {

    public static class V implements Comparable<V> {
        int city1;
        int city2;
        int cost;
        V(int city1, int city2, int cost) {
            this.city1 = city1;
            this.city2 = city2;
            this.cost = cost;
        }
        @Override
        public int compareTo(V other) {
            return this.cost - other.cost;
        }
    }

    public static int city;
    public static int vertex;
    public static PriorityQueue<V> queue = new PriorityQueue<>();   
    public static int[] parent;

    public int find(int x) {
        if(parent[x] == x) return x;
        else return parent[x] = find(parent[x]);
    }

    public void union(int x, int y) {
        int X = find(x);
        int Y = find(y);
        if(X != Y) {
            parent[X] = Y;
        }
    }

    public int solution() {
        parent = new int[city + 1];

        for(int i = 0; i <= city; i++) {
            parent[i] = i;
        }

        int selectedVertex = 0;
        int result = 0;

        while(selectedVertex < city - 1) {
            V v = queue.poll();

            if(find(v.city1) != find(v.city2)) {
                union(v.city1, v.city2);
                result += v.cost;
                selectedVertex++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        city = sc.nextInt();
        vertex = sc.nextInt();
        for(int i = 0; i < vertex; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int cost = sc.nextInt();
            queue.offer(new V(a, b, cost));
        }
        System.out.println(new Main().solution());
    }
}