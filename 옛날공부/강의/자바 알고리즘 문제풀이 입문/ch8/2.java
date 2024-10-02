import java.util.*;

class Main {

    public int dfs(int currentTotal, int index, int total, int size, int[] arr) {
        if(currentTotal > total) return 0;

        if(index == size) {
            return currentTotal;
        }

        int select = dfs(currentTotal + arr[index], index + 1, total, size, arr); // 선택한 경우
        int notSelect = dfs(currentTotal, index + 1, total, size, arr); // 선택하지 않은 경우

        return Math.max(select, notSelect);
    }

    public int solution(int total, int size, int[] arr) {
        return dfs(0, 0, total, size, arr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int total = sc.nextInt();
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new Main().solution(total, size, arr));
    }
}