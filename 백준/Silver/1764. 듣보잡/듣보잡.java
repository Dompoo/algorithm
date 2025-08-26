import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/*
3 4
baesangwook
ohhenrie
charlie
obama
baesangwook
ohhenrie
clinton
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] inputs = br.readLine().split(" ");
        int N = Integer.parseInt(inputs[0]);
        int M = Integer.parseInt(inputs[1]);

        Set<String> notHeard = new HashSet<>();
        Set<String> both = new TreeSet<>();

        for (int i = 0; i < N; i++) {
            notHeard.add(br.readLine());
        }

        for (int i = 0; i < M; i++) {
            String input = br.readLine();
            if (notHeard.contains(input)) {
                both.add(input);
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.append(both.size()).append("\n");
        for (String s : both) {
            sb.append(s).append("\n");
        }
        System.out.print(sb);
    }
}
