package B1700;

import java.util.*;

public class Main {
    static int[] seqArr;
    static Set<Integer> hole = new HashSet<>();
    static int holeSize;
    static int seqSize;
    static int lastHole;

    static int ans = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        holeSize = sc.nextInt();
        seqSize = sc.nextInt();

        seqArr = new int[seqSize];
        lastHole = holeSize;

        for (int i = 0; i < seqSize; i++) {
            seqArr[i] = sc.nextInt();
        }

        for (int i = 0; i < seqSize; i++) {
            if (hole.contains(seqArr[i])) {
                continue;
            } else if (lastHole > 0) {
                //남은자리가 있다면 꽂는다.
                hole.add(seqArr[i]);
                lastHole--;
            } else {
                //남은자리가 없고, 안꽂혀있다면 -> 그 다음부터 확인하여 가장 늦게 쓰이는 것을 찾아서 바꾼다.
                plugSwitch(i);
                ans++;
            }
        }

        System.out.println(ans);
    }


    //index번의 기기에서 충돌발생
    public static void plugSwitch(int index) {
        Set<Integer> set = new HashSet<>();

        for (int i = index + 1; i < seqSize; i++) {
            if (set.size() == holeSize - 1) {
                break;
            }

            if (hole.contains(seqArr[i])) {
                set.add(seqArr[i]);
            }
        }

        hole.clear();
        hole.addAll(set);
        hole.add(seqArr[index]);
    }

}
