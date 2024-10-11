import java.util.*;
import java.io.*;

class Main {
	
	public int[] parent;
	public static ArrayList<Integer>[] tree;
	public static int N;
	
	private void dfs(int curr) {
		for (int child : tree[curr]) {
			if (parent[child] == 0) {
				parent[child] = curr;
				dfs(child);
			}
		}
	}
	
	private String solution() {
		parent = new int[N + 1];
		parent[1] = 1;
		dfs(1);
		
		StringBuilder sb = new StringBuilder();
		for(int i = 2; i <= N; i++) {
			sb.append(parent[i]).append("\n");
		}
		return sb.toString();
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		tree = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++) {
			tree[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < N - 1; i++) {
			String[] s = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			tree[a].add(b);
			tree[b].add(a);
		}
		
		System.out.print(new Main().solution());
	}
}