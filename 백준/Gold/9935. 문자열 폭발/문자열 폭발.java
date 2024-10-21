import java.util.*;
import java.io.*;

class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String explode = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (Character ch : str.toCharArray()) {
            stack.push(ch);

            if (stack.size() >= explode.length()) {
                boolean isBomb = true;
                for (int i = 0; i < explode.length(); i++) {
                    if (!stack.get(stack.size() - explode.length() + i).equals(explode.charAt(i))) {
                        isBomb = false;
                        break;
                    }
                }

                if (isBomb) {
                    for (int i = 0; i < explode.length(); i++) {
                        stack.pop();
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.print("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            System.out.print(sb);
        }
    }
}