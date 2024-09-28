import java.util.*;

class Main {

/*
14 2
1 1 0 0 1 1 0 1 1 0 1 1 0 1
-> 
0 1 1 0 0 1 1 0 1 1 0 1 1 0 1 0
l             r -> 0 7
      l             r -> 3 10
        l                 r -> 4 13
              l               r -> 7 15
                    l         r -> 
*/

    public int solution(int size, int k, int[] arr) {
        int left = 0;
        int right = 0;

        int currK = 0;
        for(int i = 0; i < size; i++) {
            if(arr[i] == 0) {
                right = i;
                currK++;
            }
            if(currK == k + 1) break;
        }

        int result = 0;
        while(right < size && left < right) {

            int curSize = right - left - 1;
            result = Math.max(result, curSize);

            System.out.println(left + " " + right + " 길이 : " + curSize + " 최대 : " + result);

            //l, r을 다음으로 이동하기
            for(int i = right + 1; i < size; i++) {
                if(arr[i] == 0) {
                    right = i;
                    break;
                }
            }
            for(int i = left + 1; i < size; i++) {
                if(arr[i] == 0) {
                    left = i;
                    break;
                }
            }
        } 

        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] arr = new int[size + 2];
        int k = sc.nextInt();
        for (int i = 1; i <= size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new Main().solution(size + 2, k + 1, arr));
    }
}