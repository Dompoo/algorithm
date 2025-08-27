import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

/*
345
543

 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ArrayDeque<Integer> target = new ArrayDeque<>();
        ArrayDeque<Integer> numbers = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            target.addLast(Integer.parseInt(br.readLine()));
            numbers.addLast(i + 1);
        }

        ArrayDeque<Integer> stack = new ArrayDeque<>();

        StringBuilder sb = new StringBuilder();
        while (true) {
            if (numbers.isEmpty()) {
                // number 소진, stack과 target이 동일해야함
                if (stack.toString().equals(target.toString())) {
                    for (int i = 0; i < stack.size(); i++) {
                        sb.append("-").append("\n");
                    }
                    System.out.println(sb);
                } else {
                    System.out.println("NO");
                }
                break;
            } else if (numbers.peekFirst() <= target.peekFirst()) {
                // push
                sb.append("+").append("\n");
                stack.addFirst(numbers.removeFirst());
            } else if (stack.peekFirst().equals(target.peekFirst())) {
                // pop
                sb.append("-").append("\n");
                stack.removeFirst();
                target.removeFirst();
            } else {
                System.out.println("NO");
                break;
            }
        }
    }
}
