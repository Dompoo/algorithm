import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {

  public static class Position {
    final int h;
    final int w;
    final boolean hasBrokenWall;
    final int attempt;

    public Position(int h, int w, boolean hasBrokenWall, int attempt) {
      this.h = h;
      this.w = w;
      this.hasBrokenWall = hasBrokenWall;
      this.attempt = attempt;
    }

    @Override
    public String toString() {
      return "{" +
          "h=" + h +
          ", w=" + w +
          ", broke=" + hasBrokenWall +
          ", attempt=" + attempt +
          "}";
    }
  }

  public static void main(String[] args) throws Exception {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    int H = Integer.parseInt(inputs[0]);
    int W = Integer.parseInt(inputs[1]);
    int[][] arr = new int[H][W];
    boolean[][][] visited = new boolean[H][W][2];
    visited[0][0][0] = true;

    for (int i = 0; i < H; i++) {
      char[] chars = br.readLine().toCharArray();
      for (int j = 0; j < W; j++) {
        arr[i][j] = chars[j] - '0';
      }
    }

    Queue<Position> queue = new ArrayDeque<>();
    queue.offer(new Position(0, 0, false, 1));
    int[] dh = {0, 0, -1, 1};
    int[] dw = {-1, 1, 0, 0};

    while (!queue.isEmpty()) {
      Position curPosition = queue.poll();
      if (curPosition.h == H - 1 && curPosition.w == W - 1) {
        System.out.print(curPosition.attempt);
        return;
      }
      for (int i = 0; i < 4; i++) {
        int nh = curPosition.h + dh[i];
        int nw = curPosition.w + dw[i];

        if (nh < 0 || nh >= H || nw < 0 || nw >= W) continue; // 위치를 벗어나면 패스

        if (arr[nh][nw] == 0) {
          if (!visited[nh][nw][curPosition.hasBrokenWall ? 1 : 0]) {
            visited[nh][nw][curPosition.hasBrokenWall ? 1 : 0] = true;
            queue.offer(new Position(nh, nw, curPosition.hasBrokenWall, curPosition.attempt + 1));
          }
        } else if (arr[nh][nw] == 1) {
          if (!curPosition.hasBrokenWall && !visited[nh][nw][1]) {
            visited[nh][nw][1] = true;
            queue.offer(new Position(nh, nw, true, curPosition.attempt + 1));
          }
        }
      }
    }

    System.out.print(-1);
  }
}
