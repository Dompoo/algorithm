import java.util.Scanner;

class Main {
    public int solution(String str, char t) {
        String lowerCase = str.toLowerCase();

        if('A' <= t && t <= 'Z') {
            t += ('a' - 'A');
        }

        int answer = 0;
        for(int i =0; i < lowerCase.length(); i++) {
            if(lowerCase.charAt(i) == t) answer++;
        }

        return answer;
    }
    public static void main(String[] args) {
        Main main = new Main();

        Scanner sc = new Scanner(System.in);

        String str = sc.next();
        char ch = sc.next().charAt(0);

        System.out.println(main.solution(str, ch));
    }
}