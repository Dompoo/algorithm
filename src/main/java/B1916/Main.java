package B1916;

import java.util.Scanner;

public class Main {
    static int cityNum;
    static boolean[] visited;
    static int[] distance;
    static int[][] busArr;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        cityNum = sc.nextInt();
        int busNum = sc.nextInt();
        busArr = new int[cityNum][cityNum];

        for (int i = 0; i < cityNum; i++) {
            for (int j = 0; j < cityNum; j++) {
                if (i != j) {
                    busArr[i][j] = Integer.MAX_VALUE;
                }
            }
        }

        for (int i = 0; i < busNum; i++) {
            int start = sc.nextInt() - 1;
            int end = sc.nextInt() - 1;
            int cost = sc.nextInt();
            busArr[start][end] = Math.min(busArr[start][end], cost);
        }

        int startCity = sc.nextInt() - 1;
        int endCity = sc.nextInt() - 1;

        distance = new int[cityNum];
        visited = new boolean[cityNum];

        dijkstra(startCity);
        System.out.println(distance[endCity]);
    }

    public static void dijkstra(int start) {
        for (int i = 0; i < cityNum; i++) {
            distance[i] = busArr[start][i];
        }

        visited[start] = true;

        for (int i = 0; i < cityNum - 1; i++) {
            int minIndex = getMinIndex();
            visited[minIndex] = true; //방문
            for (int j = 0; j < cityNum; j++) {
                if (!visited[j] && busArr[minIndex][j] != Integer.MAX_VALUE) {
                    distance[j] = Math.min(distance[minIndex] + busArr[minIndex][j], distance[j]);
                }
            }
        }
    }

    public static int getMinIndex() {
        int minValue = Integer.MAX_VALUE;
        int minIndex = 0;

        for (int i = 0; i < cityNum; i++) {
            if (distance[i] < minValue && !visited[i]) {
                minValue = distance[i];
                minIndex = i;
            }
        }

        return minIndex;
    }
}
