
import java.util.Scanner;

class Main {

    public char convert(char ch) {
        if(Character.isUpperCase(ch)) return Character.toLowerCase(ch);
        else return Character.toUpperCase(ch);
    }

    public String solution(String str) {
        String answer = "";
        for(char x : str.toCharArray()) {
            answer += convert(x);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String str = sc.next();

        System.out.print(new Main().solution(str));
    }
}