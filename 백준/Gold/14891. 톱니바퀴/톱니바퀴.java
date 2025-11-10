import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings("ALL")
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> gear1 = new ArrayList<>();
        List<Integer> gear2 = new ArrayList<>();
        List<Integer> gear3 = new ArrayList<>();
        List<Integer> gear4 = new ArrayList<>();
        for (char ch : br.readLine().toCharArray()) {
            gear1.add(ch - '0');
        }
        for (char ch : br.readLine().toCharArray()) {
            gear2.add(ch - '0');
        }
        for (char ch : br.readLine().toCharArray()) {
            gear3.add(ch - '0');
        }
        for (char ch : br.readLine().toCharArray()) {
            gear4.add(ch - '0');
        }

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] in = br.readLine().split(" ");
            int gearNum = Integer.parseInt(in[0]);
            int dir = Integer.parseInt(in[1]);

            boolean gear1_gear2 = gear1.get(2) != gear2.get(6);
            boolean gear2_gear3 = gear2.get(2) != gear3.get(6);
            boolean gear3_gear4 = gear3.get(2) != gear4.get(6);

            if (gearNum == 1) {
                Collections.rotate(gear1, dir);
                if (gear1_gear2) {
                    Collections.rotate(gear2, -dir);
                    if (gear2_gear3) {
                        Collections.rotate(gear3, dir);
                        if (gear3_gear4) {
                            Collections.rotate(gear4, -dir);
                        }
                    }
                }
            }
            if (gearNum == 2) {
                Collections.rotate(gear2, dir);
                if (gear1_gear2) {
                    Collections.rotate(gear1, -dir);
                }
                if (gear2_gear3) {
                    Collections.rotate(gear3, -dir);
                    if (gear3_gear4) {
                        Collections.rotate(gear4, dir);
                    }
                }
            }
            if (gearNum == 3) {
                Collections.rotate(gear3, dir);
                if (gear3_gear4) {
                    Collections.rotate(gear4, -dir);
                }
                if (gear2_gear3) {
                    Collections.rotate(gear2, -dir);
                    if (gear1_gear2) {
                        Collections.rotate(gear1, dir);
                    }
                }
            }
            if (gearNum == 4) {
                Collections.rotate(gear4, dir);
                if (gear3_gear4) {
                    Collections.rotate(gear3, -dir);
                    if (gear2_gear3) {
                        Collections.rotate(gear2, dir);
                        if (gear1_gear2) {
                            Collections.rotate(gear1, -dir);
                        }
                    }
                }
            }
        }

        int result = 0;
        if (gear1.get(0) == 1) result += 1;
        if (gear2.get(0) == 1) result += 2;
        if (gear3.get(0) == 1) result += 4;
        if (gear4.get(0) == 1) result += 8;
        System.out.println(result);
    }
}
