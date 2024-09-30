import java.util.*;

class Main {

    public String solution(String require, String plan) {
        List<Character> requireList = new ArrayList<>();
        for(char ch : require.toCharArray()) {
            requireList.add(ch);
            // C B A
        }

        int checkIndex = 0;
        String result = "YES";

        for(char ch : plan.toCharArray()) {
            if(requireList.contains(ch)) {
                if(requireList.get(checkIndex) == ch) {
                    // 순서대로 잘 들은 경우
                    checkIndex++;
                } else {
                    // 순서를 잘못 들은 경우
                    result = "NO";
                    break;
                }
            }
        }

        // 필수과목을 덜 들은 경우
        if(checkIndex != requireList.size()) result = "NO";

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String require = sc.next();
        String plan = sc.next();
        System.out.println(new Main().solution(require, plan));
    }
}