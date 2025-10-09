import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

// https://www.acmicpc.net/problem/3151
@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long result = 0;
        for (int i = 0; i < N - 2; i++) {
            int target = -arr[i];
            int l = i + 1;
            int r = N - 1;

            while (l < r) {
                int curSum = arr[l] + arr[r];
                if (curSum < target) {
                    l++;
                } else if (curSum > target) {
                    r--;
                } else {
                    // 같은값 찾음!

                    if (arr[l] == arr[r]) {
                        // -4 1 2 2 2 2 3 3
                        // i    l     r
                        // 같은거 4개 -> 4C2

                        long m = r - l + 1; // 둘 사이 같은 값의 개수
                        result += m * (m - 1) / 2;
                        break;
                    } else {
                        // -4 1 1 1 2 2 3 3
                        // i  l           r
                        // 같은거 3개 & 같은거 2개 -> 3*2

                        int initL = arr[l];
                        int initR = arr[r];
                        long sameAsL = 0; // l과 같은 개수
                        long sameAsR = 0; // r과 같은 개수
                        while (l < r && arr[l] == initL) {
                            l++;
                            sameAsL++;
                        }
                        while (l <= r && arr[r] == initR) {
                            r--;
                            sameAsR++;
                        }
                        result += sameAsL * sameAsR;
                    }
                }
            }
        }
        System.out.println(result);
    }
}
