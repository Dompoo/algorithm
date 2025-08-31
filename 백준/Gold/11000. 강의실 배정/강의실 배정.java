import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = null;
        List<int[]> inputs = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            inputs.add(new int[] { start, end });
        }

        // 시작 시간 순으로 정렬
        inputs.sort((arr1, arr2) -> arr1[0] != arr2[0] ? arr1[0] - arr2[0] : arr1[1] - arr2[1]);

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(1, 1);
        for (int i = 0; i < N; i++) {
            int start = inputs.get(i)[0];
            int end = inputs.get(i)[1];
            Integer key = map.floorKey(start);
            if (key == null) {
                // 이전에 진행할 수업이 없음 -> 새로운 강의실 필요
                map.put(end, map.getOrDefault(end, 0) + 1);
            } else {
                // 이전에 진행할 수업 존재! -> 해당 수업 이후로 진행
                // 기존 수업을 하나 제거하고
                // 새로운 수업을 추가한다.
                map.computeIfPresent(key, (k, v) -> v == 1 ? null : v - 1);
                map.put(end, map.getOrDefault(end, 0) + 1);
            }
        }
        int totalRoom = map.keySet().stream()
                .map(key -> map.get(key))
                .reduce(0, Integer::sum);
        System.out.println(totalRoom);
    }
}
