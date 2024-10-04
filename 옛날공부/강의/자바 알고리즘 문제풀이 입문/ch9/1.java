import java.util.*;

class Main {

    public static class Person implements Comparable<Person> {
        public int h;
        public int w;

        public Person(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Person other) {
            if(this.h != other.h) {
                return other.h - this.h;
            } else {
                return other.w - this.w;
            }
        }

        @Override
        public String toString() { 
            return h + " " + w;
        }
    }

    public static int N;
    public static List<Person> list = new ArrayList<>();

    public int solution() {
        Collections.sort(list);

        // 키 큰 순서부터 ~
        // 만약 해당 index의 사람이 몸무게도 작으면 빠짐
        int result = list.size();
        int highW = Integer.MIN_VALUE;

        for(int i = 0; i < list.size(); i++) {
            if(highW > list.get(i).w) {
                result--;
            }
            highW = Math.max(list.get(i).w, highW);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        for(int i = 0; i < N; i++) {
            int h = sc.nextInt();
            int w = sc.nextInt();
            list.add(new Person(h, w));
        }
        System.out.println(new Main().solution());
    }
}