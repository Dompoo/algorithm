import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//https://www.acmicpc.net/problem/13023
@SuppressWarnings("ALL")
public class Main {

    static boolean found;
    static int N;
    static int T;
    static List<Integer>[] isFriend;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        isFriend = new List[N];
        for (int i = 0; i < N; i++) {
            isFriend[i] = new ArrayList<>();
        }
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            isFriend[a].add(b);
            isFriend[b].add(a);
        }

        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            visited[i] = true;
            checkLength(visited, 1, i);
        }

        System.out.println(found ? 1 : 0);
    }


    static void checkLength(boolean[] visited, int length, int last) {
        if (found) return;
        if (length >= 5) {
            found = true;
            return;
        }

        for (int friend : isFriend[last]) {
            if (visited[friend]) continue;

            visited[friend] = true;
            checkLength(visited, length + 1, friend);
            visited[friend] = false;
        }
    }
}
