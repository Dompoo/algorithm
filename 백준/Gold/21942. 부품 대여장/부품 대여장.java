import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.TreeMap;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = Integer.parseInt(st.nextToken());
        MyPeriod myPeriod = new MyPeriod(st.nextToken());
        int moneyPerMinute = Integer.parseInt(st.nextToken());

        // 사람 -> 벌금
        TreeMap<String, Long> answer = new TreeMap<>();

        // 사람, 상품 -> 빌린시간
        HashMap<String, HashMap<String, MyDateTime>> map = new HashMap<>();

        while (count-- > 0) {
            st = new StringTokenizer(br.readLine());
            String date = st.nextToken();
            String time = st.nextToken();
            String product = st.nextToken();
            String user = st.nextToken();

            map.computeIfAbsent(user, k -> new HashMap<>());
            HashMap<String, MyDateTime> productToTime = map.get(user);
            if (productToTime.get(product) == null) {
                // 새로 빌림
                productToTime.put(product, new MyDateTime(date, time));
            } else {
                // 반납
                MyDateTime borrowDateTime = productToTime.get(product);
                MyDateTime returnDateTime = new MyDateTime(date, time);
                MyPeriod between = MyPeriod.between(borrowDateTime, returnDateTime);
                if (between.isBiggerThan(myPeriod)) {
                    long diff = between.minusToMinute(myPeriod);
                    answer.merge(user, diff * moneyPerMinute, Long::sum);
                }
                productToTime.remove(product);
            }
        }

        if (answer.isEmpty()) {
            System.out.println(-1);
        } else {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, Long> entry : answer.entrySet()) {
                sb.append(entry.getKey()).append(" ").append(entry.getValue()).append("\n");
            }
            System.out.println(sb);
        }
    }

    static class MyDateTime {

        private final static DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        LocalDateTime localDateTime;

        public MyDateTime(String date, String time) {
            this.localDateTime = LocalDateTime.parse(date + " " + time, FORMATTER);
        }
    }

    static class MyPeriod {

        long minute;

        private MyPeriod(long minute) {
            this.minute = minute;
        }

        public MyPeriod(String period) {
            int day = Integer.parseInt(period.substring(0, 3));
            int hour = Integer.parseInt(period.substring(4, 6));
            int minute = Integer.parseInt(period.substring(7, 9));
            this.minute = minute + hour * 60L + day * 24L * 60L;
        }

        public static MyPeriod between(MyDateTime borrowDateTime, MyDateTime returnDateTime) {
            Duration duration = Duration.between(borrowDateTime.localDateTime, returnDateTime.localDateTime);
            return new MyPeriod(duration.toMinutes());
        }

        public boolean isBiggerThan(MyPeriod other) {
            return minute > other.minute;
        }

        public long minusToMinute(MyPeriod other) {
            return minute - other.minute;
        }
    }
}
