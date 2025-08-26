import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
6
1 1 1 1 1 1 1 1
0 0 0 0 0

5
1 1 1 1 1
0 0 0

4
1 1 1
0 0

3
1 1
0

2
1
0
 */
public class Main {

    private static class FiboCount {
        int zeroCount;
        int oneCount;

        public FiboCount(int zeroCount, int oneCount) {
            this.zeroCount = zeroCount;
            this.oneCount = oneCount;
        }

        @Override
        public String toString() {
            return zeroCount + " " + oneCount;
        }

        public FiboCount add(FiboCount other) {
            return new FiboCount(this.zeroCount + other.zeroCount, this.oneCount + other.oneCount);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int T = Integer.parseInt(br.readLine());
        int[] testcases = new int[T];

        int maxCase = 5;

        for (int i = 0; i < T; i++) {
            int curCase = Integer.parseInt(br.readLine());
            testcases[i] = curCase;
            if (curCase > maxCase) maxCase = curCase;
        }

        FiboCount[] count = new FiboCount[maxCase + 1];

        // FiboCount를 maxCase까지 채우기
        count[0] = new FiboCount(1, 0);
        count[1] = new FiboCount(0, 1);
        for (int i = 2; i <= maxCase; i++) {
            count[i] = count[i - 1].add(count[i - 2]);
        }

        StringBuilder sb = new StringBuilder();
        for (int testcase : testcases) {
            sb.append(count[testcase]).append("\n");
        }
        System.out.print(sb);
    }
}
