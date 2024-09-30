import java.util.*;

class Main {

    public String solution(int cacheSize, int arrSize, int[] cpuUse) {
        List<Integer> list = new ArrayList<>();
        for(int cpu : cpuUse) {

            int hitIndex = -1;
            for (int i = 0; i < list.size(); i++) {
                if(list.get(i) == cpu) {
                    hitIndex = i;
                    break;
                }
            }

            if(hitIndex != -1) {
                //hit 이라면 가장 맨 앞으로 이동한다.
                list.remove(hitIndex);
                list.add(0, cpu);
            } else if(list.size() < cacheSize) {
                //miss 인데, 아직 덜 찼다면 맨 앞에 추가한다.
                list.add(0, cpu);
            } else {
                //miss 인데, 다 찼다면, 맨 뒤를 삭제하고 맨 앞에 추가한다.
                list.remove(list.size() - 1);
                list.add(0, cpu);
            }
        }

        String result = "";
        for(int i = 0; i < list.size(); i++) {
            result += list.get(i);
            result += " ";
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cacheSize = sc.nextInt();
        int arrSize = sc.nextInt();
        int[] cpuUse = new int[arrSize];
        for(int i = 0; i < arrSize; i++) {
            cpuUse[i] = sc.nextInt();
        }
        System.out.println(new Main().solution(cacheSize, arrSize, cpuUse));
    }
}