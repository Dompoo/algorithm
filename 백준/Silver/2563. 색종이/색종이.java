import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int size = Integer.parseInt(br.readLine());
		boolean[][] rect = new boolean[100][100];
		
		for (int i = 0; i < size; i++) {
			String[] xy = br.readLine().split(" ");
			int X = Integer.parseInt(xy[0]);
			int Y = Integer.parseInt(xy[1]);
			for (int x = X; x < X + 10; x++) {
				for (int y = Y; y < Y + 10; y++) {
					rect[x][y] = true;
				}
			}
		}
		
		int count = 0;
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 100; j++) {
				if (rect[i][j]) count++;
			}
		}
		
		System.out.print(count);
	}
}