import java.util.*;

public class PracticeProblem {

	public static int searchMazeMoves(String[][] arr) {
		int row = arr.length;
		int column = arr[0].length;
		int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

		int startRow = -1, startColumn = -1;
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				if (arr[i][j].equals("S")) {
					startRow = i;
					startColumn = j;
					break;
				}
			}
		}

		boolean[][] visited = new boolean[row][column];
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[]{startRow, startColumn, 0});
		visited[startRow][startColumn] = true;

		while (!queue.isEmpty()) {
			int[] curr = queue.poll();
			int r = curr[0];
			int c = curr[1];
			int numOfMoves = curr[2];

			if (arr[r][c].equals("F")) {
				return numOfMoves;
			}

			for (int[] dir : directions) {
				int newRow = r + dir[0];
				int newCol = c + dir[1];

				if (newRow >= 0 && newRow < row && newCol >= 0 && newCol < column && !visited[newRow][newCol] && !arr[newRow][newCol].equals("*")) {
					visited[newRow][newCol] = true;
					queue.add(new int[]{newRow, newCol, numOfMoves + 1});
				}
			}
		}
		return -1;
	}


	public static void main(String args[]) {
		String[][] maze = {
			{"*", "", "", "", "F"},
			{"*", "", "*", "*", "*"},
			{"*", "", "", "*", "*"},
			{"*", "*", "", "*", "*"},
			{"S", "", "", "*", "*"}
		};

		int result = searchMazeMoves(maze);
		System.out.println(result);
	}


}
