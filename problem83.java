package euler;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;



public class problem83 {
	

	public static void main(String[] args) throws IOException {
		
		/*
		 * Explanation: simply using Dijkstra's algorithm.
		 */

		int[][] matrix = new int[80][80];
		int[][] distances = new int[80][80];
		PriorityQueue<Vertex> vertexQueue = new PriorityQueue<Vertex>();
		for (int i=0; i<80; i++) {
			for (int j=0; j<80; j++) {
				distances[i][j] = Integer.MAX_VALUE;
			}
		}
		distances[0][0]=matrix[0][0];
		FileReader fr = new FileReader("C:\\Users\\Omer\\workspace_euler\\euler\\src\\euler\\p083_matrix.txt");
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
		textReader.close();
		Set<Vertex> s = new HashSet<Vertex>();
        Vertex p = new Vertex(0,0);
        vertexQueue.add(p);
        s.add(p);
        
        while (p != null) {
        	Set<Vertex> adjacentPoints = adjacentPoints(p.x, p.y);
        	System.out.println("current vertex: (" + p.x + "," + p.y + ")");
        	for (Vertex p1 : adjacentPoints) {
            	System.out.println("adjacent: (" + p1.x + "," + p1.y + ")");
        		if (distances[p.x][p.y] + matrix[p1.x][p1.y] < distances[p1.x][p1.y]) {
        			vertexQueue.remove(p1);
        			distances[p1.x][p1.y] = distances[p.x][p.y] + matrix[p1.x][p1.y];
        			p1.minDistance = distances[p1.x][p1.y];
        			vertexQueue.add(p1);
        		}
        	}
        	p = vertexQueue.poll();
        }
        System.out.println(distances[79][79] + matrix[0][0]); // we need to add the first cell's distance as we don't do it earlier
	}
	
	public static Vertex getNextPoint(Vertex init, Set<Vertex> s, int[][] matrix, int[][] distances) {
		int x = init.x;
		int y = init.y;
		int min=Integer.MAX_VALUE;
		Vertex minPoint = null;
		Set<Vertex> Adjacent = adjacentNewPoints(x, y, s);
		for (Vertex p : Adjacent) {
			if (matrix[p.x][p.y] < min) {
				min = matrix[p.x][p.y];
				minPoint = p;
			}
		}
		return minPoint;
	}
	
	public static Set<Vertex> adjacentPoints(int x, int y) {
		int a, b;
		a = x;
		b = y+1;
		Set<Vertex> result = new HashSet<Vertex>();
		if ((a>=0) && (a<80) && (b>=0) && (b<80)) {
			Vertex p = new Vertex(a,b);
			result.add(p);
		}
		a = x;
		b = y-1;
		if ((a>=0) && (a<80) && (b>=0) && (b<80)) {
			Vertex p = new Vertex(a,b);
			result.add(p);
		}
		a = x+1;
		b = y;
		if ((a>=0) && (a<80) && (b>=0) && (b<80)) {
			Vertex p = new Vertex(a,b);
			result.add(p);
		}
		a = x-1;
		b = y;
		if ((a>=0) && (a<80) && (b>=0) && (b<80)) {
			Vertex p = new Vertex(a,b);
			result.add(p);
		}
		return result;
	}
	
	public static Set<Vertex> adjacentNewPoints(int x, int y, Set<Vertex> s) {
		int a, b;
		a = x+1;
		b = y+1;
		Set<Vertex> result = new HashSet<Vertex>();
		if (isValid(a,b, s)) {
			Vertex p = new Vertex(a,b);
			result.add(p);
		}
		a = x-1;
		b = y+1;
		if (isValid(a,b, s)) {
			Vertex p = new Vertex(a,b);
			result.add(p);
		}
		a = x+1;
		b = y-1;
		if (isValid(a,b, s)) {
			Vertex p = new Vertex(a,b);
			result.add(p);
		}
		a = x-1;
		b = y-1;
		if (isValid(a,b, s)) {
			Vertex p = new Vertex(a,b);
			result.add(p);
		}
		return result;
	}
	
	public static boolean isValid(int a, int b, Set<Vertex> s) {
		if ((a>=0) && (a<80) && (b>=0) && (b<80)) return false;
		Vertex p1 = new Vertex(a,b);
		for (Vertex p : s) {
			if (p.equals(p1)) {
				return false;
			}
		}
		return true;
	}

}
