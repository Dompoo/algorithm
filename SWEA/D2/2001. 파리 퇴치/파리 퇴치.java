import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= testcase; t++) {
            String[] NM = br.readLine().trim().split(" ");
            int N = Integer.parseInt(NM[0]);
            int M = Integer.parseInt(NM[1]);
            int[][] arr = new int[N][N];
            for(int i = 0; i < N; i++) {
                String[] inputs = br.readLine().trim().split(" ");
                for(int j = 0; j < N; j++) {
                    arr[i][j] = Integer.parseInt(inputs[j]);
                    if(j != 0) {
                        arr[i][j] += arr[i][j - 1];
                    }
                }
            }               
            int maxSum = Integer.MIN_VALUE;
            for(int offsetX = 0; offsetX <= N - M; offsetX++) {
                for(int offsetY = 0; offsetY <= N - M; offsetY++) {
                    int curSum = 0;
                    for(int i = 0; i < M; i++) {
                        curSum += arr[offsetX + i][offsetY + M - 1] + (offsetY - 1 >= 0 ? - arr[offsetX + i][offsetY - 1] : 0);
                    }
                    maxSum = Math.max(maxSum, curSum);
                }
             }
            sb.append("#").append(t).append(" ").append(maxSum).append("\n");
        } //tc end
        System.out.print(sb);
    }
}