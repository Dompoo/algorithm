package B1157;

import java.util.Scanner;

public class Main {
    static String str;
    static int[] ratio = new int[26];
    static char maxCh;

    public static void input() {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
    }

    public static void solve() {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                ratio[ch - 'a']++;
            } else if ('A' <= ch && ch <= 'Z') {
                ratio[ch - 'A']++;
            }
        }

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < 26; i++) {
            if (ratio[i] > max) {
                max = ratio[i];
                maxCh = (char) (i + 'A');
            } else if (ratio[i] == max) {
                maxCh = '?';
            }
        }
    }

    public static void output() {
        System.out.println(maxCh);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
