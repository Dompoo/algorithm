import java.util.*;
import java.io.*;

class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int testcase = Integer.parseInt(br.readLine().trim());
        for(int t = 1; t <= testcase; t++) {
	        int inputSize = Integer.parseInt(br.readLine().trim());
            int velocity = 0;
            int move = 0;
            for(int i = 0; i < inputSize; i++) {
                String[] inputs = br.readLine().trim().split(" ");
                switch(inputs[0]) {
                    case "0": {
                        break;
                    }
                    case "1": {
                        velocity += Integer.parseInt(inputs[1]);
                        break;
                    }
                    case "2": {
                        velocity -= Integer.parseInt(inputs[1]);
                        velocity = Math.max(velocity, 0);
                        break;
                    }
                }
                move += velocity;
            }
            sb.append("#").append(t).append(" ").append(move).append("\n");
        } //tc end
        System.out.print(sb);
    }
}