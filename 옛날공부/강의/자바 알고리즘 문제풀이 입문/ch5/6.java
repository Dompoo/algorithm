import java.util.*;

class Main {

    public int solution(int prince, int out) {
        Queue<Integer> queue = new LinkedList<>();

        for(int i = 1; i <= prince; i++) {
            queue.offer(i);
        }

        int curCount = 1;

        while(queue.size() > 1) {
            int curPrince = queue.poll();
            if(curCount % out == 0) {
                // 제거된 채로 두기
            } else {
                // 다시 넣기
                queue.offer(curPrince);
            }

            curCount++;
        }

        return queue.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int prince = sc.nextInt();
        int out = sc.nextInt();
        System.out.println(new Main().solution(prince, out));
    }
}