import java.util.*;
/*
9
0 1 0 1 0 0 0 1 0
2
1 3
2 3
 */
class Main {
	
	static class SwitchChange {
		boolean isMale;
		int index;
		
		public SwitchChange(boolean isMale, int index) {
			this.isMale = isMale;
			this.index = index;
		}
	}
	
	static class Switch {
		boolean[] arr;
		int size;
		
		public Switch(int size, boolean[] arr) {
			this.size = size;
			this.arr = arr;
		}
		
		private void flip(int index) {
			arr[index] = !arr[index];
		}
		
		public void doMaleJob(int index) {
			for(int i = index; i <= size; i += index) {
				flip(i);
			}
		}
		
		public void doFemaleJob(int index) {
			flip(index);
			for(int i = 1; i < size; i++) {
				int left = index - i;
				int right = index + i;
				if (left < 1 || right > size || arr[left] != arr[right]) {
					break;
				}
				flip(left);
				flip(right);
			}
		}
		
		@Override
		public String toString() {
			StringBuilder result = new StringBuilder();
			int count = 0;
			for(int i = 1; i <= size; i++) {
				result.append(arr[i] ? 1 : 0);
				count++;
				if(count % 20 == 0) result.append("\n");
				else if(i != size) result.append(" ");
			}
			return result.toString();
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		boolean[] arr = new boolean[size + 1]; // 1 ~ size사용
		for (int i = 1; i <= size; i++) {
			int sw = sc.nextInt();
			arr[i] = sw == 1;
		}
		
		Switch o = new Switch(size, arr);
		
		List<SwitchChange> list = new ArrayList<>();
		int stuSize = sc.nextInt();
		for (int i = 0; i < stuSize; i++) {
			int sex = sc.nextInt();
			int index = sc.nextInt();
			list.add(new SwitchChange(sex == 1, index));
		}
		
		System.out.print(new Main().solution(o, list));
		
	}
	
	private String solution(Switch o, List<SwitchChange> list) {
//		for(int i = 1; i < o.size; i++) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		
		for (SwitchChange c : list) {
			if (c.isMale) {
				o.doMaleJob(c.index);
			} else {
				o.doFemaleJob(c.index);
			}
//			System.out.println(o);
		}
		
		return o.toString();
	}
}