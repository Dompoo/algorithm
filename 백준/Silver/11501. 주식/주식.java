import java.util.*;
import java.io.*;
import java.util.stream.Collectors;

class Main {
    
    private String solution(int arrSize, List<Integer> list) {
        int currentMax = 0;
        
        long result = 0;
        for (int i = list.size() - 1; i >= 0; i--) {
            int current = list.get(i);
            
            if (current > currentMax) {
                currentMax = current;
            } else {
                result += currentMax - current;
            }
        }
        
        return result + "\n";
    }
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int testcase = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < testcase; i++) {
            int arrSize = Integer.parseInt(br.readLine());
            String[] arr = br.readLine().split(" ");
            List<Integer> list = Arrays.stream(arr).map(Integer::parseInt).collect(Collectors.toList());
            sb.append(new Main().solution(arrSize, list));
        }
        System.out.print(sb);
        br.close();
    }
}