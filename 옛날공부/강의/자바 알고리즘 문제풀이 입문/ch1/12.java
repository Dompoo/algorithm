import java.util.Scanner;

class Main {

    public String solution(int len, String str) {

        int concatPoint = 0;

        String answer = "";
        for(int i = 0; i < len; i++) {
            String value = str.substring(concatPoint, concatPoint + 7);
            concatPoint += 7;

            int ten = 0;
            for(int j = 6; j >= 0; j--) {
                if(value.charAt(j) == '#') {
                    ten += Math.pow(2, 6 - j);
                }
            }

            answer += (char) ten;
        }
        return answer;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String fullStr = sc.next();

        Main T = new Main();
        System.out.println(T.solution(len, fullStr));
    }
}