import java.util.*;

class Main {

    public int solution(int target) {
        int currSum = 0;
        int left = 0;
        int right = 0;
        int result = 0;

        while(right < target) {
            currSum += right;

            while(currSum > target && left <= right) {
                currSum -= left++;
            }

            if(currSum == target) {
                result++;
            }
            
            right++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();

        System.out.println(new Main().solution(target));
    }
}