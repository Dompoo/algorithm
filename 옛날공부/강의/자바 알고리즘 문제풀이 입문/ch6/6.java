import java.util.*;

class Main {

    public String solution(int size, int[] arr) {
        int[] sortArr = new int[size];
        for(int i = 0; i < size; i++) {
            sortArr[i] = arr[i];
        }
        Arrays.sort(sortArr);

        int chul = -1;
        int zzak = -1;

        for(int i = 0; i < size; i++) {
            if(arr[i] != sortArr[i] && chul == -1) {
                chul = i;
            } else if(arr[i] != sortArr[i] && chul != -1) {
                zzak = i;
                break;
            }
        }

        return (chul + 1) + " " + (zzak + 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new Main().solution(size, arr));
    }
}