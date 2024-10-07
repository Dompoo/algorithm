import java.io.*;
import java.util.*;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		boolean[] arr = new boolean[21];
		
		int size = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < size; i++) {
			String[] input = br.readLine().split(" ");
			String order = input[0];
			switch (order) {
				case "add":
					arr[Integer.parseInt(input[1])] = true;
					break;
				case "remove":
					arr[Integer.parseInt(input[1])] = false;
					break;
				case "check":
					if(arr[Integer.parseInt(input[1])]) bw.write("1\n");
					else bw.write("0\n");
					break;
				case "toggle":
					arr[Integer.parseInt(input[1])] = !arr[Integer.parseInt(input[1])];
					break;
				case "all":
					Arrays.fill(arr, true);
					break;
				case "empty":
					Arrays.fill(arr, false);
					break;
			}
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
}
