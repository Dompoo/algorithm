import java.util.*;
class Solution {
    public int[] solution(int[] answers) {
        int score1 = 0;
        int score2 = 0;
        int score3 = 0;
        for(int i = 0; i < answers.length; i++) {
            int answer = answers[i];
            if (is1Correct(i, answer)) score1++;
            if (is2Correct(i, answer)) score2++;
            if (is3Correct(i, answer)) score3++;
        }
        int maxScore = Math.max(score1, Math.max(score2, score3));
        List<Integer> maxes = new ArrayList<>();
        if(score1 == maxScore) maxes.add(1);
        if(score2 == maxScore) maxes.add(2);
        if(score3 == maxScore) maxes.add(3);
        
        int[] result = new int[maxes.size()];
        int index = 0;
        for(int r : maxes) {
            result[index++] = r;
        }
        return result;
    }
    
    public static boolean is1Correct(int num, int answer) {
        // 12345 12345
        return (num % 5) + 1 == answer;
    }
    public static boolean is2Correct(int num, int answer) {
        // 2 123 2 425 2 123 2 425
        // 0     1     2     3
        if (num % 4 == 0 && answer == 2) return true;
        else if ((num / 4) % 2 == 0) {
            if ((num % 4) == 1 && answer == 1) return true;
            else if ((num % 4) == 2 && answer == 2) return true;
            else if ((num % 4) == 3 && answer == 3) return true;
        }
        else {
            if ((num % 4) == 1 && answer == 4) return true;
            else if ((num % 4) == 2 && answer == 2) return true;
            else if ((num % 4) == 3 && answer == 5) return true;
        }
        return false;
    }
    public static boolean is3Correct(int num, int answer) {
        // 01 23 45 67 89
        // /2
        // 00 11 22 33 44 55 66 77 88 99
        // %5
        // 0  1  2  3  4  0 1 2 3 4
        // 33 11 22 44 55
        int a = (num / 2) % 5;
        if (a == 0 && answer == 3) return true;
        else if (a == 1 && answer == 1) return true;
        else if (a == 2 && answer == 2) return true;
        else if (a == 3 && answer == 4) return true;
        else if (a == 4 && answer == 5) return true;
        return false;
    }
}