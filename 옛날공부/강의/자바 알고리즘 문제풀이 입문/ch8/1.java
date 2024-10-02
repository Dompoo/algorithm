import java.util.*;

class Main {

    public boolean dfs(int length, int sum, int[] arr, int total) {
        if(length == arr.length) {
            return sum == total - sum; //나머지와 현재 합이 같다면 true
        }

        if(dfs(length + 1, sum + arr[length], arr, total)) {
            return true;
        }

        if(dfs(length + 1, sum, arr, total)) {
            return true;
        }

        return false;
    }

    public String solution(int size, int[] arr) {
        int total = 0;
        for(int element : arr) total += element;

        if(dfs(0, 0, arr, total)) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int[] arr = new int[size];
        for(int i = 0; i < size; i++) {
            arr[i] = sc.nextInt();
        }
        boolean[] isChecked = new boolean[size];
        System.out.println(new Main().solution(size, arr));
    }
}