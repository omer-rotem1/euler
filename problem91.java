package euler;


public class problem91 {
	static final int size = 50;
	public static boolean isRight(int x1, int y1, int x2, int y2) {
		/*
		 * To check 
		 */
		if ((x1 == 0 && y1 == 0) || (x2 == 0 && y2 == 0)) return false;
		if (x1==0) {
			if (x2 ==0) return false;
			if ((y1 == y2) || (y2 == 0)) return true;
			if ((Math.abs(((y2 - y1)/ ((double)x2 - x1)) * (y2 / (double)x2) + 1)) < 0.0001) return true;
			return false;
		}
		if (x2 == 0) {
			if ((y1 == y2) || (y1 ==0)) return true;
			if ((Math.abs(((y2 - y1)/ ((double)x2 - x1)) * (y1 / (double)x1) + 1)) < 0.0001) return true;
			return false;
		}
		if (x1 == x2) {
			return (y1 ==0 || y2 == 0);
		}
		double a, b, c;
		a = y2/((double)x2);
		b = y1/((double)x1);
		c = (y2 - y1) / ((double)x2-x1);
		if (Math.abs(a*b+1) < 0.0001 || Math.abs(b*c+1) < 0.0001 ||Math.abs(a*c+1) < 0.0001) return true;
		return false;
	}
	
	public static boolean lexicographicallyRight(int x1, int y1, int x2, int y2) {
		if ((x1 < x2) || ((x1 == x2) && (y1<y2))) return true;
		return false;
	}
	
	public static void main(String[] args) {
		System.out.println((Math.abs(((1 - 2)/ ((double)1 - 0)) * (1 / (double)1) + 1)));
		int count=0;
		for (int x1=0; x1<=size; x1++) {
			for (int y1=0; y1<=size; y1++) {
				for (int x2 = 0; x2<=size ; x2++) {
					for (int y2 = 0; y2 <=size; y2++) {
						if (isRight(x1,y1,x2,y2) && lexicographicallyRight(x1, y1, x2, y2)) {
							count++;
						}
					}
				}
			}
		}
		System.out.println(count);
	}

}
