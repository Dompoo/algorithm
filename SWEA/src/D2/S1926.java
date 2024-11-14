package D2;

import java.util.*;

public class S1926 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= target; i++) {
            sb.append(samyookgu(i));
            if (i != target) {
                sb.append(" ");
            }
        }
        System.out.print(sb);
    }

    private static String samyookgu(final int number) {
        String input = String.valueOf(number);

        int samyookguCount = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '3' || c == '6' || c == '9') {
                samyookguCount++;
            }
        }

        if (samyookguCount == 0) {
            return String.valueOf(number);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = 0 ; i < samyookguCount; i++ ) {
                sb.append("-");
            }
            return sb.toString();
        }
    }
}
