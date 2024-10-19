import java.util.*;
import java.io.*;

class Main {

    public static Character[][] arr;
    public static int H;
    public static int W;
    public static int maxDistance = Integer.MIN_VALUE;
    public static int[] dx = new int[]{0, 0, 1, -1};
    public static int[] dy = new int[]{1, -1, 0, 0};

	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        H = Integer.parseInt(s[0]);
        W = Integer.parseInt(s[1]);
        arr = new Character[H][W];

        for (int i = 0; i < H; i++) {
            char[] input = br.readLine().toCharArray();
            for (int j = 0; j < W; j++) {
                arr[i][j] = input[j];
            }
        }

        boolean[] hasBeen = new boolean[26];
        hasBeen[arr[0][0] - 'A'] = true;
        dfs(hasBeen, 0, 0, 1);

        System.out.print(maxDistance);
    }

    public static void dfs(boolean[] hasBeen, int x, int y, int curDistance) {
        maxDistance = Math.max(curDistance, maxDistance);
        
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (isInRange(nx, ny) && !hasBeen[arr[nx][ny] - 'A']) {
                hasBeen[arr[nx][ny] - 'A'] = true;
                dfs(hasBeen, nx, ny, curDistance + 1);
                hasBeen[arr[nx][ny] - 'A'] = false;
            }
        }

    }

    private static boolean isInRange(int nx, int ny) {
        return 0 <= nx && nx < H && 0 <= ny && ny < W;
    }
}