/*
13 15 34 23 45 65 33 11 26 42
3장을 뽑아서 큰 수부터 기록한다.

*/

import java.util.*;

public class Main {

    public int solution(int size, int k, int[] arr) {

        Set<Integer> sumSet = new HashSet<>();

        for(int i = 0 ; i < size - 2; i++) {
            for(int j = i + 1 ; j < size - 1; j++) {
                for(int m = j + 1 ; m < size; m++) {
                    sumSet.add(arr[i] + arr[j] + arr[m]);
                }
            }
        }

        List<Integer> sumList = new ArrayList<>(sumSet);
        sumList.sort(Collections.reverseOrder());

        if(sumList.size() >= k) {
            return sumList.get(k - 1);
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0 ; i < size ; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new Main().solution(size, k, arr));
    }
}