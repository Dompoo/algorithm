import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
8
BBRBRBBR

BB R B R BB R

B
R
B
R
B
R
 */
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        char[] chars = br.readLine().toCharArray();

        char last = chars[0];
        int bCount = 0;
        int rCount = 0;
        if (last == 'B') bCount++;
        else rCount++;
        for (int i = 1; i < N; i++) {
            if (last != chars[i]) {
                if (chars[i] == 'B') {
                    bCount++;
                } else {
                    rCount++;
                }
                last = chars[i];
            }
        }
        System.out.println(1 + Math.min(bCount, rCount));
    }
}
