import java.util.*;

/*
5 3
0 0 1 0 0
0 0 2 0 1
0 1 2 0 0
0 0 1 0 0
0 0 0 0 2
 */
class Main {
	
	public static class Pos {
		int x;
		int y;
		
		public Pos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		public int calculateDistance(Pos o) {
			return Math.abs(x - o.x) + Math.abs(y - o.y);
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		List<Pos> chics = new ArrayList<>();
		List<Pos> houses = new ArrayList<>();
		
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= N; j++) {
				switch (sc.nextInt()) {
					case 1:
						houses.add(new Pos(i, j));
						break;
					case 2:
						chics.add(new Pos(i, j));
				}
			}
		}
		
		distance = new int[houses.size()][chics.size()];
		survivedChic = new int[M];
		houseCount = houses.size();
		chicCount = chics.size();
		
		for (int i = 0; i < houseCount; i++) {
			for (int j = 0; j < chicCount; j++) {
				distance[i][j] = houses.get(i).calculateDistance(chics.get(j));
			}
		}
		
		dfs(-1, 0, M);
		
		System.out.print(minLen);
	}
	
	public static int houseCount;
	public static int chicCount;
	public static int[][] distance;
	public static int[] survivedChic;
	public static int minLen = Integer.MAX_VALUE;
	
	public static void dfs(int index, int currentChicCount, int targetChicCount) {
		if (currentChicCount == targetChicCount) {
			int totalChicLen = 0;
			for (int i = 0; i < houseCount; i++) {
				int chicLen = Integer.MAX_VALUE;
				for (int k : survivedChic) {
					chicLen = Math.min(chicLen, distance[i][k]);
				}
				totalChicLen += chicLen;
			}
			minLen = Math.min(totalChicLen, minLen);
		} else {
			for (int i = index + 1; i < chicCount; i++) {
				survivedChic[currentChicCount] = i;
				dfs(i, currentChicCount + 1, targetChicCount);
			}
		}
	}
}