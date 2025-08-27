import java.util.*;

class Solution {
    public String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();
        for (String par : participant) {
            if (map.get(par) == null) {
                map.put(par, 1);
            } else {
                map.put(par, map.get(par) + 1);
            }
        }
        for (String com : completion) {
            map.put(com, map.get(com) - 1);
        }
        
        return map.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .orElseThrow();
    }
}