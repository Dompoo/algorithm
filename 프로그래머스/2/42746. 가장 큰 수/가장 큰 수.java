import java.util.*;
import java.util.stream.Collectors;

class Solution {
    public String solution(int[] numbers) {
        String result = Arrays.stream(numbers).boxed()
            .map(number -> new MyNum(number))
            .sorted()
            .map(number -> number.num + "")
            .collect(Collectors.joining());
        if (result.charAt(0) == '0') {
            return "0";
        } else {
            return result;
        }
    }
    
    class MyNum implements Comparable<MyNum> {
        int num;
        public MyNum(int num) {
            this.num = num;
        }
        
        @Override
        public int compareTo(MyNum other) {
            String s1 = this.num + "";
            String s2 = other.num + "";
            
            return -(s1 + s2).compareTo(s2 + s1);
        }
    }
}