import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

        int n = Integer.parseInt(br.readLine());
        List<Integer> list = new ArrayList<>();
        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            list.add(Integer.parseInt(inputs[i]));
        }

        int total = 0;

        Collections.sort(list);

        for (int i = 0; i < list.size(); i++) {
            Integer cur = list.get(i);
            total += cur * (list.size() - i);
        }
        System.out.print(total);
    }
}
