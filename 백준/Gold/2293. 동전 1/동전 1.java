import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

//https://www.acmicpc.net/problem/2293
@SuppressWarnings("ALL")
public class Main {

    /*

```
1원 만으로 K원을 만들고 싶다.
=
(돈없이 K-2원 만드는 경우의 수 = 0)
+ (돈없이 K-4원 만드는 경우의 수 = 0)
+ ...
+ (돈없이 0원 만드는 경우의 수 = 1)
=
1
```

```
1, 2원 만으로 K원을 만들고 싶다.
=
(1원만으로 K-2원 만드는 경우의 수)
+ (1원만으로 K-4원 만드는 경우의 수)
+ (1원만으로 K-6원 만드는 경우의 수)
+ ...
```

```
1, 2, 5원으로 K원을 만들고 싶다.
=
(1,2원만으로 K-5원 만드는 경우의 수)
+ (1,2원만으로 K-10원 만드는 경우의 수)
+ (1,2원만으로 K-15원 만드는 경우의 수)
+ ...
```
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        Set<Integer> moneys = new HashSet<>();
        for (int i = 0; i < N; i++) {
            int money = Integer.parseInt(br.readLine());
            moneys.add(money);
        }

        List<Integer> list = new ArrayList<>(moneys);
        // dp[i][j] = i-1 인덱스 돈까지 고려했을 때 j원을 만드는 경우의 수
        // 1,2,5원에서 dp[1][5] = 1원만 사용해서 5원 만드는 경우의 수

        int[][] dp = new int[list.size() + 1][K + 1];
        for (int i = 0; i < list.size() + 1; i++) {
            dp[i][0] = 1; // 0원은 무조건 만들 수 있다.
        }
        for (int i = 1; i < list.size() + 1; i++) {
            for (int j = 1; j < K + 1; j++) {
                int current = list.get(i - 1);
                int sum = 0;
                for (int x = j; x >= 0; x -= current) {
                    sum += dp[i - 1][x];
                }
                dp[i][j] = sum;
            }
        }

        System.out.println(dp[list.size()][K]);
    }

    private static void printArr(List<Integer> list, int K, int[][] dp) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size() + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                sb.append(dp[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
