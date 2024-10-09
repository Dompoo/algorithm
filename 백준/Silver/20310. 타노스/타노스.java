import java.util.*;
import java.io.*;

class Main {
	
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.print(new Main().solution(str));
    }
    
    private String solution(String str) {
        int count0 = 0;
        int count1 = 0;
        char[] resultArr = str.toCharArray();
        
        for(char ch : str.toCharArray()) {
            if (ch == '0') count0++;
            else if (ch == '1') count1++;
        }
        
        count0 /= 2; //남아야할 0개수
        count1 /= 2; //남아야할 1개수
        
        for(int i = 0; i < str.length(); i++) {
            
            if(str.charAt(i) == '0') {
                if (count0 <= 0) {
                    //바꿔야 함
                    resultArr[i] = '-';
                }
                count0--;
            }
            
            int i2 = Math.abs(str.length() - i - 1);
            if (str.charAt(i2) == '1') {
                if (count1 <= 0) {
                    resultArr[i2] = '-';
                }
                count1--;
            }
        }
        
        String result = new String(resultArr);
        return result.replace("-", "");
    }
}