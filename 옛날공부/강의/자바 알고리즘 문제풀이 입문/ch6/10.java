import java.util.*;

class Main {

    public static int horse;
    public static int size;
    public static int[] arr;
    // public boolean[] isHorseExist;
    // public int max = Integer.MIN_VALUE;

    public int solution() {
        int result = 0;
        Arrays.sort(arr);
        int left = Integer.MAX_VALUE; // 말들의 거리 최소값
        int right = arr[size - 1] - arr[0]; // 말들의 거리 최대값

        for(int i = 1; i < size; i++) {
            left = Math.min(left, arr[i] - arr[i - 1]);
        }

        while(left <= right) {
            int mid = (left + right) / 2; //목표 최소치

            //mid 가능성 여부 확인
            int horseCount = 1;
            int lastHorseIndex = 0;
            for(int i = 1; i < size; i++) {
                if((arr[i] - arr[lastHorseIndex]) >= mid) {
                    //두 말의 거리가 목표 최소치를 넘어가면
                    lastHorseIndex = i;
                    horseCount++;
                }
            }

            if(horseCount >= horse) {
                // 목표치를 키워본다.
                left = mid + 1;
                result = mid;
            } else {
                // 불가능하다면
                right = mid - 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        horse = sc.nextInt();
        arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new Main().solution());
    }

    // public void dfs(int curHorse) {
    //     if(curHorse == horse) {
    //         int lastHorseIndex = 0;
    //         int curMin = Integer.MAX_VALUE;
    //         for(int i = 1; i < size; i++) {
    //             if(isHorseExist[i]) {
    //                 curMin = Math.min(curMin, arr[i] - arr[lastHorseIndex]);
    //                 lastHorseIndex = i;
    //             }
    //         }
    //         max = Math.max(max, curMin);
    //         return;
    //     } else {
    //         for(int i = 0; i < size; i++) {
    //             if(!isHorseExist[i]) {
    //                 isHorseExist[i] = true;
    //                 dfs(curHorse + 1);
    //                 isHorseExist[i] = false;
    //             }
    //         }
    //     }
    // }

    // DFS -> 시간 초과
    // public int solution2() {
    //     Arrays.sort(arr);
    //     isHorseExist = new boolean[size];
    //     isHorseExist[0] = true;
    //     isHorseExist[size - 1] = true;
    //     dfs(2);
    //     return max;
    // }
}
