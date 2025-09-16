import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int Y = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());
        int[][] arr = new int[X][Y];
        boolean[][] added = new boolean[X][Y];
        Deque<Tomato> deque = new ArrayDeque<>();
        int tomatoToAdd = 0;
        for (int i = 0; i < X; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < Y; j++) {
                int input = Integer.parseInt(st.nextToken());
                if (input == 1) {
                    added[i][j] = true;
                    deque.add(new Tomato(i, j, 0));
                }
                if (input == 0) {
                    tomatoToAdd++;
                }
                arr[i][j] = input;
            }
        }

        int[] dx = new int[]{0, 0, 1, -1};
        int[] dy = new int[]{1, -1, 0, 0};
        int totalAddedCount = 0;
        int lastDate = 0;
        while (!deque.isEmpty()) {
            Tomato tomato = deque.poll();
            for (int i = 0; i < 4; i++) {
                int nx = tomato.x + dx[i];
                int ny = tomato.y + dy[i];
                if (nx < 0 || nx >= X || ny < 0 || ny >= Y || arr[nx][ny] == -1 || added[nx][ny] == true) continue;
                added[nx][ny] = true;
                deque.add(new Tomato(nx, ny, tomato.date + 1));
                lastDate = tomato.date + 1;
                totalAddedCount++;
            }
        }

        if (tomatoToAdd == totalAddedCount) {
            System.out.println(lastDate);
        } else {
            System.out.println(-1);
        }
    }

    private static void printTomatos(Set<Tomato> tomatos, int X, int Y) {
        String[][] arr = new String[X][Y];
        for (String[] strings : arr) {
            Arrays.fill(strings, "X");
        }
        for (Tomato tomato : tomatos) {
            arr[tomato.x][tomato.y] = "O";
        }
        StringBuilder sb = new StringBuilder();
        for (String[] strings : arr) {
            for (String string : strings) {
                sb.append(string);
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    static class Tomato {

        int x;
        int y;
        int date;

        Tomato(int x, int y, int date) {
            this.x = x;
            this.y = y;
            this.date = date;
        }

        @Override
        public final boolean equals(Object o) {
            if (!(o instanceof Tomato)) return false;

            Tomato tomato = (Tomato) o;
            return x == tomato.x && y == tomato.y;
        }

        @Override
        public int hashCode() {
            int result = x;
            result = 31 * result + y;
            return result;
        }
    }
}
