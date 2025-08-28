import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        MyPQ pq = new MyPQ();

        int count = Integer.parseInt(br.readLine());
        while (count-- > 0) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());
            pq.add(new Problem(num, difficulty));
        }

        StringBuilder answer = new StringBuilder();
        count = Integer.parseInt(br.readLine());
        while (count-- > 0) {
            st = new StringTokenizer(br.readLine());
            String command = st.nextToken();
            switch (command) {
                case "add": {
                    int num = Integer.parseInt(st.nextToken());
                    int difficulty = Integer.parseInt(st.nextToken());
                    pq.add(new Problem(num, difficulty));
                    break;
                }
                case "recommend": {
                    int type = Integer.parseInt(st.nextToken());
                    if (type == 1) {
                        Problem problem = pq.getMax();
                        answer.append(problem.num).append("\n");
                    } else if (type == -1) {
                        Problem problem = pq.getMin();
                        answer.append(problem.num).append("\n");
                    } else {
                        throw new IllegalStateException();
                    }
                    break;
                }
                case "solved": {
                    int num = Integer.parseInt(st.nextToken());
                    pq.deleteOf(num);
                    break;
                }
                default: {
                    throw new IllegalStateException();
                }
            }
        }
        System.out.println(answer);
    }

    private static class MyPQ {
        // 숫자 종류를 오름차순으로 정렬, (숫자 종류, 개수)
        TreeSet<Problem> set = new TreeSet<>();
        // 번호 -> 문제 검색용 map
        Map<Integer, Problem> map = new HashMap<>();

        public void add(Problem problem) {
            map.put(problem.num, problem);
            set.add(problem);
        }

        public void deleteOf(int num) {
            Problem result = map.remove(num);
            set.remove(result);
        }

        public Problem getMax() {
            return set.last();
        }

        public Problem getMin() {
            return set.first();
        }
    }

    private static class Problem implements Comparable<Problem> {
        int num;
        int difficulty;

        public Problem(int num, int difficulty) {
            this.num = num;
            this.difficulty = difficulty;
        }

        // 난이도 오름차순, 같은 난이도의 경우에는 문제 번호 오름차순으로 정렬
        @Override
        public int compareTo(Problem other) {
            if (this == other) {
                return 0;
            } else if (this.difficulty != other.difficulty) {
                return this.difficulty - other.difficulty;
            } else if (this.num != other.num) {
                return this.num - other.num;
            } else {
                throw new IllegalStateException(String.format("문제번호=%d, 난이도=%d로 동일한 객체가 비교되었습니다.", num, difficulty));
            }
        }
    }
}
