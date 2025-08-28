import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N * N];
        String[] inputs = null;
        int count = 0;
        for (int i = 0; i < N; i++) {
            inputs = br.readLine().split(" ");
            for (int j = 0; j < N; j++) {
                arr[count++] = Integer.parseInt(inputs[j]);
            }
        }

        Arrays.sort(arr);

        System.out.println(arr[N * N - N]);
    }
}
