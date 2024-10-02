import java.util.*;

class Main {

    public int solution(int size, int[] coinType, int target) {
        int[] dp = new int[target + 1];
        for(int i = 1; i <= target; i++) dp[i] = Integer.MAX_VALUE;

        for(int i = 1; i <= target; i++) {
            for(int coin : coinType) {
                if(i - coin < 0) break;
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }

        return dp[target];
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] coinType = new int[size];
        for(int i = 0; i < size; i++) {
            coinType[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(new Main().solution(size, coinType, target));
    }
}