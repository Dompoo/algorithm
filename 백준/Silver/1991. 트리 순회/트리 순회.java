import java.util.*;
import java.io.*;

/*
7
A B C
B D .
C E F
E . .
F . G
D . .
G . .
 */
class Main {
	
	static class Node {
		String name;
		Node left;
		Node right;
		
		public Node(String name, Node left, Node right) {
			this.name = name;
			this.left = left;
			this.right = right;
		}
		
		public String getPreOrderString() {
			String value = "";
			value += name;
			if (left != null) value += left.getPreOrderString();
			if (right != null) value += right.getPreOrderString();
			return value;
		}
		
		public String getInOrderString() {
			String value = "";
			if (left != null) value += left.getInOrderString();
			value += name;
			if (right != null) value += right.getInOrderString();
			return value;
		}
		
		public String getPostOrderString() {
			String value = "";
			if (left != null) value += left.getPostOrderString();
			if (right != null) value += right.getPostOrderString();
			value += name;
			return value;
		}
		
		@Override
		public String toString() {
			return "Node{" +
					"name='" + name + '\'' +
					", left=" + left +
					", right=" + right +
					'}';
		}
	}
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		
		Map<String, Node> map = new HashMap<>();
		for (int i = 0; i < size; i++) {
			String name = String.valueOf((char) ('A' + i));
			map.put(name, new Node(name, null, null));
		}
		
		for (int i = 0; i < size; i++) {
			String[] input = br.readLine().split(" ");
			Node node = map.get(input[0]);
			if (!input[1].equals(".")) node.left = map.get(input[1]);
			if (!input[2].equals(".")) node.right = map.get(input[2]);
		}
		
		Node root = map.get("A");
		String preOrder = root.getPreOrderString();
		String inOrder = root.getInOrderString();
		String postOrder = root.getPostOrderString();
		System.out.print(preOrder + "\n" + inOrder + "\n" + postOrder);
	}
}