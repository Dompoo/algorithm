import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        Deque<Paper> deque = new ArrayDeque<>();
        String[] inputs;
        while (tc-- > 0) {
            inputs = br.readLine().split("\\s+");
            int count = Integer.parseInt(inputs[0]);
            int targetIndex = Integer.parseInt(inputs[1]);
            inputs = br.readLine().split("\\s+");
            for (int i = 0; i < count; i++) {
                int priority = Integer.parseInt(inputs[i]);
                deque.addLast(new Paper(priority, i));
            }

            int result = 0;
            while (!deque.isEmpty()) {
                Paper currentPaper = deque.removeFirst();
                if (currentPaper.canPrint(deque)) {
                    result++;
                    if (currentPaper.index == targetIndex) {
                        break;
                    }
                } else {
                    deque.addLast(currentPaper);
                }
            }
            sb.append(result).append("\n");
            deque.clear();
        }
        System.out.print(sb);
    }

    private static class Paper {
        int priority;
        int index;

        public Paper(int priority, int index) {
            this.priority = priority;
            this.index = index;
        }

        public boolean canPrint(Deque<Paper> papers) {
            return papers.stream().noneMatch(paper -> paper.priority > this.priority);
        }
    }
}
