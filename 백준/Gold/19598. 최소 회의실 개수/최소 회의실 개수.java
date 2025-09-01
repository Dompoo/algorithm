import java.io.*;
import java.util.*;

/*
0 40
5 10
15 30
*/
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Room> queue = new PriorityQueue<>((room1, room2) -> room1.start != room2.start ? room1.start - room2.start : room1.end - room2.end);

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Room room = new Room(start, end);
            queue.offer(room);
        }

        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(queue.poll().end, 1); // 시작을 위해서 삽입
        while (!queue.isEmpty()) {
            Room current = queue.poll();
            Integer before = map.floorKey(current.start);
            if (before == null) {
                // 새로운 회의실 예약 필요
                map.put(current.end, map.getOrDefault(current.end, 0) + 1);
            } else {
                // 기존 회의실 사용
                map.computeIfPresent(before, (k, v) -> v == 1 ? null : v - 1);
                map.put(current.end, map.getOrDefault(current.end, 0) + 1);
            }
        }
        int result = map.keySet().stream()
                .map(key -> map.get(key))
                .reduce(0, Integer::sum);

        System.out.println(result);
    }

    static class Room {
        int start;
        int end;
        public Room(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
