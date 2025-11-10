import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

@SuppressWarnings("ALL")
public class Main {

    static class Student implements Comparable<Student> {

        int number;
        int star;
        int startDate;

        public Student(int number, int star, int startDate) {
            this.number = number;
            this.star = star;
            this.startDate = startDate;
        }

        @Override
        public int compareTo(Student o) {
            if (this.star != o.star) return this.star - o.star;
            return this.startDate - o.startDate;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        List<Student> students = new ArrayList<>();

        int time = 0;
        for (int in : arr) {
            time++;
            boolean contains = false;
            for (Student student : students) {
                if (student.number == in) {
                    student.star++;
                    contains = true;
                    break;
                }
            }
            if (contains) continue;

            if (students.size() < N) {
                students.add(new Student(in, 1, time));
                continue;
            }

            // 하나 제거하고 넣기
            Collections.sort(students);
            Student last = students.remove(0);
            students.add(new Student(in, 1, time));
        }

        Collections.sort(students, (a, b) -> a.number - b.number);
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            sb.append(student.number).append(" ");
        }
        System.out.println(sb);
    }
}
