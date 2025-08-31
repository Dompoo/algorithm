import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

/*
-뒤에가 커질수록 이득
 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int minusIndex = input.indexOf('-');

        if (minusIndex == -1) {
            // -가 등장하지 않는 경우
            String[] strings = input.split("\\+");
            Integer result = Arrays.stream(strings)
                    .map(Integer::parseInt)
                    .reduce(0, Integer::sum);
            System.out.println(result);
        } else {
            // -가 등장하는 경우
            // - 앞과 뒤의 숫자들을 각각 모두 더하고,
            // 앞 - 뒤 를 하면 된다.
            String front = input.substring(0, minusIndex);
            String back = input.substring(minusIndex + 1);
            String[] frontNumbers = front.split("\\+|\\-");
            String[] backNumbers = back.split("\\+|\\-");

            Integer frontSum = Arrays.stream(frontNumbers)
                    .map(Integer::parseInt)
                    .reduce(0, Integer::sum);

            Integer backSum = Arrays.stream(backNumbers)
                    .map(Integer::parseInt)
                    .reduce(0, Integer::sum);
            System.out.println(frontSum - backSum);
        }
    }
}
