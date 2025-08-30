import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
4 2

2 3

2 -1 -> 2원

0 1 -> 1원

공식
... + (a - 4) + (b - 3) + (c - 2) + (d - 1) + (e - 0)

-는 어차피 무마됨(음수는 팁을 못받는겨)
그러면 -4에는 최대한 작은게 들어가야 이득!
팁 잘주는 사람부터 보내주자.
 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            list.add(Integer.parseInt(br.readLine()));
        }

        list.sort(Collections.reverseOrder());

        long answer = 0;
        for (int i = 0; i < list.size(); i++) {
            int tip = list.get(i);
            long pay = (long) tip - i;
            if (pay > 0) answer += pay;
            else break;
        }
        System.out.println(answer);
    }
}
