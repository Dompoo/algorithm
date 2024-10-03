import java.util.*;

class Main {

    public int solution(int size, int dvd, int[] arr) {

        int left = 0; //arr 중 최대값
        int right = 0; //arr 전체 합

        for(int i = 0; i < size; i++) {
            left = Math.max(left, arr[i]);
            right += arr[i];
        }

        int result = 0;

        while(left <= right) {
            int mid = (left + right) / 2;

            int count = 1;
            int curr = 0;
            for(int i = 0; i < size; i++) {
                if(curr + arr[i] <= mid) {
                    curr += arr[i];
                } else {
                    count++;
                    curr = arr[i];
                }
            }

            if(count <= dvd) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int dvd = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new Main().solution(size, dvd, arr));
    }
}