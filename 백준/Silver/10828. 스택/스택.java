import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Integer> deque = new ArrayDeque<>();

        int count = Integer.parseInt(br.readLine());

        String[] commands = new String[count];
        for (int i = 0; i < count; i++) {
            commands[i] = br.readLine();
        }

        StringBuilder sb = new StringBuilder();


        for (int i = 0; i < count; i++) {
            String command = commands[i];
            if (command.startsWith("push")) {
                int number = Integer.parseInt(command.split(" ")[1]);
                deque.addFirst(number);
            } else if (command.equals("pop")) {
                Integer result = deque.pollFirst();
                sb.append(result == null ? -1 : result).append("\n");
            } else if (command.equals("size")) {
                sb.append(deque.size()).append("\n");
            } else if (command.equals("empty")) {
                sb.append(deque.isEmpty() ? 1 : 0).append("\n");
            } else if (command.equals("top")) {
                Integer result = deque.peekFirst();
                sb.append(result == null ? -1 : result).append("\n");
            } else {
                throw new IllegalStateException();
            }
        }

        System.out.print(sb);
    }
}
