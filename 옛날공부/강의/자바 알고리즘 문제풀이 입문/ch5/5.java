/*
( -> 쇠막대기 + 1
() -> 자르기, 현재 콤보 만큼 조각 추가
) -> 쇠막대기 - 1, 조각 1개 추가
*/

import java.util.*;

class Main {

    public int solution(String input) {
        char[] arr = input.toCharArray();
        int combo = 0;
        int index = 0;
        int result = 0;
        while(index < input.length()) {
            if(arr[index] == '(') {
                if(arr[index + 1] == ')') {
                    //레이저
                    result += combo;
                    index += 2;
                } else {
                    //막대기 시작
                    combo++;
                    index++;
                }
            } else {
                //막대기 끝
                result++;
                index++;
                combo--;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String input = sc.next();
        System.out.println(new Main().solution(input));
    }
}

/*
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21
( ) ( ( ( ( ) ( ) ) (  (  )  )  (  )  )  )  (  (  )  )

*/