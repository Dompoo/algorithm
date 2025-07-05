import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

  private static final int INF_COST = 1000;
  private static int areaCount;
  private static int searchPower;
  private static int[] itemValue;
  private static int[][] cost;

  public static void main(String[] args) throws Exception {
    getInputs();
//    System.out.println(areaCount);
//    System.out.println(searchPower);
//    System.out.println(Arrays.toString(itemValue));
//    System.out.println(Arrays.deepToString(cost));

    // ROAD_COST를 최적화한다.
    for (int k = 0; k < areaCount; k++) {
      for (int i = 0; i < areaCount; i++) {
        for (int j = i + 1; j < areaCount; j++) {
          if (cost[i][k] == INF_COST || cost[k][j] == INF_COST) continue;
          if (cost[i][k] + cost[k][j] < cost[i][j]) {
            cost[i][j] = cost[i][k] + cost[k][j];
            cost[j][i] = cost[i][j];
          }
        }
      }
    }

    int result = Integer.MIN_VALUE;
    for (int curCity = 0; curCity < areaCount; curCity++) {
      int curResult = 0;
      for (int nextCity = 0; nextCity < areaCount; nextCity++) {
        if (cost[curCity][nextCity] <= searchPower) {
          curResult += itemValue[nextCity];
        }
      }
      result = Math.max(result, curResult);
    }

    System.out.print(result);
  }

  private static void getInputs() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputs = br.readLine().split(" ");
    areaCount = Integer.parseInt(inputs[0]);
    searchPower = Integer.parseInt(inputs[1]);
    int roadCount = Integer.parseInt(inputs[2]);
    inputs = br.readLine().split(" ");
    itemValue = new int[areaCount];
    for (int i = 0; i < areaCount; i++) {
      itemValue[i] = Integer.parseInt(inputs[i]);
    }
    cost = new int[areaCount][areaCount];
    for (int i = 0; i < areaCount; i++) {
      for (int j = 0; j < areaCount; j++) {
        if (i == j) {
          cost[i][j] = 0;
        } else {
          cost[i][j] = INF_COST;
        }
      }
    }
    for (int i = 0; i < roadCount; i++) {
      inputs = br.readLine().split(" ");
      int area1 = Integer.parseInt(inputs[0]) - 1;
      int area2 = Integer.parseInt(inputs[1]) - 1;
      int cost = Integer.parseInt(inputs[2]);
      Main.cost[area1][area2] = cost;
      Main.cost[area2][area1] = cost;
    }
  }
}
