import java.util.*;
import java.io.*;

class Main {
	static int[] parent;
	static int find(int x) {
		if (parent[x] == x) return x;
		else return parent[x] = find(parent[x]);
	}
	
	static void union(int a, int b) {
		a = find(a);
		b = find(b);
		if (a != b) parent[b] = a;
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] s = br.readLine().split(" ");
		int peopleCount = Integer.parseInt(s[0]);
		int partyCount = Integer.parseInt(s[1]);
		
		parent = new int[peopleCount + 1];
		for (int i = 1; i <= peopleCount; i++) {
			parent[i] = i;
		}
		
		List<List<Integer>> partyList = new ArrayList<>();
		for (int p = 0; p < partyCount; p++) {
			partyList.add(new ArrayList<>());
		}
		
		String[] truth = br.readLine().split(" ");
		int truthSize = Integer.parseInt(truth[0]);
		List<Integer> truthGroup = new ArrayList<>();
		
		for (int t = 1; t <= truthSize; t++) {
			truthGroup.add(Integer.parseInt(truth[t]));
		}
		
		for (int p = 0; p < partyCount; p++) {
			String[] s2 = br.readLine().split(" ");
			int size = Integer.parseInt(s2[0]);
			for (int j = 1; j <= size; j++) {
				partyList.get(p).add(Integer.parseInt(s2[j]));
			}
		}
		
		// 파티정보로 union 연산 수행
		for (List<Integer> party : partyList) {
			int firstPerson = party.get(0);
			for (int i = 1; i < party.size(); i++) {
				union(firstPerson, party.get(i));
			}
		}
		
		// 진실을 아는 사람들의 그룹 확장
		Set<Integer> expandedTruthGroup = new HashSet<>(truthGroup);
		boolean changed;
		do {
			changed = false;
			Set<Integer> newMembers = new HashSet<>();
			for (int truthPerson : expandedTruthGroup) {
				for (int i = 1; i <= peopleCount; i++) {
					if (!expandedTruthGroup.contains(i) && find(truthPerson) == find(i)) {
						newMembers.add(i);
						changed = true;
					}
				}
			}
			expandedTruthGroup.addAll(newMembers);
		} while (changed);
		
		truthGroup = new ArrayList<>(expandedTruthGroup);
		
		// 과장된 이야기를 할 수 있는 파티 계산
		int result = 0;
		for (List<Integer> party : partyList) {
			boolean canLie = true;
			for (int person : party) {
				if (truthGroup.contains(find(person))) {
					canLie = false;
					break;
				}
			}
			if (canLie) result++;
		}
		
		
		System.out.print(result);
	}
}