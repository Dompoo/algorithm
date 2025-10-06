/*
N/2 마리
123, 4->2 : 2
234, 6->3 : 3
23, 6->3 : 2
*/
class Solution {
    public int solution(int[] nums) {
        int maxSize = nums.length / 2;
        int newCount = 0;
        boolean[] pocketmon = new boolean[200001];
        
        for(int num : nums) {
           if (pocketmon[num] == false) {
               pocketmon[num] = true;
               newCount++;
           }
        }
        
        return Math.min(maxSize, newCount);
    }
}