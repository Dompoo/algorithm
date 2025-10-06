class Solution {
    static int minSize = Integer.MAX_VALUE;
    static int[][] size;
        
    public int solution(int[][] sizes) {
        int max0 = 0;
        int max1 = 0;
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > sizes[i][1]) {
                max0 = Math.max(sizes[i][1], max0);
                max1 = Math.max(sizes[i][0], max1);
            } else {
                max0 = Math.max(sizes[i][0], max0);
                max1 = Math.max(sizes[i][1], max1);
            }
        }
        return max0 * max1;
    }
}