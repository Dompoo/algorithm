import java.util.*;

class Main {

    public char solution(int size, char[] input) {
        int[] vote = new int[5]; // A B C D E

        for(int i = 0; i < size; i++) {
            vote[input[i] - 'A']++;
        }

        int maxVote = Integer.MIN_VALUE;
        char result = 'A';
        for(int i = 0; i < 5; i++) {
            if(vote[i] > maxVote) {
                result = (char) (i + 'A');
                maxVote = vote[i];
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        String input = sc.next();
        System.out.println(new Main().solution(size, input.toCharArray()));
    }
}