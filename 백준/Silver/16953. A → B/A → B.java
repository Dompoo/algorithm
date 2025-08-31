import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*
1은 X2로 만들지 못한다!
 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int result = 1;
        while (true) {
            if (A > B) {
                System.out.println(-1);
                break;
            } else if (A == B) {
                System.out.println(result);
                break;
            } else {
                if (B % 2 == 0) {
                    B /= 2;
                    result++;
                } else if (B % 10 == 1) {
                    B -= 1;
                    B /= 10;
                    result++;
                } else {
                    System.out.println(-1);
                    break;
                }
            }
        }
    }
}
