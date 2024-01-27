package B1260;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    static int nodeNum;
    static boolean[][] edgeExist;
    static boolean[] visited;
    static int startNode;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        nodeNum = sc.nextInt();
        int edgeNum = sc.nextInt();
        startNode = sc.nextInt();
        edgeExist = new boolean[nodeNum + 1][nodeNum + 1];
        visited = new boolean[nodeNum + 1];

        for (int i = 0; i < edgeNum; i++) {
            int node1 = sc.nextInt();
            int node2 = sc.nextInt();
            edgeExist[node1][node2] = true;
            edgeExist[node2][node1] = true;
        }

        DFS(startNode);
        System.out.println();

        for (int i = 0; i < nodeNum + 1; i++) {
            visited[i] = false;
        }

        BFS(startNode);
        System.out.println();
    }

    public static void DFS(int node) {
        visited[node] = true;
        printNode(node);

        for (int i = 0; i < nodeNum + 1; i++) {
            if (edgeExist[node][i] && !visited[i]) {
                DFS(i);
            }
        }
    }

    public static void BFS(int startNode) {
        Deque<Integer> queue = new ArrayDeque<>();

        visited[startNode] = true;
        queue.offer(startNode);
        printNode(startNode);

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();

            for (int i = 0; i < nodeNum + 1; i++) {
                if (edgeExist[poll][i] && !visited[i]) {
                    printNode(i);
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }

    public static void printNode(int node) {
        if (node == startNode) {
            System.out.print(node);
        } else {
            System.out.print(" " + node);
        }
    }
}
