import java.util.*;
import java.io.*;
/*
7
2 4
11 10
15 8
4 6
5 3
8 10
13 6
 */
class Main {
	
	public static class Pillar implements Comparable<Pillar> {
		int index;
		int height;
		
		public Pillar(String[] args) {
			this.index = Integer.parseInt(args[0]);
			this.height = Integer.parseInt(args[1]);
		}
		
		@Override
		public int compareTo(Pillar o) {
			return this.index - o.index;
		}
		
		@Override
		public String toString() {
			return "{" +
					"index=" + index +
					", height=" + height +
					'}';
		}
	}
	
	private String solution(List<Pillar> pillars) {
		// 가장 높은 기둥 찾기
		int maxH = Integer.MIN_VALUE;
		int maxI = 0;
		for (Pillar p : pillars) {
			if (p.height > maxH) {
				maxH = p.height;
				maxI = p.index;
			}
		}
		
		// 가장 높은 기둥 기준 좌우 나누기
		ArrayList<Pillar> left = new ArrayList<>();
		ArrayList<Pillar> right = new ArrayList<>();
		for (Pillar p : pillars) {
			if (p.index <= maxI) {
				left.add(p);
			}
			if (p.index >= maxI) {
				right.add(p);
			}
		}
		
		int result = 0;
		
		Collections.sort(left);
		int maxHeightForLeft = 0;
		int lastIndex = left.get(0).index;
		for (Pillar p : left) {
			if (maxHeightForLeft <= p.height) {
				result += maxHeightForLeft * (p.index - lastIndex); //두께
				maxHeightForLeft = p.height;
				lastIndex = p.index;
			}
		}
		
		Collections.sort(right, Comparator.reverseOrder());
		int maxHeightForRight = 0;
		lastIndex = right.get(0).index;
		for (Pillar p : right) {
			if (maxHeightForRight <= p.height) {
				result += maxHeightForRight * (lastIndex - p.index); //두께
				maxHeightForRight = p.height;
				lastIndex = p.index;
			}
		}
		
		result += maxH;
		
		return String.valueOf(result);
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		List<Pillar> pillars = new ArrayList<>();
		for(int i = 0; i < size; i++) {
			pillars.add(new Pillar(br.readLine().split(" ")));
		}
		System.out.print(new Main().solution(pillars));
	}
}