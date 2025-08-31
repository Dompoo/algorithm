import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
M+K 형태에 대하여
한번에 읽으면 (MMK -> 500) 숫자가 가장 크고
M은 한번에, K를 따로 읽으면 (MMK -> 10 5) 숫자가 가장 작다.
 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        String minAnswer = "";
        String maxAnswer = "";

        int mCount = 0;
        for (char ch : input.toCharArray()) {
            if (ch == 'M') {
                mCount++;
            } else if (ch == 'K') {
                // MMK 형태
                // 500이 최대
                // 105가 최소
                if (mCount == 0) {
                    maxAnswer += "5";
                    minAnswer += "5";
                } else {
                    maxAnswer += "5" + "0".repeat(mCount);
                    minAnswer += "1" + "0".repeat(mCount - 1) + "5";
                }
                mCount = 0;
            } else {
                throw new UnsupportedOperationException();
            }
        }

        // 마지막이 M으로 끝난 경우
        // MMM 형태
        // 111이 최대
        // 100이 최소
        if (mCount > 0) {
            maxAnswer += "1".repeat(mCount);
            minAnswer += "1" + "0".repeat(mCount - 1);
        }
        System.out.println(maxAnswer);
        System.out.println(minAnswer);
    }
}
