package D2;

import java.util.Scanner;
import java.io.FileInputStream;

class P21425 {
    public static void main(String args[]) throws Exception {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int test_case = 1; test_case <= T; test_case++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int n = sc.nextInt();
            int count = 1;
            while(true) {
                if(x < y) {
                    x += y;
                } else {
                    y += x;
                }

                if(x > n || y > n) break;
                else count++;
            }

            System.out.println(count);
        }
    }
}
