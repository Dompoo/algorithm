import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class Main {

  static class Node implements Comparable<Node> {
    int index;
    int cost;

    public Node(int index, int cost) {
      this.index = index;
      this.cost = cost;
    }

    @Override
    public int compareTo(Node o) {
      return Integer.compare(this.cost, o.cost);
    }
  }

  private static int N;
  private static int X;
  private static final int INF = 1000000;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    N = Integer.parseInt(inputs[0]);
    int M = Integer.parseInt(inputs[1]);
    X = Integer.parseInt(inputs[2]) - 1;

    ArrayList<Node>[] pathCost = new ArrayList[N];
    ArrayList<Node>[] reversePathCost = new ArrayList[N];
    for (int i = 0; i < N; i++) {
      pathCost[i] = new ArrayList<>();
      reversePathCost[i] = new ArrayList<>();
    }

    for (int i = 0; i < M; i++) {
      inputs = br.readLine().split(" ");
      int start = Integer.parseInt(inputs[0]) - 1;
      int end = Integer.parseInt(inputs[1]) - 1;
      int cost = Integer.parseInt(inputs[2]);
      pathCost[start].add(new Node(end, cost));
      reversePathCost[end].add(new Node(start, cost));
    }

    // X 마을을 기준으로 오고 가는 길의 최소를 구하면 된다.
    int[] distFrom = dij(pathCost);
    int[] distTo = dij(reversePathCost);

    int maxCost = 0;
    for (int i = 0; i < N; i++) {
      maxCost = Math.max(maxCost, distFrom[i] + distTo[i]);
    }
    System.out.print(maxCost);
  }

  private static int[] dij(ArrayList<Node>[] graph) {
    int[] dist = new int[N];
    Arrays.fill(dist, INF);
    dist[X] = 0;

    PriorityQueue<Node> pq = new PriorityQueue<>();
    pq.offer(new Node(X, 0));

    while (!pq.isEmpty()) {
      Node curNode = pq.poll();

      if (dist[curNode.index] < curNode.cost) {
        continue;
      }
      for (Node nextNode : graph[curNode.index]) {
        if (dist[nextNode.index] > curNode.cost + nextNode.cost) {
          dist[nextNode.index] = curNode.cost + nextNode.cost;
          pq.offer(new Node(nextNode.index, dist[nextNode.index]));
        }
      }
    }

    return dist;
  }
}
