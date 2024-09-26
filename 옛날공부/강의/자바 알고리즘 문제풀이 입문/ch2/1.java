import java.util.*;

class Main {

    public List<Integer> solution(int[] input) {

        List<Integer> list = new ArrayList<>();

        int prev = Integer.MIN_VALUE;
        int curr = input[0];

        for(int i = 0; i < input.length; i++) {
            curr = input[i];
            if(prev < curr) {
                list.add(curr);
            }
            prev = curr;
        }

        return list;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int inputNumber = sc.nextInt();
        int[] input =  new int[inputNumber];

        for(int i = 0; i < inputNumber; i++) {
            input[i] = sc.nextInt();
        }

        Main T = new Main();
        List<Integer> result = T.solution(input);

        for(int i = 0; i < result.size(); i++) {
            System.out.print(result.get(i) + " ");
        }
    }
}