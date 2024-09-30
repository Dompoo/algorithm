import java.util.*;

class Main {

    public char solution(int size, int[] arr) {
        Arrays.sort(arr);
        int lastNumber = arr[0];

        char result = 'U';
        for(int i = 1; i < size; i++) {
            if(lastNumber == arr[i]) {
                result = 'D';
                break;
            }
            lastNumber = arr[i];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new Main().solution(arrSize, arr));
    }
}