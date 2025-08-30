import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[] input = br.readLine().toCharArray();
        // 앞에서부터 쭉 가면서
        // X가 등장한 경우 거기서부터 연속된 X의 개수를 센다.
        // 홀수개 -> -1 출력
        // 짝수개 -> AAAA로 최대한 채우고, BB로 채우기

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < input.length; i++) {
            if (input[i] == '.') {
                sb.append(".");
            } else if (input[i] == 'X') {
                int length = 0;
                for (int j = i; j < input.length && input[j] == 'X'; j++) length++;
                i += length - 1;
                if (length % 2 != 0) {
                    sb = new StringBuilder();
                    sb.append("-1");
                    break;
                } else {
                    sb.append("AAAA".repeat(length / 4));
                    sb.append("BB".repeat((length % 4) / 2));
                }
            } else {
                throw new UnsupportedOperationException();
            }
        }

        System.out.println(sb);
    }
}
