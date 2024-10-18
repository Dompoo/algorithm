import java.util.*;
import java.io.*;

/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6
 */
class Main {

    private static int N;
    private static int E;
    private static int INF = Integer.MAX_VALUE;
    private static ArrayList<ArrayList<Node>> graph;

    public static class Node implements Comparable<Node> {
        int to;
        int weight;

        public Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

	public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        E = sc.nextInt();

        int startNode = sc.nextInt();

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int weight = sc.nextInt();

            graph.get(from).add(new Node(to, weight));
        }

        int[] result = dijkstra(startNode);
        for (int i = 1; i <= N; i++) {
            if (result[i] == INF) System.out.println("INF");
            else System.out.println(result[i]);
        }
    }

    private static int[] dijkstra(int startNode) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);
        distance[startNode] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(startNode, 0));

        while(!pq.isEmpty()) {
            Node curr = pq.poll();

            if (distance[curr.to] < curr.weight) continue;

            for (Node next : graph.get(curr.to)) {
                int cost = distance[curr.to] + next.weight;
                if (cost < distance[next.to]) {
                    distance[next.to] = cost;
                    pq.add(new Node(next.to, cost));
                }
            }
        }

        return distance;
    }
}