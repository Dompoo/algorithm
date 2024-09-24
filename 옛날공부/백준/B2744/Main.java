package B2744;

import java.util.Scanner;

public class Main {
    static String str;
    static String ans = "";

    public static void input() {
        Scanner sc = new Scanner(System.in);
        str = sc.next();
    }

    public static void solve() {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if ('a' <= ch && ch <= 'z') {
                ans += Character.toUpperCase(ch);
            } else if ('A' <= ch && ch <= 'Z') {
                ans += Character.toLowerCase(ch);
            }
        }
    }

    public static void output() {
        System.out.println(ans);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
