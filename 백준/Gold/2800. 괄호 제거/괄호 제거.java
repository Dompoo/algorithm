import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

/*
(1+(2*3+4))
(1+2*(3+4))
(1+2*3+4)
1+(2*(3+4))
1+(2*3+4)
1+2*(3+4)
1+2*3+4

result

 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        Set<TestData> answer = new HashSet<>();
        Queue<TestData> queue = new ArrayDeque<>();
        
        queue.offer(new TestData(input, -1));
        while (!queue.isEmpty()) {
            TestData cur = queue.poll();
            int index = cur.nextTestIndex();

            if (index != -1) {
                TestData t1 = cur.deleteVersion(index);
                TestData t2 = cur.nonDeleteVersion(index);
                queue.offer(t1);
                queue.offer(t2);
                answer.add(t1);
                answer.add(t2);
            }
        }

        StringBuilder sb = new StringBuilder();
        Set<String> dataOnly = answer.stream().map(data -> data.data).collect(Collectors.toSet());
        dataOnly.stream().sorted().filter(data -> !data.equals(input)).forEach(data -> sb.append(data).append("\n"));
        System.out.print(sb);
    }

    public static class TestData {
        String data;
        int testIndex;

        public TestData(String data, int testIndex) {
            this.data = data;
            this.testIndex = testIndex;
        }

        public int nextTestIndex() {
            for (int i = testIndex + 1; i < data.length(); i++) {
                if (data.charAt(i) == '(') {
                    return i;
                }
            }
            return -1;
        }

        public TestData deleteVersion(int index) {
            char[] chars = data.toCharArray();

            int deleteIndex = -1;
            int count = 0;
            for (int i = index; i < data.length(); i++) {
                if (chars[i] == '(') count++;
                else if (chars[i] == ')') {
                    count--;
                    if (count == 0) {
                        deleteIndex = i;
                        break;
                    }
                }
            }

            // index와 deleteIndex 위치 char만 제거한 String 반환
            int nextIndex = 0;
            char[] result = new char[data.length() - 2];
            for (int i = 0; i < data.length(); i++) {
                if (i == deleteIndex || i == index) {
                    continue;
                }
                result[nextIndex] = data.charAt(i);
                nextIndex++;
            }

            return new TestData(new String(result), result[index] == '(' ? index - 1 : index);
        }

        public TestData nonDeleteVersion(int index) {
            return new TestData(data, index);
        }

        @Override
        public String toString() {
            return "TestData{" +
                    "data='" + data + '\'' +
                    ", testIndex=" + testIndex +
                    '}';
        }

        @Override
        public boolean equals(Object object) {
            if (object == null || getClass() != object.getClass()) return false;

            TestData testData = (TestData) object;
            return testIndex == testData.testIndex && Objects.equals(data, testData.data);
        }

        @Override
        public int hashCode() {
            int result = Objects.hashCode(data);
            result = 31 * result + testIndex;
            return result;
        }
    }
}
