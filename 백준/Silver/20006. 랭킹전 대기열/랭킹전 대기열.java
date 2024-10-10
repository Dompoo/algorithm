import java.util.*;
import java.io.*;

/*
10 5
10 a
15 b
20 c
25 d
30 e
17 f
18 g
26 h
24 i
28 j
 */
class Main {
    
    public static class Player implements Comparable<Player> {
        int level;
        String name;
        
        public Player(String[] input) {
            this.level = Integer.parseInt(input[0]);
            this.name = input[1];
        }
        
        @Override
        public int compareTo(Player o) {
            return this.name.compareTo(o.name);
        }
        
        @Override
        public String toString() {
            return level + " " + name;
        }
    }
    
    public class Room {
        int level;
        int maxRoomSize;
        List<Player> players;
        
        public Room(Player player, int maxRoomSize) {
            this.level = player.level;
            this.maxRoomSize = maxRoomSize;
            this.players = new ArrayList<>();
            this.players.add(player);
        }
        
        public boolean canJoin(Player player) {
            return (Math.abs(level - player.level) <= 10) && players.size() < maxRoomSize;
        }
        
        public void join(Player player) {
            players.add(player);
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            Collections.sort(players);
            
            if (players.size() == maxRoomSize) {
                sb.append("Started!").append("\n");
            } else{
                sb.append("Waiting!").append("\n");
            }
			
			for (Player player : players) {
				sb.append(player).append("\n");
			}
            
            return sb.toString();
        }
    }
    
    private String solution(int inputSize, int roomSize, List<Player> list) {
        List<Room> rooms = new ArrayList<>();
        
        for(Player player : list) {
            boolean hasJoin = false;
            
            // 최근 생성된 것부터 방 참여하기
            for(Room room : rooms) {
                if (room.canJoin(player)) {
                    room.join(player);
                    hasJoin = true;
                    break;
                }
            }
            
            // 방을 만들어야 함
            if (!hasJoin) {
                rooms.add(new Room(player, roomSize));
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (Room room : rooms) {
            sb.append(room);
        }
        
        return sb.toString();
    }
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int inputSize = Integer.parseInt(s1[0]);
        int roomSize = Integer.parseInt(s1[1]);
        List<Player> list = new ArrayList<>();
        for (int i = 0; i < inputSize; i++) {
            list.add(new Player(br.readLine().split(" ")));
        }
        System.out.print(new Main().solution(inputSize, roomSize, list));
    }
}