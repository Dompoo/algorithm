import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= testcase; t++) {
			int size = Integer.parseInt(br.readLine().trim());
        	int[][] arr = new int[size][size];
            
            int[] dx = new int[]{0, 1, 0, -1};
            int[] dy = new int[]{1, 0, -1, 0};
            int curDir = 0;
            
            int x = 0;
            int y = 0;
            for(int i = 1; i <= size * size; i++) {
                arr[x][y] = i;
                int nextX = x + dx[curDir % 4];
                int nextY = y + dy[curDir % 4];
                if(nextX < 0 || nextX >= size || nextY < 0 || nextY >= size || arr[nextX][nextY] != 0) {
                    curDir++;
                }
                x += dx[curDir % 4];
                y += dy[curDir % 4];
            }
            
            sb.append("#").append(t).append("\n");
            for(int i = 0; i < size; i++) {
                for(int j = 0; j < size; j++) {
                    sb.append(arr[i][j]).append(" ");
                }
                sb.append("\n");
            }
            
        } //testcase end
        System.out.print(sb);
	}
}