package P250137;

public class Solution {
        public int solution(String[] friends, String[] gifts) {
            int n = friends.length;

            int[][] arr = new int[n][n];
            int[] giftIdx = new int[n];

            for(int i = 0; i < gifts.length; i++) {
                String[] friend12 = gifts[i].split(" ");
                int go = getFriendNum(friend12[0], friends);
                int to = getFriendNum(friend12[1], friends);
                arr[go][to]++;
                giftIdx[go] += 1;
                giftIdx[to] -= 1;
            }

            int[] giftNum = new int[n];
            for(int i = 0; i < n; i++) {
                for(int j = i + 1; j < n; j++) {
                    if(arr[i][j] > arr[j][i]) {
                        giftNum[i]++;
                    } else if(arr[i][j] < arr[j][i]) {
                        giftNum[j]++;
                    } else {
                        if(giftIdx[i] > giftIdx[j]) {
                            giftNum[i]++;
                        } else if (giftIdx[i] < giftIdx[j]) {
                            giftNum[j]++;
                        }
                    }
                }
            }

            int max = -1;
            for(int i = 0; i < n; i++) {
                if(giftNum[i] > max) {
                    max = giftNum[i];
                }
            }
            return max;
        }

        public int getFriendNum(String name, String[] frd) {
            for(int i = 0; i < frd.length; i++) {
                if(frd[i].equals(name)) {
                    return i;
                }
            }
            return 0;
        }
}
