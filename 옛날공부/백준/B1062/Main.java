package B1062;

import java.util.Scanner;

public class Main {
    static int[] bitmask;
    static int maxWord = 0;
    static int wordNum;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        wordNum = sc.nextInt();
        int alpNum = sc.nextInt();

        bitmask = new int[wordNum];

        for (int i = 0; i < wordNum; i++) {
            setMask(sc.next(), i);
        }

        DFS(alpNum, 0, 0);

        System.out.println(maxWord);
    }

    public static void setMask(String str, int index) {
        for (char ch : str.toCharArray()) {
            if ('a' <= ch && ch <= 'z') {
                int bit = ch - 'a';
                bitmask[index] |= (1 << bit);
            }
        }
    }

    public static void DFS(int alpNum, int curNum, int selected) {
        if (alpNum <= 0) {
            int currentMaxWord = 0;

            for (int i = 0; i < wordNum; i++) {
                if ((bitmask[i] & selected) == bitmask[i]) {
                    currentMaxWord++;
                }
            }

            maxWord = Math.max(maxWord, currentMaxWord);
            return;
        }

        //다음 알파벳을 고르고 DFS
        for (int i = curNum; i < 26; i++) {
            DFS(alpNum - 1, i + 1, selected | (1 << i));
        }
    }
}

