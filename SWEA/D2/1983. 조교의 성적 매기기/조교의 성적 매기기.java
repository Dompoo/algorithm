import java.util.*;
import java.io.*;

/*
1
10 2
87 59 88
99 94 78
94 86 86
99 100 99
69 76 70
76 89 96
98 95 96
74 69 60
98 84 67
85 84 91
 */
class Solution {
	
	public static class Student implements Comparable<Student> {
		public int score;
		public int index;
		
		public Student(int mid, int end, int homework, int index) {
			this.score = mid * 35 + end * 45 + homework * 20;
			this.index = index;
		}
		
		// 성적 오름차순
		@Override
		public int compareTo(Student o) {
			return o.score - this.score;
		}
		
		@Override
		public String toString() {
			return index + " : " + score;
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int testcase = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		
		for (int t = 1; t <= testcase; t++) {
			List<Student> students = new ArrayList<>();
			
			String[] NM = br.readLine().trim().split(" ");
			int studentNumber = Integer.parseInt(NM[0]);
			int targetIndex = Integer.parseInt(NM[1]);
			
			for(int i = 1; i <= studentNumber; i++) {
				String[] input = br.readLine().trim().split(" ");
				students.add(new Student(
						Integer.parseInt(input[0]),
						Integer.parseInt(input[1]),
						Integer.parseInt(input[2]),
						i
				));
			}
			
			Collections.sort(students);
			
			int targetDengsu = 0;
			for (int i = 0; i < studentNumber; i++) {
				if (students.get(i).index == targetIndex) {
					targetDengsu = i;
					break;
				}
			}
			
			int scoreRate = targetDengsu / (studentNumber / 10);
			/*
			20명에 대하여 등수는
			1 ~ 20까지 나올 수 있음
			-> 1/20 ~ 20/20까지
			20/20 = 1
			19/20 = 0.95
			--
			18/20 = 0.90
			--
			 */
			String score;
			if (scoreRate == 0) {
				score = "A+";
			} else if (scoreRate == 1) {
				score = "A0";
			} else if (scoreRate == 2) {
				score = "A-";
			} else if (scoreRate == 3) {
				score = "B+";
			} else if (scoreRate == 4) {
				score = "B0";
			} else if (scoreRate == 5) {
				score = "B-";
			} else if (scoreRate == 6) {
				score = "C+";
			} else if (scoreRate == 7) {
				score = "C0";
			} else if (scoreRate == 8) {
				score = "C-";
			} else {
				score = "D0";
			}
			sb.append("#").append(t).append(" ").append(score);
			if (t != testcase) {
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
}