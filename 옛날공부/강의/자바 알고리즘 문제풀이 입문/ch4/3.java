import java.util.*;

class Main {

    public String solution(int size, int k, int[] arr) {
        int maxElement = 0;

        for(int num : arr) {
            maxElement = Math.max(maxElement, num);
        }

        int[] number = new int[maxElement + 1];
        
        for (int i = 0; i < k; i++) {
            number[arr[i]]++;
        }
        
        int currResult = 0;
        for (int i = 0; i < maxElement + 1; i++) {
            if (number[i] > 0) currResult++;
        }
        
        StringBuilder sb = new StringBuilder();

        int first = 0;
        int last = k - 1;
        while(last < size) {
            sb.append(currResult);
            if(last != size - 1) sb.append(" ");

            //현재 있는 것 삭제
            number[arr[first]]--;
            if(number[arr[first]] == 0) currResult--;

            //앞으로 생기는 것 추가
            if(last + 1 < size) {
                if(number[arr[last + 1]] == 0) currResult++;
                number[arr[last + 1]]++;
            }
            first++;
            last++;
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int size = sc.nextInt();
        int k = sc.nextInt();
        
        int[] arr = new int[size];
        
        for (int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        
        System.out.println(new Main().solution(size, k, arr));
    }
}