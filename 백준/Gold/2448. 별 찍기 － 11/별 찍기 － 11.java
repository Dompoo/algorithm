import java.util.*;
import java.io.*;

/*
입력이 3 * 2^k 일 때

높이 : 3 * 2^k
너비 : 6 * 2^k / 5
 */
class Main {

    public static Character[][] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int level = Integer.parseInt(br.readLine());

        arr = new Character[level][level * 2];
        for (int i = 0; i < level; i++) {
            Arrays.fill(arr[i], ' ');
        }

        makeStars(0, 0, level);

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < level; i++) {
            for (int j = 0; j < level * 2; j++) {
                sb.append(arr[i][j]);
            }
            if (i + 1 != level) {
                sb.append("\n");
            }
        }

        System.out.print(sb);
    }

    private static void makeStars(int x, int y, int level) {
        if (level == 3) {
            //  *
            // * *
            //*****
            arr[x][y + 2] = '*';
            arr[x + 1][y + 1] = '*';
            arr[x + 1][y + 3] = '*';
            arr[x + 2][y] = '*';
            arr[x + 2][y + 1] = '*';
            arr[x + 2][y + 2] = '*';
            arr[x + 2][y + 3] = '*';
            arr[x + 2][y + 4] = '*';
        } else {
            makeStars(x, y + level / 2, level / 2);
            makeStars(x + level / 2, y, level / 2);
            makeStars(x + level / 2, y + level, level / 2);
        }
    }
}