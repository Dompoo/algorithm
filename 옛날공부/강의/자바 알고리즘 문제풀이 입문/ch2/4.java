import java.util.*;

class Main {

    public int[] solution(int size) {
        int[] result = new int[size];

        result[0] = 1;
        result[1] = 1;

        for(int i = 2; i < size; i++) {
            result[i] = result[i - 2] + result[i - 1];
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();

        Main T = new Main();
        int[] result = T.solution(size);

        for(int i = 0; i < size; i++) {
            System.out.print(result[i]);
            if(i != size - 1) System.out.print(" ");
        }
    }
}