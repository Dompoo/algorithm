import java.util.*;

class Main {

    public String solution(int[] arr1, int arr1Size, int[] arr2, int arr2Size) {
        
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int arr1Index = 0;
        int arr2Index = 0;
        List<Integer> resultArr = new ArrayList<>();

        while(arr1Index < arr1Size && arr2Index < arr2Size) {
            if(arr1[arr1Index] < arr2[arr2Index]) {
                arr1Index++;
            } else if(arr1[arr1Index] > arr2[arr2Index]){
                arr2Index++;
            } else {
                resultArr.add(arr1[arr1Index]);
                arr1Index++;
                arr2Index++;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < resultArr.size(); i++) {
            sb.append(resultArr.get(i));
            if(i != resultArr.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
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