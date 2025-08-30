import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int target = Integer.parseInt(br.readLine());

        if (target == 1 || target == 3) {
            System.out.println(-1);
            return;
        }

        int answer = 0;

        // 5원을 가능할 때까지 뺀다.
        while (target - 5 >= 0) {
            target -= 5;
            answer++;
        }

        // 2원으로 지불할 수 있을 때까지 다시 5원을 더한다.
        while (target % 2 != 0) {
            target += 5;
            answer--;
        }

        // 2원으로 지불한다.
        answer += (target / 2);

        System.out.println(answer);
    }
}
