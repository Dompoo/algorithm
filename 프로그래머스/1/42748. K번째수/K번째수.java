import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        int answerIdx = 0;
        
        for(int[] command : commands) {
            int start = command[0]; // 2면 index 1부터 포함
            int end = command[1]; // 4면 index 3부터 포함
            int pos = command[2];
            int[] other = new int[end - start + 1];
            System.arraycopy(array, start - 1, other, 0, end - start + 1);
            Arrays.sort(other);
            answer[answerIdx++] = other[pos - 1];
        }
        
        return answer;
    }
}