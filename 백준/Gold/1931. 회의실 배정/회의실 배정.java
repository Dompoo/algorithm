import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        List<Room> list = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            Room room = new Room(start, end);
            list.add(room);
        }

        list.sort((roomA, roomB) -> roomA.end != roomB.end ? roomA.end - roomB.end : roomA.start - roomB.start);

        int answer = 0;
        int lastEndTime = 0;
        for (Room room : list) {
            if (room.start >= lastEndTime) {
                answer++;
                lastEndTime = room.end;
            }
        }
        System.out.println(answer);
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
