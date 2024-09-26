import java.util.*;

class Main {

    //1:가위, 2:바위, 3:보
    public char rpc(int a, int b) {
        if(a == 1 && b == 3) {
            return 'A';
        } else if(a == 3 && b == 1) {
            return 'B';
        } else {
            if(a < b) return 'B';
            if(a > b) return 'A';
        }
        return 'D';
    }


    public char[] solution(int size, int[] a, int[] b) {
        char[] result = new char[size];

        for(int i = 0; i < size; i++) {
            result[i] = rpc(a[i], b[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] a = new int[size];
        int[] b = new int[size];

        for(int i = 0; i < size; i++) {
            a[i] = sc.nextInt();
        }
        for(int i = 0; i < size; i++) {
            b[i] = sc.nextInt();
        }

        Main T = new Main();
        char[] result = T.solution(size, a, b);

        for(int i = 0; i < size; i++) {
            System.out.print(result[i]);
            if(i != size - 1) System.out.println();
        }
    }
}