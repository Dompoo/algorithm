import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split(" ");
		int peopleCount = Integer.parseInt(s[0]);
		int partyCount = Integer.parseInt(s[1]);
		
		boolean[] truthArr = new boolean[peopleCount + 1];
		Map<Integer, List<Integer>> partyMap = new HashMap<>();
		for (int p = 0; p < partyCount; p++) {
			partyMap.put(p, new ArrayList<>());
		}
		
		String[] truth = br.readLine().split(" ");
		int truthSize = Integer.parseInt(truth[0]);
		for (int t = 1; t <= truthSize; t++) {
			truthArr[Integer.parseInt(truth[t])] = true;
		}
		
		for (int p = 0; p < partyCount; p++) {
			String[] s2 = br.readLine().split(" ");
			int size = Integer.parseInt(s2[0]);
			for (int j = 1; j <= size; j++) {
				partyMap.get(p).add(Integer.parseInt(s2[j]));
			}
		}
		
		int lastLieParty = partyMap.size();
		while (true) {
			
			List<Integer> deletePartyList = new ArrayList<>();
			
			for (int keys : partyMap.keySet()) {
				// 거짓말 할 수 있는 파티 업데이트
				
				for (int t = 1; t <= peopleCount; t++) {
					
					// 진실을 아는 사람이 파티에 포함되어 있다면
					List<Integer> peoples = partyMap.get(keys);
					if (truthArr[t] && peoples.contains(t)) {
						// 해당 파티의 모든 사람이 진실을 아는 사람으로 분류됨
						for (int people : peoples) {
							truthArr[people] = true;
						}
						
						// 해당 파티는 거짓말 할 수 있는 파티가 아님
						deletePartyList.add(keys);
						break;
					}
				}
			}
			
//			System.out.println("party : " + partyMap);
//			System.out.println("delete : " + deletePartyList);
//			System.out.println();
			
			for (int delete : deletePartyList) {
				partyMap.remove(delete);
			}
			
			
			// 업데이트 후 변동이 없다면 종료
			if (lastLieParty == partyMap.size()) {
				break;
			}
			
			lastLieParty = partyMap.size();
		}
		
		System.out.print(lastLieParty);
	}
}