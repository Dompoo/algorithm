import java.util.*;

class Main {

    static class Attend {
        int start;
        int end;

        Attend(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    static List<Attend> list = new ArrayList<>();

    public int solution1() {
        int[] attender = new int[73]; // 0 ~ 72
        for(Attend attend : list) {
            for(int i = attend.start; i < attend.end; i++) {
                attender[i]++;
            }
        }

        int result = Integer.MIN_VALUE;
        for(int i = 0; i < 73; i++) {
            result = Math.max(result, attender[i]);
        }
        return result;
    }

    static class InAndOut implements Comparable<InAndOut> {
        int time;
        int isIn;

        InAndOut(int time, int isIn) {
            this.time = time;
            this.isIn = isIn;
        }

        @Override
        public int compareTo(InAndOut other) {
            if(this.time != other.time) return this.time - other.time;
            else return this.isIn - other.isIn;
        }

        @Override
        public String toString() {
            return this.time + " " + this.isIn;
        }
    }

    public int solution2() {
        List<InAndOut> ioList = new ArrayList<>();

        for(Attend attend : list) {
            ioList.add(new InAndOut(attend.start, 1));
            ioList.add(new InAndOut(attend.end, 0));
        }

        Collections.sort(ioList);


        int result = 0;
        int curr = 0;
        for(InAndOut io : ioList) {
            result = Math.max(result, curr);
            if(io.isIn == 1) curr++;
            else curr--;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        for(int i = 0; i < size; i++) {
            list.add(new Attend(sc.nextInt(), sc.nextInt()));
        }
        System.out.println(new Main().solution2());
    }
}