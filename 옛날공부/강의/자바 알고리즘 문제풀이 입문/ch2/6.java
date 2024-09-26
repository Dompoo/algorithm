import java.util.*;

class Main {

    public String solution(String[] input) {
        // 소수 확인용 배열 생성
        boolean[] isPrime = new boolean[100001];
        for(int i = 2; i <= 100000; i++) {
            isPrime[i] = true;
        }
        for(int i = 2; i * i <= 100000; i++) {
            if(isPrime[i]) {
                for(int j = i * i; j <= 100000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        
        List<String> resultList = new ArrayList<>();
        for(String str : input) {
            //뒤집기
            String flip = new StringBuilder(str).reverse().toString();
            int flipNum = Integer.parseInt(flip);

            //소수 확인
            if(isPrime[flipNum]) {
                resultList.add(String.valueOf(flipNum));
            }
        }

        return String.join(" ", resultList);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        String[] input = new String[N];
        for(int i = 0 ; i < N; i++) {
            input[i] = sc.next();
        }

        Main T = new Main();
        String result = T.solution(input);
        System.out.println(result);
    }
}