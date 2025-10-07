import java.util.*;
import java.util.Set;

class Solution {

    int size;
    String nums;
    Set<Integer> candinates = new HashSet<>();

    public int solution(String numbers) {
        size = numbers.length();
        nums = numbers;
        dfs(new boolean[size], new char[size], 0);
        int result = 0;
        for (Integer candinate : candinates) {
            if (isPrime(candinate)) result++;
        }
        return result;
    }

    public void dfs(boolean[] visited, char[] current, int curSize) {
        if (curSize == size) {
            for (int subSize = 1; subSize <= size; subSize++) {
                char[] newChar = new char[subSize];
                for (int i = 0; i + subSize <= size; i++) {
                    System.arraycopy(current, i, newChar, 0, subSize);
                    String value = String.valueOf(newChar);
                    int target = Integer.parseInt(value);
                    candinates.add(target);
                }
            }
            return;
        }

        for (int i = 0; i < size; i++) {
            if (visited[i]) continue;

            visited[i] = true;
            current[curSize] = nums.charAt(i);
            dfs(visited, current, curSize + 1);
            visited[i] = false;
        }
    }

    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        // 1과 자기자신으로만 나뉘는 수
        for (double i = 2; i * i <= num; i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
