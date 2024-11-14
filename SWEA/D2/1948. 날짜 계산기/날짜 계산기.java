import java.util.*;
import java.io.*;

class Solution {
    public static class Date {
        int month;
        int day;
        public Date(String x, String y) {
            this.month = Integer.parseInt(x);
            this.day = Integer.parseInt(y);
        }
        public int toDays() {
            int result = 0;
            if(month >= 2) result += 31; //1
            if(month >= 3) result += 28; //2
            if(month >= 4) result += 31; //3
            if(month >= 5) result += 30; //4
            if(month >= 6) result += 31; //5
            if(month >= 7) result += 30; //6
            if(month >= 8) result += 31; //7
            if(month >= 9) result += 31; //8
            if(month >= 10) result += 30; //9
            if(month >= 11) result += 31; //10
            if(month >= 12) result += 30; //11
            result += day;
            return result;
        }
    }
    
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int testcase = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= testcase; t++) {
			String[] inputs = br.readLine().trim().split(" ");
            Date x = new Date(inputs[0], inputs[1]);
            Date y = new Date(inputs[2], inputs[3]);
            int result = y.toDays() - x.toDays() + 1;
            
            sb.append("#").append(t).append(" ").append(result).append("\n");
		} // testcase end
        System.out.print(sb);
	}
}