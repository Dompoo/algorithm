package B13223;

import java.util.Scanner;

public class Main {
    static int currSec;
    static int dropSec;

    static int needHour;
    static int needMin;
    static int needSec;

    public static void input() {
        Scanner sc = new Scanner(System.in);
        String timeCurr = sc.nextLine();
        String timeDrop = sc.nextLine();

        String[] curr = timeCurr.split(":");
        int currH = Integer.parseInt(curr[0]);
        int currM = Integer.parseInt(curr[1]);
        int currS = Integer.parseInt(curr[2]);
        currSec = currH * 3600 + currM * 60 + currS;

        String[] drop = timeDrop.split(":");
        int dropH = Integer.parseInt(drop[0]);
        int dropM = Integer.parseInt(drop[1]);
        int dropS = Integer.parseInt(drop[2]);
        dropSec = dropH * 3600 + dropM * 60 + dropS;
    }

    public static void solve() {
        int diff = dropSec - currSec;
        if (diff <= 0) {
            diff += 24 * 3600;
        }
        needHour = diff / 3600;
        needMin = (diff % 3600) / 60;
        needSec = diff % 60;
    }

    public static void output(){
        System.out.printf("%02d:%02d:%02d\n", needHour, needMin, needSec);
    }

    public static void main(String[] args) {
        input();
        solve();
        output();
    }
}
