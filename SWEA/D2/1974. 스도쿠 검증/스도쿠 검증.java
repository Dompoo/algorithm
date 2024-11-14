import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Time;

/*
3
3 17 1 39
8 22 5 10
6 53 2 12
 */
class Solution {
	
	public static int N = 9;
	public static int sudokuSum = 45;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		final int testcase = Integer.parseInt(br.readLine().trim());
		StringBuilder sb = new StringBuilder();
		for (int t = 1; t <= testcase; t++) {
			int[][] sudoku = new int[N][N];
			boolean isRightSudoku = true;
			
			for (int i = 0; i < N; i++) {
				String[] inputs = br.readLine().trim().split(" ");
				for (int j = 0; j < N; j++) {
					sudoku[i][j] = Integer.parseInt(inputs[j]);
				}
			}
			for (int i = 0; i < N; i++) {
				if (addRow(sudoku, i) != sudokuSum) {
					isRightSudoku = false;
					break;
				}
				if (addCol(sudoku, i) != sudokuSum) {
					isRightSudoku = false;
					break;
				}
			}
			if (isRightSudoku) {
				for (int i = 0; i < N; i += 3) {
					for (int j = 0; j < N; j += 3) {
						if (addBox(sudoku, i, j) != sudokuSum) {
							isRightSudoku = false;
							break;
						}
					}
				}
			}
			sb.append("#").append(t).append(" ").append(isRightSudoku ? 1 : 0);
			if (t != testcase) {
				sb.append("\n");
			}
		}
		System.out.print(sb);
	}
	
	public static int addRow(int[][] sudoku, int x) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += sudoku[x][i];
		}
		return sum;
	}
	
	public static int addCol(int[][] sudoku, int x) {
		int sum = 0;
		for (int i = 0; i < N; i++) {
			sum += sudoku[i][x];
		}
		return sum;
	}
	
	public static int addBox(int[][] sudoku, int x, int y) {
		int sum = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				sum += sudoku[x + i][y + j];
			}
		}
		return sum;
	}
}