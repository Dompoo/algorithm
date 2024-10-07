import java.util.*;

class Main {

    public static int size;
    public static int target;
    public static int[] arr;
    
    public int solution() {
        Arrays.sort(arr);
        int[] dp = new int[target + 1];
        for(int i = 1; i <= target;i ++) {
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 0; i <= target; i++) {
            for(int money : arr) {
                if(i + money <= target && dp[i] != Integer.MAX_VALUE) {
                    dp[i + money] = Math.min(dp[i + money], dp[i] + 1);
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        target = sc.nextInt();
        System.out.println(new Main().solution());
    }
}