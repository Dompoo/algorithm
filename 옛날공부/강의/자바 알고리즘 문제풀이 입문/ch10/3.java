import java.util.*;

class Main {

    public static int size;
    public static int[] arr;
    // public int maxLength = Integer.MIN_VALUE;

    public int solution() {
        int[] dp = new int[size];

        for(int i = 0; i < size; i++) {
            int maxLen = 1;
            for(int j = i - 1; j >= 0; j--) {
                if(arr[i] > arr[j]) {
                    maxLen = Math.max(maxLen, dp[j] + 1);
                }
            }
            dp[i] = maxLen;
        }

        int result = 0;
        for(int i = 0; i < size; i++) {
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    
    /* dfs 시간초과
    public void dfs(int index, int curMax, int curLength) {
        if(index == size) {
            maxLength = Math.max(curLength, maxLength);
        } else if(maxLength > size - index + curLength) {
            // 추가할 가치가 없어지는 순간
            return;
        } else {
            if(arr[index] > curMax) {
                // 선택가능
                dfs(index + 1, arr[index], curLength + 1);
                dfs(index + 1, curMax, curLength);
            } else {
                dfs(index + 1, curMax, curLength);
            }
        }
    }
    public int solution() {
        dfs(0, Integer.MIN_VALUE, 0);
        return maxLength;
    }
    */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new Main().solution());
    }
}