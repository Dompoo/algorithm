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

    public int solution(int size, int[][] input) {
        int[] adds = new int[size * 2 + 2]; //가로 + 세로 + 대각선2;

        int result = Integer.MIN_VALUE;
        //가로 다 더하기
        for(int i = 0; i < size; i++) {
            int garo = 0;
            int sero = 0;
            for(int j = 0; j < size; j++) {
                garo += input[i][j];
                sero += input[j][i];
            }
            result = Math.max(result, garo);
            result = Math.max(result, sero);
        }

        int degak1 = 0;
        int degak2 = 0;
        for(int i = 0; i < size; i++) {
            degak1 += input[i][i];
            degak2 += input[size - i - 1][i];
        }

        result = Math.max(result, degak1);
        result = Math.max(result, degak2);

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Main T = new Main();
        int result = T.solution(N, arr);
        System.out.println(result);
    }
}