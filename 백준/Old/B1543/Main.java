package B1543;

import java.util.Scanner;

public class Main {
    static String doc;
    static String word;
    static int ratio = 0;

    public static void input() {
        Scanner sc = new Scanner(System.in);
        doc = sc.nextLine();
        word = sc.nextLine();
    }

    public static void solve() {
        for (int i = 0; i <= doc.length() - word.length();) {
            if (correct(i)) {
                ratio++;
                i += word.length();
            } else {
                i++;
            }
        }
    }

    public static boolean correct(int index) {
        boolean isSame = true;
        for (int i = 0; i < word.length(); i++) {
            if (doc.charAt(index++) != word.charAt(i)) {
                isSame = false;
                break;
            }
        }
        return isSame;
    }

    public static void output() {
        System.out.println(ratio);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
