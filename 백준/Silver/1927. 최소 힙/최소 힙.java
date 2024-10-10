import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int size = Integer.parseInt(br.readLine());
        int[] control = new int[size];
        
        for (int i = 0; i < size; i++) {
            control[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.print(new Main().solution(size, control));
    }
    
    private String solution(int size, int[] control) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        StringBuilder sb = new StringBuilder();
        
        for(int c : control) {
            if(c == 0) {
                int value ;
                if (pq.isEmpty()) {
                    value = 0;
                } else {
                    value = pq.poll();
                }
                
                sb.append(value).append("\n");
            } else {
                pq.offer(c);
            }
        }
        
        return sb.toString();
    }
}