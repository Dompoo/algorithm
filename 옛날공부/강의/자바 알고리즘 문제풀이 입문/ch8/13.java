import java.util.*;

class Main {

    public static int size;
    public static int[][] arr;
    public int[] dx = new int[] {0, 0, 1, -1, 1, 1, -1, -1};
    public int[] dy = new int[] {1, -1, 0, 0, 1, -1, 1, -1};


    public void dfs(int x, int y) {
        arr[x][y] = 0;
        for(int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if(0 <= nx && nx < size && 0 <= ny && ny < size && arr[nx][ny] == 1) {
                dfs(nx, ny);
            }
        }
    }

    public int solution() {
        int result = 0;

        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                // 새로운 섬 발견
                if(arr[i][j] == 1) {
                    result++;
                    // dfs로 다 칠해버리기
                    dfs(i, j);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        arr = new int[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        System.out.println(new Main().solution());
    }
}