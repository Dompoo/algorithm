import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        String[] orders = new String[count];
        for (int i = 0; i < count; i++) {
            orders[i] = br.readLine();
        }

        ArrayDeque<Integer> deque = new ArrayDeque<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            String order = orders[i];
            if (order.startsWith("push_back")) {
                int number = Integer.parseInt(order.split(" ")[1]);
                deque.offerLast(number);
            } else if (order.startsWith("push_front")) {
                int number = Integer.parseInt(order.split(" ")[1]);
                deque.offerFirst(number);
            } else if (order.equals("pop_front")) {
                Integer number = deque.pollFirst();
                sb.append(number == null ? -1 : number).append("\n");
            } else if (order.equals("pop_back")) {
                Integer number = deque.pollLast();
                sb.append(number == null ? -1 : number).append("\n");
            } else if (order.equals("size")) {
                int size = deque.size();
                sb.append(size).append("\n");
            } else if (order.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            } else if (order.equals("front")) {
                Integer number = deque.peekFirst();
                sb.append(number == null ? -1 : number).append("\n");
            } else if (order.equals("back")) {
                Integer number = deque.peekLast();
                sb.append(number == null ? -1 : number).append("\n");
            } else {
                throw new IllegalStateException();
            }
        }
        System.out.print(sb);

    }
}
