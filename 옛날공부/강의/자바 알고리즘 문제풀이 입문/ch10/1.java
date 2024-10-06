import java.util.*;

class Main {

    public int solution(int target) {
        int[] arr = new int[target + 1];
        arr[0] = 1; // 0 에서 출발
        for(int i = 0; i <= target; i++) {
            if(i + 1 <= target) arr[i + 1] += arr[i];
            if(i + 2 <= target) arr[i + 2] += arr[i];
        }

        return arr[target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        System.out.println(new Main().solution(target));
    }
}