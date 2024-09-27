import java.util.*;
import java.util.stream.*;

class Main {

    public String solution(int[] arr1, int arr1Size, int[] arr2, int arr2Size) {
        int arr1Index = 0;
        int arr2Index = 0;
        List<Integer> resultArr = new ArrayList<>();

        while(arr1Index < arr1Size && arr2Index < arr2Size) {
            if(arr1[arr1Index] < arr2[arr2Index]) {
                resultArr.add(arr1[arr1Index++]);
            } else {
                resultArr.add(arr2[arr2Index++]);
            }
        }

        //남은 부분 넣어주기
        if(arr2Index == arr2Size) {
            for(int i = arr1Index; i < arr1Size; i++) {
                resultArr.add(arr1[i]);
            }
        }
        if(arr1Index == arr1Size) {
            for(int i = arr2Index; i < arr2Size; i++) {
                resultArr.add(arr2[i]);
            }
        }

        return String.join(" ", resultArr.stream().map(value -> String.valueOf(value)).collect(Collectors.toList()));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int arr1Size = sc.nextInt();
        int[] arr1 = new int[arr1Size];
        for(int i = 0 ; i < arr1Size; i++) {
            arr1[i] = sc.nextInt();
        }

        int arr2Size = sc.nextInt();
        int[] arr2 = new int[arr2Size];
        for(int i = 0 ; i < arr2Size; i++) {
            arr2[i] = sc.nextInt();
        }

        Main T = new Main();
        String result = T.solution(arr1, arr1Size, arr2, arr2Size);
        System.out.println(result);
    }
}