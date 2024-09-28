import java.util.*;

class Main {

    public int getIndex(char ch) {
        if('a' <= ch && ch <= 'z') return ch - 'a';
        else return ch - 'A' + 26;
    }

    public boolean isAnagram(int[] curr, int[] target) {
        for(int i = 0 ; i < 52 ; i++) {
            if(curr[i] != target[i]) return false;
        }
        return true;
    }

    public int solution(String str, String target) {
        int windowSize = target.length();
        int strSize = str.length();
        char[] targetArray = target.toCharArray();
        char[] currArray = str.toCharArray();

        int[] targetNum = new int[52];
        int[] currNum = new int[52];

        for(int i = 0 ; i < windowSize ; i++) {
            targetNum[getIndex(targetArray[i])]++;
        }

        for(int i = 0 ; i < windowSize ; i++) {
            currNum[getIndex(currArray[i])]++;
        }

        int start = 0;
        int last = windowSize - 1;
        int result = 0;
        while(last < strSize) {
            if(isAnagram(currNum, targetNum)) result++;

            currNum[getIndex(currArray[start])]--;
            if(last + 1 < strSize) currNum[getIndex(currArray[last + 1])]++;

            start++;
            last++;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        String target = sc.next();
        System.out.println(new Main().solution(str, target));
    }
}