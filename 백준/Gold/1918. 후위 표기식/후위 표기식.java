import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

/*
A+B*C-D/E


ABC*+DE-/

 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = br.readLine().toCharArray();

        StringBuilder answer = new StringBuilder();
        Deque<Character> deque = new ArrayDeque<>();

        for (char ch : inputs) {
            if ('A' <= ch && ch <= 'Z') {
                // 피연산자: 바로 출력
                answer.append(ch);
            } else if (ch == '(') {
                deque.push(ch);
            } else if (ch == ')') {
                // '(' 전까지 pop
                while (!deque.isEmpty() && deque.peek() != '(') answer.append(deque.pop());
                if (!deque.isEmpty()) deque.pop(); // '(' 제거
            } else {
                // 우선순위가 현재 이상인 것들은 pop
                while (!deque.isEmpty() && isOp(deque.peek()) && prec(deque.peek()) >= prec(ch)) {
                    answer.append(deque.pop());
                }
                deque.push(ch);
            }
        }
        while (!deque.isEmpty()) answer.append(deque.pop());

        System.out.println(answer);
    }

    private static boolean isOp(Character ch) {
        return ch == '+' || ch == '-' || ch == '*' || ch == '/';
    }

    private static int prec(Character ch) {
        if (ch == '*' || ch == '/') return 2;
        if (ch == '+' || ch == '-') return 1;
        return 0;
    }
}
