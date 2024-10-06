import java.util.*;

class Main {

    public static class Lecture implements Comparable<Lecture> {

        int money;
        int lastDay;

        public Lecture(int money, int lastDay) {
            this.money = money;
            this.lastDay = lastDay;
        }

        @Override
        public int compareTo(Lecture other) {
            if(this.money != other.money) return other.money - this.money;
            else return other.lastDay - this.lastDay;
        }

        @Override
        public String toString() {
            return this.lastDay + " " + this.money;
        }
    }

    public static List<Lecture> list = new ArrayList<>();
    public static int maxDay = Integer.MIN_VALUE;
    public static int size;

    public int solution() {
        PriorityQueue<Lecture> queue = new PriorityQueue<>();
        Collections.sort(list, (a, b) -> b.lastDay - a.lastDay);

        int index = 0;
        int result = 0;

        for(int i = maxDay; i >= 1; i--) {
            //현재 강의할 수 있는 강의를 queue에 넣기
            for(; index < size; index++) {
                if(list.get(index).lastDay == i) {
                    queue.offer(list.get(index));
                } else {
                    break;
                }
            }

            //강의할 수 있는 강의 중 최대 돈을 선택하고 삭제
            Lecture select = queue.poll();
            if(select != null) result += select.money;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        size = sc.nextInt();
        for(int i = 0; i < size; i++) {
            int money = sc.nextInt();
            int day = sc.nextInt();
            list.add(new Lecture(money, day));
            maxDay = Math.max(maxDay, day);
        }
        System.out.println(new Main().solution());
    }
}