package euler;

public class problem85 {
	
	public static int numOfRectangles(int length, int width) {
		int timesLength, timesWidth;
		int count=0;
		for (int i=1; i<=length; i++) {
			for (int j=1; j<=width; j++) {
				timesLength=length-i+1;
				timesWidth = width-j+1;
				count+=timesLength*timesWidth;
			}
		}
		return count;
	}
	
	public static void main(String[] args) {
		int closest=Integer.MAX_VALUE;
		int area=0;
		for (int i=1; i<=500; i++) {
			for (int j=1; j<=500; j++) {
				if (Math.abs(numOfRectangles(i, j)-2000000) < closest) {
					closest = Math.abs(numOfRectangles(i, j)-2000000);
					area = i*j;
				}
			}
		}
		System.out.println(area);
	}

}
