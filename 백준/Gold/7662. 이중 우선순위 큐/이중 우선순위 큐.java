import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.NoSuchElementException;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        StringBuilder answer = new StringBuilder();
        while (T-- > 0) {
            int count = Integer.parseInt(br.readLine());
            MyPQ pq = new MyPQ();
            for (int i = 0; i < count; i++) {
                String[] inputs = br.readLine().split(" ");
                String command = inputs[0];
                int number = Integer.parseInt(inputs[1]);

                if (command.equals("I")) {
                    pq.add(number);
                } else if (command.equals("D")) {
                    if (number == 1) {
                        pq.deleteMax();
                    } else if (number == -1) {
                        pq.deleteMin();
                    } else {
                        throw new IllegalStateException();
                    }
                } else {
                    throw new IllegalStateException();
                }
            }

            if (pq.isEmpty()) {
                answer.append("EMPTY").append("\n");
            } else {
                int max = pq.getMax();
                int min = pq.getMin();
                answer.append(max).append(" ").append(min).append("\n");
            }
        }

        System.out.println(answer);
    }

    private static class MyPQ {

        // 숫자 종류를 오름차순으로 정렬, (숫자 종류, 개수)
        TreeMap<Integer, Integer> map = new TreeMap<>();

        public void add(int num) {
            map.merge(num, 1, Integer::sum);
        }

        public void deleteMax() {
            try {
                Integer maxKey = map.lastKey();
                minus(maxKey);
            } catch (NoSuchElementException e) {
                // NOOP
            }
        }

        public void deleteMin() {
            try {
                Integer minKey = map.firstKey();
                minus(minKey);
            } catch (NoSuchElementException e) {
                // NOOP
            }
        }

        private void minus(Integer key) {
            Integer maxKeyCount = map.get(key);
            if (maxKeyCount == 1) {
                map.remove(key);
            } else if (maxKeyCount >= 2) {
                map.put(key, maxKeyCount - 1);
            } else {
                // NOOP
            }
        }

        public boolean isEmpty() {
            return map.isEmpty();
        }

        public int getMax() {
            return map.lastKey();
        }

        public int getMin() {
            return map.firstKey();
        }
    }
}
