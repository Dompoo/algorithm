import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

  static class Node {
    public Node left;
    public Node right;
    public int value;

    public Node(int value) {
      this.value = value;
    }

    public void add(int nextValue) {
      if (nextValue < value) {
        if (left == null) {
          left = new Node(nextValue);
        } else {
          left.add(nextValue);
        }
      } else {
        if (right == null) {
          right = new Node(nextValue);
        } else {
          right.add(nextValue);
        }
      }
    }

    public void back(StringBuilder sb) {
      if (left != null) left.back(sb);
      if (right != null) right.back(sb);
      sb.append(value).append("\n");
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Node tree = new Node(Integer.parseInt(br.readLine()));

    String input = br.readLine();

    while (input != null && !input.isBlank()) {
      int curNum = Integer.parseInt(input);

      tree.add(curNum);

      input = br.readLine();
    }

    // 트리를 후위출력
    StringBuilder sb = new StringBuilder();
    tree.back(sb);
    System.out.print(sb);
  }
}
