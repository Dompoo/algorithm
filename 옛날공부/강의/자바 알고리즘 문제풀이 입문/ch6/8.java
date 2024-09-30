import java.util.*;

class Main {

    //이분 검색
    public int solution(int size, int target, int[] arr) {

        Arrays.sort(arr);
        
        int left = 0;
        int right = size - 1;
        int result = -1;

        while(left <= right) {
            int mid = (left + right) / 2;
            if(arr[mid] == target) {
                result = mid;
                break;
            } else if(arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return result + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new Main().solution(size, target, arr));
    }
}