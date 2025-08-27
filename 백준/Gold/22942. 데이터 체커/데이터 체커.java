import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

/*
4
5 4
3 1
6 1
13 3

1-9
2-4
5-7
10-16


stack
1  2  2  3  3  1  4  4
1  2  4  5  7  9  10 16
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = Integer.parseInt(br.readLine());
        String[] inputs;
        List<CircleData> datas = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            inputs = br.readLine().split(" ");
            int x = Integer.parseInt(inputs[0]);
            int r = Integer.parseInt(inputs[1]);
            int startPos = x - r;
            int endPos = x + r;
            datas.add(new CircleData(i, startPos, true));
            datas.add(new CircleData(i, endPos, false));
        }

        // position 순으로 정렬
        Collections.sort(datas, (o1, o2) -> o1.position - o2.position);

        // 스택 형태가 맞는지 체크
        String answer = "YES";
        Deque<CircleData> deque = new ArrayDeque<>();
        for (CircleData data : datas) {
            if (data.isStart) {
                deque.offerFirst(data);
            } else {
                CircleData last = deque.pollFirst();
                if (last == null) {
                    answer = "NO";
                    break;
                }

                if (!last.isStart || last.num != data.num) {
                    answer = "NO";
                    break;
                }
            }
        }
        System.out.println(answer);
    }

    public static class CircleData {
        int num;
        int position;
        boolean isStart;

        public CircleData(int num, int position, boolean isStart) {
            this.num = num;
            this.position = position;
            this.isStart = isStart;
        }
    }
}
