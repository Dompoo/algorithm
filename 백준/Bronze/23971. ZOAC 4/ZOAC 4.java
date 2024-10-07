import java.util.*;

class Main {

    public int solution(int h, int w, int n, int m) {
        // h의 경우
        // - - - - - - - - ...
        // n이 3이면 4로 나눈 몫 + 나머지가 있다면 +1 으로 앉을 수 있음
        // t - - - t - - - t ...
        int toH = (h / (n + 1)) + (h % (n + 1) == 0 ? 0 : 1);
        int toW = (w / (m + 1)) + (w % (m + 1) == 0 ? 0 : 1);
        return toH * toW;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int h = sc.nextInt();
        int w = sc.nextInt();
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(new Main().solution(h, w, n, m));
    }
}