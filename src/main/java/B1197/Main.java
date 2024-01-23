package B1197;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
import java.util.Stack;

public class Main {
    static int[] parent;
    static int[] rank;
    static Node[] edge;
    static Stack<Node> stack = new Stack<>();
    static int E;

    public static class Node {
        public int from;
        public int to;
        public int num;

        public Node(int from, int to, int num) {
            this.from = from;
            this.to = to;
            this.num = num;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = sc.nextInt();
        E = sc.nextInt();
        edge = new Node[E];
        parent = new int[V];
        rank = new int[V];

        //parent 초기화
        for (int i = 0; i < V; i++) {
            parent[i] = i;
        }

        for (int i = 0; i < E; i++) {
            int v1 = sc.nextInt() - 1;
            int v2 = sc.nextInt() - 1;
            int num = sc.nextInt();
            //from이 항상 더 작다.
            edge[i] = new Node(Math.min(v1, v2), Math.max(v1, v2), num);
        }

        //num 오름차순으로 정렬해준다.
        Node[] nodeArr = Arrays.stream(edge)
                .sorted(Comparator.comparingInt(node -> node.num))
                .toArray(Node[]::new);

        kuruskal(nodeArr);

        //스택(최소스패닝트리)의 모든 내용을 팝하며 num을 더한다.
        int ans = 0;
        while (!stack.empty()) {
            ans += stack.pop().num;
        }
        System.out.println(ans);
    }

    public static void kuruskal(Node[] nodeArr) {
        for (int i = 0; i < E; i++) {
            Node node = nodeArr[i];
            if (find(node.from) == find(node.to)) {
                continue;
            } else {
                stack.push(node);
                union(node.from, node.to);
            }
        }
    }

    public static void union(int ver1, int ver2) {
        int root1 = find(ver1);
        int root2 = find(ver2);

        if (root1 != root2) {
            if (rank[root1] < rank[root2]) {
                parent[root1] = root2;
            } else if (rank[root1] > rank[root2]) {
                parent[root2] = root1;
            } else {
                parent[root2] = root1;
                rank[root1]++;
            }
        }
    }

    public static int find(int verNum) {
        if (parent[verNum] == verNum) {
            return verNum;
        } else {
            return parent[verNum] = find(parent[verNum]);
        }
    }
}
