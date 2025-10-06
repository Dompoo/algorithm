import java.util.*;
class Solution {
    public int solution(int[] input) {
        Arrays.sort(input);
        for (int i = 0; i < input.length; i++) {
            int h = input.length - i;  // h편 이상의 논문
            if (input[i] >= h) return h;
        }
        return 0;
    }
}