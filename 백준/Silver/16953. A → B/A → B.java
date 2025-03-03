import java.io.*;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {

    static class Number {
        public final long value;
        public final long attempt;

        public Number(final long value, final long attempt) {
            this.value = value;
            this.attempt = attempt;
        }

        public Number withDouble() {
            return new Number(value * 2, attempt + 1);
        }

        public Number withAddOneLeft() {
            return new Number(value * 10 + 1, attempt + 1);
        }
    }

    public static void main(String[] args) throws IOException {
        final var br = new BufferedReader(new InputStreamReader(System.in));
        final var AB = br.readLine().split(" ");
        long A = Integer.parseInt(AB[0]);
        long B = Integer.parseInt(AB[1]);
        
        Deque<Number> deque = new ArrayDeque<>();
        deque.offer(new Number(A, 1));
        long result = -1;
        while (!deque.isEmpty()) {
            final var number = deque.poll();

            if (number.value == B) {
                result = number.attempt;
                break;
            }

            if (number.value * 2 <= B) {
                deque.offer(number.withDouble());
            }
            if (number.value * 10 + 1 <= B) {
                deque.offer(number.withAddOneLeft());
            }
        }
        System.out.println(result);
    }
}
