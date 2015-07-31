package euler;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class problem102 {
	
	/*
	 * Idea: P is inside triangle ABC iff
	 * The area of ABC = S_ABP+S_ACP+S_BCP
	 */
	
	public static double area (int x1, int y1, int x2, int y2, int x3, int y3) {
		return Math.abs((x1*(y2-y3) + x2*(y3-y1) + x3*(y1-y2))/2.0);
	}
	
	public static boolean containsOrigin(int x1, int y1, int x2, int y2, int x3, int y3) {
		double area = area(x1,y1,x2,y2,x3,y3);
		double area1 = area(x1,y1,x2,y2,0,0);
		double area2 = area(x1,y1,0,0,x3,y3);
		double area3 = area(0,0,x2,y2,x3,y3);
		return area == area1+area2+area3;
	}
	
	public static void main(String[] args) throws IOException {
		int count=0;
		FileReader fr = new FileReader("C:\\Users\\Omer\\workspace_euler\\euler\\src\\euler\\p102_triangles.txt");
		BufferedReader textReader = new BufferedReader(fr);
		String line = textReader.readLine();
		String[] arr;
		while (line != null) {
			arr = line.split(",");
			int[] arr2 = new int[arr.length];
			for (int i=0; i<arr.length; i++) {
				arr2[i] = Integer.parseInt(arr[i]);
			}
			if (containsOrigin(arr2[0], arr2[1], arr2[2], arr2[3], arr2[4], arr2[5])) {
				count++;
			}
			line = textReader.readLine();
		}
		System.out.println(count);
	}

}
