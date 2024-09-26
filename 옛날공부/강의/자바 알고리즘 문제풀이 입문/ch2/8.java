import java.util.*;

class Main {

    public int findIndex(int value, int[] arr, int size) {
        for(int i = 0; i <= size; i++) {
            if(value == arr[i]) return i;
        }
        return -1;
    }

    public String solution(int size, int[] input) {
        int[] sortedInput = Arrays.stream(input)
                    .boxed()  // int를 Integer로 변환
                    .sorted(Collections.reverseOrder())  // 내림차순 정렬
                    .mapToInt(Integer::intValue)  // 다시 int로 변환
                    .toArray();

        String[] resultArr = new String[size];

        for(int i = 0; i < size; i++) {
            resultArr[i] = String.valueOf(findIndex(input[i], sortedInput, size) + 1);
        }

        return String.join(" ", resultArr);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] input = new int[N];
        for(int i = 0 ; i < N; i++) {
            input[i] = sc.nextInt();
        }

        Main T = new Main();
        String result = T.solution(N, input);
        System.out.println(result);
    }
}