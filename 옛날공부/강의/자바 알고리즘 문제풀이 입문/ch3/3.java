import java.util.*;

class Main {

    public int solution(int N, int combo, int[] arr) {
        int start = 0;
        for(int i = 0; i < combo; i++) {
            start += arr[i];
        }

        int[] maxs = new int[N - combo + 1];
        maxs[0] = start;
        
        for(int i = 1; i <= N - combo; i++) {
            // 시작이 i일때
            // 빠지는건 i-1
            // 추가되는건 i + combo - 1
            maxs[i] = maxs[i - 1] - arr[i - 1] + arr[i + combo - 1];
        }

        int result = Integer.MIN_VALUE;
        for(int i = 0; i < N - combo + 1; i++) {
            result = Math.max(maxs[i], result);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int combo = sc.nextInt();
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }
        Main T = new Main();
        int result = T.solution(N, combo, arr);
        System.out.println(result);
    }
}