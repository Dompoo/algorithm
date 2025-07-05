import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  // INF 값을 충분히 크게 설정
  private static final int INF = 100_000_001;

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int cityCount = Integer.parseInt(br.readLine());
    int busCount = Integer.parseInt(br.readLine());

    int[][] busPrice = new int[cityCount + 1][cityCount + 1];
    for (int i = 1; i <= cityCount; i++) {
      for (int j = 1; j <= cityCount; j++) {
        if (i == j) {
          busPrice[i][j] = 0;
        } else {
          busPrice[i][j] = INF;
        }
      }
    }

    for (int i = 0; i < busCount; i++) {
      String[] inputs = br.readLine().split(" ");
      int fromCity = Integer.parseInt(inputs[0]);
      int toCity = Integer.parseInt(inputs[1]);
      int price = Integer.parseInt(inputs[2]);

      // 더 저렴한 노선으로 갱신
      busPrice[fromCity][toCity] = Math.min(price, busPrice[fromCity][toCity]);
    }

    // 플로이드-워셜 알고리즘
    for (int k = 1; k <= cityCount; k++) {
      for (int i = 1; i <= cityCount; i++) {
        for (int j = 1; j <= cityCount; j++) {
          // [수정됨] 올바른 갱신 조건 확인
          if (busPrice[i][k] != INF && busPrice[k][j] != INF) {
             busPrice[i][j] = Math.min(busPrice[i][j], busPrice[i][k] + busPrice[k][j]);
          }
        }
      }
    }

    // 출력
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= cityCount; i++) {
      for (int j = 1; j <= cityCount; j++) {
        // [수정됨] 경로가 없으면 0 출력
        if (busPrice[i][j] == INF) {
          sb.append("0 ");
        } else {
          sb.append(busPrice[i][j]).append(" ");
        }
      }
      // 마지막 공백 제거 후 개행
      sb.setLength(sb.length() - 1);
      sb.append("\n");
    }
    System.out.print(sb);
  }
}