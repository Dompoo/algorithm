import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] NK = br.readLine().split(" ");
        int N = Integer.parseInt(NK[0]);
        int K = Integer.parseInt(NK[1]);

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        StringJoiner sj = new StringJoiner(", ", "<", ">");
        int index = 0;
        while (!list.isEmpty()) {
            index += (K - 1);
            index %= list.size();
            Integer result = list.remove(index);
            sj.add(result.toString());
        }
        System.out.print(sj);
    }
}
