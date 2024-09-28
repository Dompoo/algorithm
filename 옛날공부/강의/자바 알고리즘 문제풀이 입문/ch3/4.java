import java.util.*;

class Main {

    public int solution(int size, int target, int[] arr) {
        int left = 0;
        int right = 0;
        int result = 0;
        int currSum = 0;
        while(right < size) {
            currSum += arr[right];

            while(currSum > target && left <= right) {
                currSum -= arr[left++];
            }

            if(currSum == target) result++;

            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0 ; i < size ; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println(new Main().solution(size, target, arr));
    }
}