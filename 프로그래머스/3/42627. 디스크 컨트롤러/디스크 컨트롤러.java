import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> notInPq = new PriorityQueue<>((a,b) -> a.start - b.start);
        PriorityQueue<Job> pq = new PriorityQueue<>();
        int num = 0;
        for (int[] job : jobs) {
            notInPq.offer(new Job(num++, job[0], job[1]));
        }
        
        int returnTimeSum = 0;
        int time = 0;
        
        int done = 0;
        while (done < jobs.length) {
            while (!notInPq.isEmpty() && notInPq.peek().start <= time) {
                pq.offer(notInPq.poll());
            }
            
            if (pq.isEmpty()) {
                time = notInPq.peek().start;
                continue;
            }
            
            Job nextJob = pq.poll();
            time += nextJob.duration;
            returnTimeSum += (time - nextJob.start);
            done++;
        }
        
        return returnTimeSum / jobs.length;
    }
    
    class Job implements Comparable<Job> {
        int number;
        int start;
        int duration;
        public Job(int number, int start, int duration) {
            this.number = number;
            this.start = start;
            this.duration = duration;
        }
        
        public String toString() {
            return "n=" + number +",s=" + start + ",d=" + duration;
        }
        
        public int compareTo(Job other) {
            if (this.duration != other.duration) return this.duration - other.duration;
            if (this.start != other.start) return this.start - other.start;
            return this.number - other.number;
        }
    }
}