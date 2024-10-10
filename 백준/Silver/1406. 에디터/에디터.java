import java.util.*;
import java.io.*;

class Main {
    
    private String solution(String init, int size, String[] insts) {
        Stack<Character> left = new Stack<>();
        Stack<Character> right = new Stack<>();
        
        for(int i = 0; i < init.length(); i++) {
            left.push(init.charAt(i));
        }
        
        for(String inst : insts) {
            String[] s = inst.split(" ");
            switch (s[0]) {
                case "P":
                    left.push(s[1].toCharArray()[0]);
                    break;
                case "B":
                    if (!left.empty()) left.pop();
                    break;
                case "L":
                    if (!left.empty()) right.push(left.pop());
                    break;
                case "D":
                    if (!right.empty()) left.push(right.pop());
                    break;
            }
        }
        
        StringBuilder sb = new StringBuilder();
        while(!left.empty()) {
            right.push(left.pop());
        }
        while(!right.empty()) {
            sb.append(right.pop());
        }
        
        return sb.toString();
    }
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String init = br.readLine();
        int size = Integer.parseInt(br.readLine());
        String[] insts = new String[size];
        for (int i = 0; i < size; i++) {
            insts[i] = br.readLine();
        }
        System.out.print(new Main().solution(init, size, insts));
        br.close();
    }
}