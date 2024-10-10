import java.util.*;
import java.io.*;
/*
4 8
WEAK 10000
NORMAL 100000
STRONG 1000000
SUPER 30000000
0
9999
10000
10001
50000
25000000
100000
500000
1000000
20000000
 */
class Main {
    
    public static class Name {
        String name;
        int power;
        
        public Name(String[] input) {
            this.name = input[0];
            this.power = Integer.parseInt(input[1]);
        }
    }
    
    private String solution(List<Name> nameList, int inputSize, int[] input) {
        StringBuilder sb = new StringBuilder();
        
        for(int power : input) {
            int left = 0;
            int right = nameList.size() - 1;
            int resultIndex = 0;
            
            while(left <= right) {
                int middle = (left + right) / 2;
                
                if(power <= nameList.get(middle).power) {
                    resultIndex = middle;
                    right = middle - 1;
                } else {
                    left = middle + 1;
                }
            }
            
            sb.append(nameList.get(resultIndex).name).append("\n");
        }
        
        return sb.toString();
    }
    
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s1 = br.readLine().split(" ");
        int nameSize = Integer.parseInt(s1[0]);
        int inputSize = Integer.parseInt(s1[1]);
        List<Name> nameList = new ArrayList<>();
        
        for (int i = 0; i < nameSize; i++) {
            String[] s2 = br.readLine().split(" ");
            nameList.add(new Name(s2));
        }
        
        int[] input = new int[inputSize];
        
        for (int i = 0; i < inputSize; i++) {
            input[i] = Integer.parseInt(br.readLine());
        }
        
        System.out.print(new Main().solution(nameList, inputSize, input));
    }
}