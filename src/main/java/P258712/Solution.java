package P258712;

import java.util.ArrayList;

public class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int maxTime = attacks[attacks.length - 1][0];

        ArrayList<Integer>[] dp = new ArrayList[maxTime + 1];
        for(int i = 0; i <= maxTime; i++) {
            dp[i] = new ArrayList<>();
        }

        dp[0].add(0); //연속회복
        dp[0].add(health); //체력

        int attackIdx = 0;
        int nextAttackTime = attacks[0][0];

        for(int t = 1; t <= maxTime; t++) {
            int curHp = dp[t-1].get(1);
            if(nextAttackTime == t) { //공격당하는 상황
                curHp -= attacks[attackIdx++][1];
                if(curHp <= 0) return -1; //사망
                dp[t].add(0);
                dp[t].add(Math.min(curHp, health));
                if(attackIdx >= attacks.length) break;
                nextAttackTime = attacks[attackIdx][0];
            } else { //공격당하지 않는 상황
                curHp += bandage[1]; //초당 회복
                int plusTime = dp[t-1].get(0) + 1;
                if(plusTime == bandage[0]) {
                    curHp += bandage[2]; //완료 회복
                }
                dp[t].add(plusTime % bandage[0]);
                dp[t].add(Math.min(curHp, health));
            }
        }

        return dp[maxTime].get(1);
    }
}
