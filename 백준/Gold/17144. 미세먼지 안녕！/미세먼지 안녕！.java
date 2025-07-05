import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

public class Main {

  private static final int[] dW = {0, 0, -1, 1};
  private static final int[] dH = {-1, 1, 0, 0};
  private static int H;
  private static int W;
  private static int T;
  private static int S1 = -1;
  private static int S2 = -1;


  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    H = Integer.parseInt(inputs[0]);
    W = Integer.parseInt(inputs[1]);
    T = Integer.parseInt(inputs[2]);
    int[][] arr = new int[H][W];

    for (int i = 0; i < H; i++) {
      inputs = br.readLine().split(" ");
      for (int j = 0; j < W; j++) {
        int curInput = Integer.parseInt(inputs[j]);
        arr[i][j] = curInput;
        if (curInput == -1) {
          if (S1 == -1) S1 = i;
          else if (S2 == -1) S2 = i;
          else throw new IllegalArgumentException("왜 2번 초기화됐지?");
        }
      }
    }

    for (int dompoo = 0; dompoo < T; dompoo++) {
      // 먼지 확산
      Queue<Point> queue = new ArrayDeque<>();
      for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
          if (arr[i][j] > 0) {
            queue.add(new Point(i, j));
          }
        }
      }
      int[][] addUps = new int[H][W];
      while (!queue.isEmpty()) {
        Point cur = queue.poll();
        int amountToSpread = arr[cur.x][cur.y] / 5;

        for (int i = 0; i < 4; i++) {
          int nextH = cur.x + dH[i];
          int nextW = cur.y + dW[i];
          if (nextH >= 0 && nextH < H && nextW >= 0 && nextW < W && arr[nextH][nextW] != -1) {
            addUps[nextH][nextW] += amountToSpread;
            addUps[cur.x][cur.y] -= amountToSpread;
          }
        }
      }
      for (int i = 0; i < H; i++) {
        for (int j = 0; j < W; j++) {
          arr[i][j] += addUps[i][j];
        }
      }

      // 청정기 작동
      // 1. 아래로 당기기 (왼쪽 세로줄)
      for (int i = S1 - 1; i > 0; i--) {
        arr[i][0] = arr[i - 1][0];
      }
      // 2. 왼쪽으로 당기기 (맨 윗줄)
      for (int i = 0; i < W - 1; i++) {
        arr[0][i] = arr[0][i + 1];
      }
      // 3. 위로 당기기 (오른쪽 세로줄)
      for (int i = 0; i < S1; i++) {
        arr[i][W - 1] = arr[i + 1][W - 1];
      }
      // 4. 오른쪽으로 당기기 (공기청정기 윗줄)
      for (int i = W - 1; i > 1; i--) {
        arr[S1][i] = arr[S1][i - 1];
      }
      // 5. 공기청정기에서 깨끗한 공기 나옴
      arr[S1][1] = 0;

      // 1. 위로 당기기 (왼쪽 세로줄, 공기청정기 아래부터)
      for (int i = S2 + 1; i < H - 1; i++) {
        arr[i][0] = arr[i + 1][0];
      }

      // 2. 왼쪽으로 당기기 (맨 아랫줄)
      for (int i = 0; i < W - 1; i++) {
        arr[H - 1][i] = arr[H - 1][i + 1];
      }

      // 3. 아래로 당기기 (오른쪽 세로줄)
      for (int i = H - 1; i > S2; i--) {
        arr[i][W - 1] = arr[i - 1][W - 1];
      }

      // 4. 오른쪽으로 당기기 (공기청정기 아랫줄)
      for (int i = W - 1; i > 1; i--) {
        arr[S2][i] = arr[S2][i - 1];
      }

      // 5. 공기청정기에서 깨끗한 공기가 나옴
      arr[S2][1] = 0;

    }
    
    int result = 0;
    for (int i = 0; i < H; i++) {
      for (int j = 0; j < W; j++) {
        if (arr[i][j] > 0) result += arr[i][j];
      }
    }
    System.out.print(result);
  }
}
