import java.util.*;

class Main {

    /*

    90 80 70 60 50
    60 50 70 80 90
       ^
    
    */

    public int solution(int size, int[] arr, int target) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < size; i++) {
            queue.offer(arr[i]);
            list.add(arr[i]);
        }

        // list.sort(Collections.reverseOrder());
        list.sort(Collections.reverseOrder());
        int result = 1;
        int currTargetIndex = target;

        while(true) {
            int curr = queue.poll();
            if(curr == list.get(0)) {
                //위험도 제일 높은 사람, 진료 받음
                if(currTargetIndex == 0) {
                    //방금 진료받은 사람이 우리의 목표였다면
                    break;
                }
                list.remove(0);
                result++;
            } else {
                //위험도가 제일 높지 않은 사람, 다시 넣음
                queue.offer(curr);
            }
            currTargetIndex--;
            if(currTargetIndex < 0) currTargetIndex += list.size();
        }

        return result;
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int arrSize = sc.nextInt();
        int target = sc.nextInt();
        int[] arr = new int[arrSize];
        for (int i = 0; i < arrSize; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println(new Main().solution(arrSize, arr, target));
    }
}