import java.util.*;

/*
5
55 185
58 183
88 186
60 175
46 155
 */
class Main {
	
	public static class Person {
		int w;
		int h;
		
		public Person(int w, int h) {
			this.w = w;
			this.h = h;
		}
		
		public boolean isBiggerthan(Person o) {
			return this.w > o.w && this.h > o.h;
		}
	}
	
	public String solution(int size, Person[] arr) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < size; i++) {
			Person curr = arr[i];
			int rank = 1;
			for (Person other : arr) {
				if (other.isBiggerthan(curr)) rank++;
			}
			sb.append(rank);
			if(i != size - 1) sb.append(" ");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		Person[] arr = new Person[size];
		
		for (int i = 0; i < size; i++) {
			int w = sc.nextInt();
			int h = sc.nextInt();
			arr[i] = new Person(w, h);
		}
		
		System.out.print(new Main().solution(size, arr));
	}
}