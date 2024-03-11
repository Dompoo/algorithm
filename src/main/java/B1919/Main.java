package B1919;

import java.util.Scanner;

public class Main {
    static String str1;
    static String str2;
    static int[] str1Arr = new int[26];
    static int[] str2Arr = new int[26];
    static int diff = 0;

    public static void input() {
        Scanner sc = new Scanner(System.in);
        str1 = sc.next();
        str2 = sc.next();
    }

    public static void solve() {
        for (int i = 0; i < str1.length(); i++) {
            char ch = str1.charAt(i);
            str1Arr[ch - 'a']++;
        }
        for (int i = 0; i < str2.length(); i++) {
            char ch = str2.charAt(i);
            str2Arr[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            diff += Math.abs(str1Arr[i] - str2Arr[i]);
        }
    }

    public static void output() {
        System.out.println(diff);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
