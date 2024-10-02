/*
5 20
10 5
25 12
15 8
6 3
7 4
*/

import java.util.*;

class Main {

    public int dfs(int index, int curTime, int curPoint, int size, int maxTime, int[] point, int[] time) {
        if(curTime > maxTime) {
            return 0;
        }

        if(index == size) {
            return curPoint;
        }

        int solve = dfs(index + 1, curTime + time[index], curPoint + point[index], size, maxTime, point, time); // 풀었을 때
        int notSolve = dfs(index + 1, curTime, curPoint, size, maxTime, point, time); // 안 풀었을 때

        return Math.max(solve, notSolve);
    }

    public int solution(int size, int maxTime, int[] point, int[] time) {
        return dfs(0, 0, 0, size, maxTime, point, time);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int maxTime = sc.nextInt();
        int[] point = new int[size];
        int[] time = new int[size];
        for(int i = 0; i < size; i++) {
            point[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        System.out.println(new Main().solution(size, maxTime, point, time));
    }
}