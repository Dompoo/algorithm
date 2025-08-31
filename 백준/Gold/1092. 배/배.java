import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.TreeMap;

/*

 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> cranes = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            cranes.add(Integer.parseInt(st.nextToken()));
        }
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        TreeMap<Integer, Integer> boxes = new TreeMap<>((a, b) -> b - a);
        for (int i = 0; i < M; i++) {
            int key = Integer.parseInt(st.nextToken());
            boxes.merge(key, 1, Integer::sum);
        }

        cranes.sort((a, b) -> b - a); // 내림차순 정렬

        if (cranes.get(0) < boxes.firstKey()) {
            System.out.println(-1);
            return;
        }

        int answer = 0;
        int tryCount = 0;
        // 가장 무거운걸 들 수 있는 크레인부터 자기가 들 수 있는 최대의 박스를 든다.
        while (!boxes.isEmpty()) {
            int currentIndex = tryCount % cranes.size();
            tryCount++;
            if (currentIndex == 0) {
                // 첫번째 크레인 차례가 다시 옴 = 1분 지났다.
                answer++;
            }
            Integer currentCrane = cranes.get(currentIndex);
            Integer key = boxes.ceilingKey(currentCrane); // 들 수 있는 최대 box
            if (key != null) {
                boxes.computeIfPresent(key, (k, v) -> (v == 1) ? null : v - 1);
            }
        }
        System.out.print(answer);
    }
}
