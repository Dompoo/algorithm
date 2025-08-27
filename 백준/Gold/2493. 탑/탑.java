import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/*
5
6 9 5 7 4

result 0 0 2

stack 9 7
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        int[] arr = new int[count];
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < count; i++) {
            arr[i] = Integer.parseInt(inputs[i]);
        }

        Deque<Tower> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            Tower cur = new Tower(arr[i], i);
            while (true) {
                Tower last = deque.pollFirst();
                if (last == null) {
                    sb.append("0").append(" ");
                    break;
                } else if (last.height > cur.height) {
                    // 레이저가 닿음!
                    sb.append(last.index).append(" ");
                    deque.offerFirst(last);
                    break;
                } else {
                    // 레이저가 안닿음, 의미 없으므로 poll만 진행
                }
            }
            deque.offerFirst(cur);
        }
        System.out.println(sb);
    }

    public static class Tower {
        int height;
        int index;

        public Tower(int height, int index) {
            this.height = height;
            this.index = index + 1;
        }
    }
}
