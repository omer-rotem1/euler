package euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class problem82 {
	
	public static void fillMatrix(int[][] answer, int[][] matrix, int j) { // working on the jth column
		for (int i=0; i<80; i++) {
			//working on matrix[i][j]
			int min = answer[i][j+1];
			int accumulative = 0;
			for (int k = i+1; k<80; k++) {
				accumulative += matrix[k][j];
				if (accumulative + answer[k][j+1] < min) min =  + accumulative + answer[k][j+1];
			}
			accumulative = 0;
			for (int k = i-1; k>=0; k--) {
				accumulative += matrix[k][j];
				if (accumulative + answer[k][j+1] < min) min = accumulative + answer[k][j+1];
			}
			answer[i][j] = min + matrix[i][j];
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		/*
		 * Explanation for the solution:
		 * suppose we want to find the shortest distance from a cell in the 78th offset to the rightmost column.
		 * We have 3 options:
		 * 1. Go Directly one cell to the right
		 * 2. Go up some cells and then go to the right
		 * 3. Go down some cells and then go to the right
		 * We check what the best way to get to 79th column is, and then write the result in the matrix answer[i][j].
		 * We keep doing this for every column, writing the best way to get to the next column in answer[i][j].
		 * Then, we check the minimum value in the leftmost column and that's the answer.
		 */
		int[][] matrix = new int[80][80];
		FileReader fr = new FileReader("C:\\Users\\Omer\\workspace_euler\\euler\\src\\euler\\p082_matrix.txt");
		BufferedReader textReader = new BufferedReader(fr);
		String line = textReader.readLine();
		int i=0;
		while (line != null) {
			String[] temp = line.split(",");
			for (int j=0; j<80 ; j++) {
				matrix[i][j] = Integer.parseInt(temp[j]);
			}
			line = textReader.readLine();
			i++;
		}
		int[][] answer = new int[80][80];
		for (i =0; i<80; i++) {
			answer[i][79] = matrix[i][79];
		}
		for ( i = 78; i>=0; i--) {
			fillMatrix(answer, matrix, i);
		}
		int min = Integer.MAX_VALUE;
		for (i = 0; i<80; i++) {
			if (answer[i][0] < min) {
				min = answer[i][0];
			}
		}
		textReader.close();
		System.out.println(min);
	}

}
