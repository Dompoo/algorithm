class Solution {
    
    static int[][] DUN;
    static int K;
    static int SIZE;
    static int MAX = 0;
    
    public int solution(int k, int[][] inputs) {
        DUN = inputs;
        SIZE = inputs.length;
        K = k;
        dfs(new boolean[SIZE], 0, new int[SIZE]);
        return MAX;
    }
    
    public void dfs(boolean[] visited, int length, int[] tryout) {
        if (length == SIZE) {
            int hp = K;
            int cur = 0;
            for (int in : tryout) {
                int startMin = DUN[in][0];
                int minus = DUN[in][1];
                if (hp < startMin) break;
                
                hp -= minus;
                cur++;
            }
            MAX = Math.max(MAX, cur);
        }
        
        for (int i = 0; i < SIZE; i++) {
            if (visited[i]) continue;
            
            visited[i] = true;
            tryout[length] = i;
            dfs(visited, length + 1, tryout);
            visited[i] = false;
        }
        
    }
}