import java.util.*;

class Main {

    private static int[][] arr = new int[][]{
        { 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, 
        { 1, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
        { 1, 2, 1, 0, 0, 0, 0, 0, 0, 0 }, 
        { 1, 3, 3, 1, 0, 0, 0, 0, 0, 0 }, 
        { 1, 4, 6, 4, 1, 0, 0, 0, 0, 0 }, 
        { 1, 5, 10, 10, 5, 1, 0, 0, 0, 0 }, 
        { 1, 6, 15, 20, 15, 6, 1, 0, 0, 0 }, 
        { 1, 7, 21, 35, 35, 21, 7, 1, 0, 0 }, 
        { 1, 8, 28, 56, 70, 56, 28, 8, 1, 0 }, 
        { 1, 9, 36, 84, 126, 126, 84, 36, 9, 1 }
    };

    private boolean isFound;
    private int[] result;
    private boolean[] used;
    private static int N;
    private static int target;

    private void dfs(int depth, int sum) {
        if (isFound) return;

        if (sum > target) return;

        if (depth == N) {
            if (sum == target) {
                isFound = true;
            }
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (!used[i]) {
                used[i] = true;
                int beforeResult = result[depth];
                result[depth] = i;
                dfs(depth + 1, sum + i * arr[N - 1][depth]);
                if (isFound) return;
                used[i] = false;
                result[depth] = beforeResult;
            }
        }
    }

    private String solution() {
        result = new int[N];
        used = new boolean[N + 1];
        
        dfs(0, 0);

        String resultString = "";
        for(int i : result) {
            resultString += (i + " ");
        }
        return resultString;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        target = sc.nextInt();
        System.out.println(new Main().solution());
    }
}