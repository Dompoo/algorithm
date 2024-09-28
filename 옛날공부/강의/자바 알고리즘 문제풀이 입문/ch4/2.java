import java.util.*;

class Main {

    public String solution(String str1, String str2) {
        int[] str1Num = new int[52];
        int[] str2Num = new int[52];
        //0 ~ 25 a ~ z
        //26 ~ 51 A ~ Z

        for(char ch : str1.toCharArray()) {
            if('a' <= ch && ch <= 'z') {
                str1Num[ch - 'a']++;
            } else {
                str1Num[ch - 'A' + 26]++;
            }
        }

        for(char ch : str2.toCharArray()) {
            if('a' <= ch && ch <= 'z') {
                str2Num[ch - 'a']++;
            } else {
                str2Num[ch - 'A' + 26]++;
            }
        }

        boolean isSame = true;
        for(int i = 0; i < 52; i++) {
            if(str1Num[i] != str2Num[i]) {
                isSame = false;
                break;
            }
        }

        if(isSame) return "YES";
        else return "NO";
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(new Main().solution(str1, str2));
    }
}