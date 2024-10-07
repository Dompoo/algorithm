import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;


/*
7 7 7
6 5 4
3 2 5
6 2 6
0 0 0
*/

class Main {
	
	static class Triangle {
		
		int[] arr = new int[3];
		
		public Triangle(int a, int b, int c) {
			this.arr[0] = a;
			this.arr[1] = b;
			this.arr[2] = c;
			Arrays.sort(arr);
		}
		
		public String getSort() {
			if(arr[2] >= arr[1] + arr[0]) {
				return "Invalid";
			} else if(arr[0] == arr[1] && arr[1] == arr[2]) {
				return "Equilateral";
			} else if(arr[0] == arr[1] || arr[1] == arr[2]) {
				return "Isosceles";
			} else {
				return "Scalene";
			}
		}
	}
	
	public static List<Triangle> list = new ArrayList<>();
	
	public String solution() {
		StringBuilder result = new StringBuilder();
		for (Triangle triangle : list) {
			result.append(triangle.getSort()).append("\n");
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			if(a == 0 && b == 0 && c == 0) break;
			else list.add(new Triangle(a, b, c));
		}
		System.out.println(new Main().solution());
	}
}