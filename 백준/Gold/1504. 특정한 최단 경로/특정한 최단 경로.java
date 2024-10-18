import java.util.*;
import java.io.*;

public class Main {
    static final int MAX = Integer.MAX_VALUE;
    static ArrayList<ArrayList<Node>> graph;
    static int N, E;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, c));
            graph.get(b).add(new Node(a, c));
        }

        st = new StringTokenizer(br.readLine());
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());

        int[] startDist = dijkstra(1);
        int[] v1Dist = dijkstra(v1);
        int[] v2Dist = dijkstra(v2);

        long path1 = (long)startDist[v1] + v1Dist[v2] + v2Dist[N];
        long path2 = (long)startDist[v2] + v2Dist[v1] + v1Dist[N];

        long result = Math.min(path1, path2);

        System.out.print(result >= MAX ? -1 : result);
    }

    static int[] dijkstra(int start) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, MAX);
        distance[start] = 0;

        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();

            if (distance[current.to] < current.weight) continue;

            for (Node next : graph.get(current.to)) {
                int cost = distance[current.to] + next.weight;
                if (cost < distance[next.to]) {
                    distance[next.to] = cost;
                    pq.offer(new Node(next.to, cost));
                }
            }
        }

        return distance;
    }

    static class Node implements Comparable<Node> {
        int to, weight;

        Node(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }
}