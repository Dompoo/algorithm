/*
5
10 13 10 12 15
12 39 30 23 11
11 25 50 53 15
19 27 29 37 27
19 13 30 13 19

*/
import java.util.*;

class Main {

    public int solution(int size, int[][] arr) {

        int result = 0;

        for(int i = 1; i <= size; i++) {
            for(int j = 1; j <= size; j++) {
                if(arr[i][j] > arr[i][j - 1] &&
                arr[i][j] > arr[i][j + 1] &&
                arr[i][j] > arr[i - 1][j] &&
                arr[i][j] > arr[i + 1][j]) result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N + 2][N + 2];

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Main T = new Main();
        int result = T.solution(N, arr);
        System.out.println(result);
    }
}