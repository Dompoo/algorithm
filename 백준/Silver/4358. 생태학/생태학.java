import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Main {
    // 29
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int totalCount = 0;
        Map<String, Integer> map = new HashMap<>();
        String namu;
        while ((namu = br.readLine()) != null) {
            totalCount++;
            map.merge(namu, 1, Integer::sum);
        }

        TreeSet<String> namuNames = new TreeSet<>(map.keySet());

        StringBuffer sb = new StringBuffer();
        for (String namuName : namuNames) {
            double percent = ((double) map.get(namuName) / totalCount) * 100;
            BigDecimal percent4 = new BigDecimal(percent).setScale(4, RoundingMode.HALF_UP);
            sb.append(namuName).append(" ").append(percent4.toPlainString()).append("\n");
        }
        System.out.println(sb);
    }
}
