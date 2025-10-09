import java.util.*;

class Solution {
    static int N;
    public int solution(int n, int[][] wires) {
        N = n;
        int result = n;
        
        boolean[][] tree = new boolean[n][n];
        for (int i = 0; i < wires.length; i++) {
            int n1 = wires[i][0] - 1;
            int n2 = wires[i][1] - 1;
            tree[n1][n2] = true;
            tree[n2][n1] = true;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                if (!tree[i][j]) continue;
                tree[i][j] = false;
                tree[j][i] = false;
                int len1 = lengthOf(tree, i);
                int len2 = lengthOf(tree, j);
                result = Math.min(Math.abs(len1 - len2), result);
                tree[i][j] = true;
                tree[j][i] = true;
            }
        }
        return result;
    }
    
    public int lengthOf(boolean[][] tree, int start) {
        boolean[] visited = new boolean[N];
        
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;
        int size = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            size++;
            for (int i = 0; i < N; i++) {
                if (visited[i]) continue;
                if (!tree[cur][i]) continue;
                queue.offer(i);
                visited[i] = true;
            }
        }
        return size;
    }
}