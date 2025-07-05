import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class Main {

  /*
  2 0 0 0 1 1 0
  0 0 1 0 1 2 0
  0 1 1 0 1 0 0
  0 1 0 0 0 0 0
  0 0 0 0 0 1 1
  0 1 0 0 0 0 0
  0 1 0 0 0 0 0
   */

  public static class Point {
    private static int[] dh = {1, -1, 0, 0};
    private static int[] dw = {0, 0, 1, -1};

    final int h;
    final int w;

    public Point(int h, int w) {
      this.h = h;
      this.w = w;
    }

    public List<Point> getCrossPoints(int hMaxExclusive, int wMaxExclusive) {
      List<Point> result = new ArrayList<>();
      for (int i = 0; i < 4; i++) {
        int curH = h + dh[i];
        int curW = w + dw[i];
        if (curH >= 0 && curH < hMaxExclusive && curW >= 0 && curW < wMaxExclusive) {
          result.add(new Point(curH, curW));
        }
      }
      return result;
    }
  }

  public static int H;
  public static int W;

  public static void main(String[] args) throws Exception {
    int emptyPointCount = 0;
    List<Point> virusPoints = new ArrayList<>();

    // arr 세팅
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] NM = br.readLine().split(" ");
    H = Integer.parseInt(NM[0]);
    W = Integer.parseInt(NM[1]);
    final int[][] arr = new int[H][W];
    for (int i = 0; i < H; i++) {
      String[] input = br.readLine().split(" ");
      for (int j = 0; j < W; j++) {
        int curInput = Integer.parseInt(input[j]);
        arr[i][j] = curInput;
        if (curInput == 0) {
          emptyPointCount++;
        } else if (curInput == 2) {
          virusPoints.add(new Point(i, j));
        }
      }
    }

    int result = Integer.MIN_VALUE;
    // y = h * w
    for (int i = 0; i < H * W; i++) {
      if (arr[i / W][i % W] != 0) continue;
      for (int j = i + 1; j < H * W; j++) {
        if (arr[j / W][j % W] != 0) continue;
        for (int k = j + 1; k < H * W; k++) {
          if (arr[k / W][k % W] != 0) continue;

          // 2. 지도 깊은 복사
          int[][] tempMap = new int[H][W];
          for (int row = 0; row < H; row++) {
            System.arraycopy(arr[row], 0, tempMap[row], 0, W);
          }

          // 3. 벽 세우기 (올바른 좌표 변환 사용)
          tempMap[i / W][i % W] = 1;
          tempMap[j / W][j % W] = 1;
          tempMap[k / W][k % W] = 1;

          // 4. 복사된 지도에서 BFS 수행
          int safeArea = bfs(tempMap, virusPoints, emptyPointCount - 3);
          result = Math.max(result, safeArea);
        }
      }
    }

    System.out.print(result);
  }

  public static int bfs(int[][] map, List<Point> initialViruses, int initialSafeArea) {
    Queue<Point> queue = new ArrayDeque<>(initialViruses);
    int infectedCount = 0;

    while (!queue.isEmpty()) {
      Point curVirus = queue.poll();
      List<Point> nextPoints = curVirus.getCrossPoints(H, W);
      for (Point nextPoint : nextPoints) {
        if (map[nextPoint.h][nextPoint.w] == 0) {
          map[nextPoint.h][nextPoint.w] = 2;
          queue.add(nextPoint);
          infectedCount++;
        }
      }
    }
    return initialSafeArea - infectedCount;
  }
}
