package B2252;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer s = new StringTokenizer(in.readLine()," ");

        int n = Integer.parseInt(s.nextToken());
        int m = Integer.parseInt(s.nextToken());

        int[] count = new int[n];
        ArrayList<ArrayList<Integer>> edge = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            edge.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            s = new StringTokenizer(in.readLine(), " ");
            int st1 = Integer.parseInt(s.nextToken()) - 1;
            int st2 = Integer.parseInt(s.nextToken()) - 1;
            edge.get(st1).add(st2);
            count[st2]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();
        //초기 노드 삽입
        for (int i = 0; i < n; i++) {
            if (count[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int idx = queue.poll();
            System.out.print(idx + 1 + " ");

            for (int i = 0; i < edge.get(idx).size(); i++) {
                int ne = edge.get(idx).get(i);
                count[ne]--;
                if (count[ne] == 0) {
                    queue.offer(ne);
                }
            }
        }

    }
}
