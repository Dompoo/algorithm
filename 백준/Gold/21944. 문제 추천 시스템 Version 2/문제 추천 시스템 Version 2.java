import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeSet;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = null;

        Problems problems = new Problems();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int number = Integer.parseInt(st.nextToken());
            int difficulty = Integer.parseInt(st.nextToken());
            int algorithm = Integer.parseInt(st.nextToken());
            problems.add(number, difficulty, algorithm);
        }

        StringBuilder answer = new StringBuilder();
        N = Integer.parseInt(br.readLine());
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "add": {
                    int number = Integer.parseInt(st.nextToken());
                    int difficulty = Integer.parseInt(st.nextToken());
                    int algorithm = Integer.parseInt(st.nextToken());
                    problems.add(number, difficulty, algorithm);
                    break;
                }
                case "solved": {
                    int number = Integer.parseInt(st.nextToken());
                    problems.solve(number);
                    break;
                }
                case "recommend": {
                    int algorithm = Integer.parseInt(st.nextToken());
                    int type = Integer.parseInt(st.nextToken());
                    if (type == 1) {
                        answer.append(problems.getByAlgorithmHardest(algorithm)).append("\n");
                        break;
                    } else if (type == -1) {
                        answer.append(problems.getByAlgorithmEasiest(algorithm)).append("\n");
                        break;
                    } else {
                        throw new IllegalStateException();
                    }
                }
                case "recommend2": {
                    int type = Integer.parseInt(st.nextToken());
                    if (type == 1) {
                        answer.append(problems.getHardest()).append("\n");
                        break;
                    } else if (type == -1) {
                        answer.append(problems.getEasiest()).append("\n");
                        break;
                    } else {
                        throw new IllegalStateException();
                    }
                }
                case "recommend3": {
                    int type = Integer.parseInt(st.nextToken());
                    int difficulty = Integer.parseInt(st.nextToken());
                    if (type == 1) {
                        answer.append(problems.getEasiestHarderThan(difficulty)).append("\n");
                        break;
                    } else if (type == -1) {
                        answer.append(problems.getHardestEasierThan(difficulty)).append("\n");
                        break;
                    } else {
                        throw new IllegalStateException();
                    }
                }
                default: {
                    throw new IllegalStateException();
                }
            }
        }

        System.out.print(answer.toString().trim());
    }

    static class Problems {

        Map<Integer, TreeSet<Problem>> algorithmMap = new HashMap<>(); // 알고리즘 - 문제
        TreeSet<Problem> difficultyOrder = new TreeSet<>(); // 난이도 오름차순
        Map<Integer, Problem> numberMap = new HashMap<>();

        public Problems() {
            for (int i = 0; i <= 100; i++) {
                algorithmMap.put(i, new TreeSet<>());
            }
        }

        public void add(int number, int difficulty, int algorithm) {
            Problem problem = new Problem(number, difficulty, algorithm);
            algorithmMap.get(algorithm).add(problem);
            difficultyOrder.add(problem);
            numberMap.put(number, problem);
        }

        public void solve(int number) {
            Problem target = numberMap.get(number);
            algorithmMap.get(target.algorithm).remove(target);
            difficultyOrder.remove(target);
            numberMap.remove(number);
        }

        // 해당 알고리즘의 문제 중에, 가장 어렵고 번호가 큰 것을 반환
        public int getByAlgorithmHardest(int algorithm) {
            try {
                return algorithmMap.get(algorithm).last().number;
            } catch (Exception e) {
                return -1;
            }
        }

        // 해당 알고리즘의 문제 중에, 가장 쉽고 번호가 작은 것을 반환
        public int getByAlgorithmEasiest(int algorithm) {
            try {
                return algorithmMap.get(algorithm).first().number;
            } catch (Exception e) {
                return -1;
            }
        }

        // 가장 어렵고, 번호가 큰 것을 반환
        public int getHardest() {
            try {
                return difficultyOrder.last().number;
            } catch (Exception e) {
                return -1;
            }
        }

        // 가장 쉽고, 번호가 작은 것을 반환
        public int getEasiest() {
            try {
                return difficultyOrder.first().number;
            } catch (Exception e) {
                return -1;
            }
        }

        // 해당 난이도 이상의 문제 중에, 가장 쉽고 번호가 작은 것을 반환
        // 해당하는 문제가 없다면 null 반환
        public int getEasiestHarderThan(int difficulty) {
            Problem result = difficultyOrder.ceiling(new Problem(0, difficulty, 0));
            return result == null ? -1 : result.number;
        }

        // 해당 난이도 미만의 문제 중에, 가장 어렵고 번호가 큰 것을 반환
        // 해당하는 문제가 없다면 null 반환
        public int getHardestEasierThan(int difficulty) {
            Problem result = difficultyOrder.lower(new Problem(0, difficulty, 0));
            return result == null ? -1 : result.number;
        }
    }

    static class Problem implements Comparable<Problem> {
        int number;
        int difficulty;
        int algorithm;

        public Problem(int number, int difficulty, int algorithm) {
            this.number = number;
            this.difficulty = difficulty;
            this.algorithm = algorithm;
        }

        @Override
        public boolean equals(Object object) {
            if (object == null || getClass() != object.getClass()) return false;

            Problem problem = (Problem) object;
            return number == problem.number && difficulty == problem.difficulty && algorithm == problem.algorithm;
        }

        @Override
        public int hashCode() {
            int result = number;
            result = 31 * result + difficulty;
            result = 31 * result + algorithm;
            return result;
        }

        @Override
        public int compareTo(Problem o) {
            if (this.difficulty != o.difficulty) {
                return this.difficulty - o.difficulty;
            } else {
                return this.number - o.number;
            }
        }
    }
}
