import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= testcase; t++) {
            int size = Integer.parseInt(br.readLine().trim());
            String[] value = new String[size];
            int[] count = new int[size];
            for(int i = 0; i < size; i++) {
                String[] inputs = br.readLine().trim().split(" ");
                value[i] = inputs[0];
                count[i] = Integer.parseInt(inputs[1]);
            }
            
            sb.append("#").append(t).append("\n");
            int totalCount = 0;
            for(int i = 0; i < size; i++) {
                for(int c = 0; c < count[i]; c++) {
                    sb.append(value[i]);
                    if(++totalCount % 10 == 0) {
                        sb.append("\n");
                    }
                }
            }
            if(totalCount % 10 != 0) {
				sb.append("\n");
            }
        } // testcase end
        System.out.print(sb);
    }
}