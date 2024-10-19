import java.util.*;
import java.io.*;

/*
12
1 2 3
1 3 2
2 4 5
3 5 11
3 6 9
4 7 1
4 8 7
5 9 15
5 10 4
6 11 6
6 12 10
 */
class Main {

    private static class Edge {
        public int to;
        public int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    private static int N;
    private static List<List<Edge>> graph;
    private static int maxLen = Integer.MIN_VALUE;

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < N - 1; i++) {
            String[] s = br.readLine().split(" ");
            int parent = Integer.parseInt(s[0]);
            int child = Integer.parseInt(s[1]);
            int weight = Integer.parseInt(s[2]);
            graph.get(parent).add(new Edge(child, weight));
            graph.get(child).add(new Edge(parent, weight));
        }

        findMaxLen(1);

        System.out.print(maxLen);
    }

    private static void findMaxLen(int currentNode) {
        // currentNode로부터 가장 멀리 있는 노드를 찾는다.
        dfs(currentNode, -1, 0);

        // 해당 노드와의 거리가 maxLen보다 크다면 다시 findMaxLen한다.
        // 작거나 같다면 재귀를 종료한다.
        if (currentNodeMaxLen > maxLen) {
            maxLen = currentNodeMaxLen;
            currentNodeMaxLen = 0;
            findMaxLen(currentNodeMaxLenNode);
        }
    }

    private static int currentNodeMaxLen = Integer.MIN_VALUE;
    private static int currentNodeMaxLenNode = 0;

    private static void dfs(int currentNode, int prevNode, int currentLen) {
//        System.out.println("currentNode : " + currentNode + " prevNode : " + prevNode + " currentLen : " + currentLen);
        if (currentNodeMaxLen < currentLen) {
            currentNodeMaxLen = currentLen;
            currentNodeMaxLenNode = currentNode;
        }

        for (Edge e : graph.get(currentNode)) {
            if (e.to != prevNode) {
                dfs(e.to, currentNode, currentLen + e.weight);
            }
        }
    }
}