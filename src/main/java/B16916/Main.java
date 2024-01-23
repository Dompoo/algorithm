package B16916;

import java.util.Scanner;

public class Main {
    static int[] affix;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean isSub = false;
        char[] str = sc.next().toCharArray();
        char[] subStr = sc.next().toCharArray();
        affix = new int[subStr.length];

        setAffix(subStr);

        for (int i = 0; i < str.length; ) {
            int j;

            for (j = 0; j < subStr.length && i < str.length; ) {
                if (str[i] == subStr[j]) {
                    i++;
                    j++;
                } else {
                    //같지 않을 경우
                    if (j == 0) {
                        i++;
                        break;
                    } else {
                        j = affix[j - 1];
                    }
                }
            }

            if (j == subStr.length) {
                isSub = true;
                break;
            }
        }

        if (isSub) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static void setAffix(char[] str) {
        int j = 0;

        for (int i = 1; i < str.length; i++) {
            while (j > 0 && str[i] != str[j]) {
                j = affix[j - 1];
            }
            if (str[i] == str[j]) {
                affix[i] = ++j;
            }
        }
    }
}
