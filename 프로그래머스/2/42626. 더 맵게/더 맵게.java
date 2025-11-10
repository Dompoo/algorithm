import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int sco : scoville) {
            pq.offer(sco);
        }
        
        int result = 0;
        while (pq.size() > 1) {
            
            int min = pq.poll();
            if (min >= K) break;
            
            int min2 = pq.poll();
            pq.offer(min + min2 * 2);
            result++;
        }
        
        if (pq.size() == 1 && pq.poll() < K) return -1;
        else return result;
    }
}