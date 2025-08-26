import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringJoiner;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());
        List<Balloon> balloons = new ArrayList<>();

        String[] inputs = br.readLine().trim().split("\\s+");
        for (int i = 0; i < count; i++) {
            balloons.add(new Balloon(i + 1, Integer.parseInt(inputs[i])));
        }

        StringJoiner sj = new StringJoiner(" ");
        int nextIndex = 0;

        while (!balloons.isEmpty()) {
            Balloon cur = balloons.remove(nextIndex);
            sj.add(Integer.toString(cur.index));

            if (balloons.isEmpty()) break;

            int size = balloons.size();
            int move = cur.number;
            int step = (move > 0) ? (move - 1) : move; // 핵심 수정

            nextIndex = (nextIndex + step) % size;
            if (nextIndex < 0) nextIndex += size;      // 음수 모듈러 보정
        }

        System.out.print(sj.toString());
    }

    private static class Balloon {
        int index;
        int number;

        Balloon(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
}
