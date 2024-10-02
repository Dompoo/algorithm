import java.util.*;

class Main {

    public static int N = 7;
    public static int[][] arr = new int[N][N];

    public boolean[][] isChecked = new boolean[N][N];
    public int result = 0;
    public int[] dx = new int[] {0, 0, 1, -1};
    public int[] dy = new int[] {1, -1, 0, 0};

    public void dfs(int x, int y) {

        // 도착했다면
        if(x == N - 1 && y == N - 1) {
            // for(int i = 0; i < N; i++) {
            //     for(int j = 0; j < N; j++) {
            //         System.out.print((isChecked[i][j] ? "0" : "-") + " ");
            //     }
            //     System.out.println();
            // }
            // System.out.println();
            result++;
            return;
        } else {
            // 도착하지 못했다면
            for(int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if(0 <= nx && nx < N && 0 <= ny && ny < N && !isChecked[nx][ny] && arr[nx][ny] == 0) {
                    isChecked[nx][ny] = true;
                    dfs(nx, ny);
                    isChecked[nx][ny] = false;
                }
            }
            return;
        }
    }

    public int solution() {
        isChecked[0][0] = true;
        dfs(0, 0);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < N; i++) {
            String input = sc.nextLine();
            String[] inputs = input.split(" ");
            for(int j = 0; j < N; j++) {
                arr[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        System.out.println(new Main().solution());
    }
}