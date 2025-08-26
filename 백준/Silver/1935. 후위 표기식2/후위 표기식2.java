import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

/*
5
-1 -1 -1 -3 -4
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        int[] alphaValue = new int[26];
        Arrays.fill(alphaValue, Integer.MAX_VALUE);
        for (int i = 0; i < count; i++) {
            alphaValue[i] = Integer.parseInt(br.readLine());
        }

        ArrayDeque<Double> deque = new ArrayDeque<>();
        for (char input : chars) {
            if (Character.isAlphabetic(input)) {
                deque.addFirst((double) alphaValue[input - 'A']);
            } else {
                Double a = deque.removeFirst();
                Double b = deque.removeFirst();
//                System.out.println("" + a + input + b);
                if (input == '+') {
                    deque.addFirst(b + a);
                } else if (input == '-') {
                    deque.addFirst(b - a);
                } else if (input == '*') {
                    deque.addFirst(b * a);
                } else if (input == '/') {
                    deque.addFirst(b / a);
                } else {
                    throw new IllegalStateException();
                }
            }
        }
        if (deque.size() != 1) throw new IllegalStateException();

        System.out.printf("%.2f", deque.getFirst());
    }
}
