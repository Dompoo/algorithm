import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
쇠막대기 개수를 카운팅하다가
레이저 -> 쇠막대기 개수만큼 +N
쇠막대기 줄어듬 -> 쇠막대기 끝나니까 +1


((( () ( ()() )) (()) () )) (()())

+3+4+4+1+1+3+1+2+1+1+1+1+1
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] inputs = br.readLine().toCharArray();

        int result = 0;
        int akreorlCount = 0;
        for (int i = 0; i < inputs.length; i++) {
            char input = inputs[i];
            if (input == '(') {
                if (inputs[i + 1] == ')') {
                    //레이저
                    result += akreorlCount;
                } else {
                    //쇠막대기 시작
                    akreorlCount++;
                }
            } else if (input == ')') {
                if (inputs[i - 1] == '(') {
                    //레이저
                } else {
                    //쇠막대기 끝
                    akreorlCount--;
                    result++;
                }
            }
        }
        System.out.print(result);
    }
}
