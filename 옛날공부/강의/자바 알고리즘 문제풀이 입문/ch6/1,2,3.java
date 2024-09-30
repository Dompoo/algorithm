import java.util.*;

class Main {

    public String insertionSort(int size, int[] arr) {
        // 6
        // 11 7 5 6 10 9
        // 

        int[] resultArr = new int[size];

        for(int i = 0; i < size; i++) {
            // arr[i]의 넣어야할 index를 찾음
            int currElement = arr[i];
            int insertIndex = 0;
            for(int j = 0; j < size; j++) {
                if(arr[j] < currElement) insertIndex++;
            }
            for(int k = insertIndex; k < size; k++) {
                if(resultArr[k] == 0) {
                    resultArr[k] = currElement;
                    break;
                }
            }
        }

        String result = "";
        for(int i = 0; i < size; i++) {
            result += resultArr[i];
            if(i != size - 1) {
                result += " ";
            }
        }
        return result;
    }

    public String bubbleSort(int size, int[] arr) {
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                if(arr[i] < arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        String result = "";
        for(int i = 0; i < size; i++) {
            result += arr[i];
            if(i != size - 1) {
                result += " ";
            }
        }
        return result;
    }

    public String selectionSort(int size, int[] arr) {
        int currIndex = 0;

        for(int i = 0; i < size; i++) {

            int minIndex = currIndex;
            int minValue = Integer.MAX_VALUE;

            //최소값의 index 찾기
            for(int k = currIndex; k < size; k++) {
                if(minValue >= arr[k]) {
                    minValue = arr[k];
                    minIndex = k;
                }
            }

            //최소값과 현재 위치 수정하기
            int tmp = arr[currIndex];
            arr[currIndex] = arr[minIndex];
            arr[minIndex] = tmp;

            //다음 위치로 이동하기
            currIndex++;
        }

        String result = "";
        for(int i = 0; i < size; i++) {
            result += arr[i];
            if(i != size - 1) {
                result += " ";
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new Main().insertionSort(size, arr));
    }
}