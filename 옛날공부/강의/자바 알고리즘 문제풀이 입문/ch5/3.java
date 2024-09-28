import java.util.*;

class Main {

    public int solution(int size, int[][] arr, int time, int[] move) {
        Stack<Integer> stack = new Stack<>();
        int result = 0;

        for(int curMove : move) {
            boolean noCatch = false;

            //인형 잡기
            for(int i = 0; i < size; i++) {
                if(arr[i][curMove] != 0) {
                    stack.push(Integer.valueOf(arr[i][curMove]));
                    arr[i][curMove] = 0;
                    break;
                }
                if(i == size - 1) noCatch = true;
            }
            if(stack.size() >= 2 && !noCatch) {
                int firstDoll = stack.pop();
                int secondDoll = stack.pop();
                if(firstDoll == secondDoll) {
                    result += 2;
                }
                else {
                    stack.push(secondDoll);
                    stack.push(firstDoll);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[][] arr = new int[size][size];
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < size; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int time = sc.nextInt();
        int[] move = new int[time];
        for(int i = 0; i < time; i++) {
            move[i] = sc.nextInt() - 1;
        }
        System.out.println(new Main().solution(size, arr, time, move));
    }
}