import java.util.*;

class Main {

    public int solution(int N, int[][] input) {
        boolean[][] isChecked = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            for(int j = 1; j <= 5; j++) {
                for(int k = 0; k < N; k++) {
                    if(input[i][j] == input[k][j] && i != k) {
                        isChecked[i][k] = true;
                    }
                }
            }
        }

        int inssaStuNum = 1;
        int maxSameClassTime = Integer.MIN_VALUE;

        for(int i = 0; i < N; i++) {
            int currSameClassTime = 0;
            for(int j = 0; j < N; j++) {
                if(isChecked[i][j]) currSameClassTime++;
            }
            if(maxSameClassTime < currSameClassTime) {
                inssaStuNum = i;
                maxSameClassTime = currSameClassTime;
            }

        }

        return inssaStuNum + 1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] arr = new int[N][6];

        for(int i = 0; i < N; i++) {
            for(int j = 1; j <= 5; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        Main T = new Main();
        int result = T.solution(N, arr);
        System.out.println(result);
    }
}