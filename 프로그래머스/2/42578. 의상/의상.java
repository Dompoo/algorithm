import java.util.*;
class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> map = new HashMap<>();
        for (String[] clothe : clothes) {
            String type = clothe[1];
            map.merge(type, 1, Integer::sum);
        }
        Integer result = map.entrySet().stream()
                .map(entry -> entry.getValue() + 1)
                .reduce(1, (a, b) -> a * b);
        return result - 1;
    }
}