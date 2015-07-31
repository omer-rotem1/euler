package euler;

public class problem73 {
	
	public static int gcd(int a, int b) {
		   if (b==0) return a;
		   return gcd(b,a%b);
	}
	
	public static void main(String[] args) {
		double curr;
		int count=0;
		double third = (double)1/3;
		for (int i=1; i<=12000; i++) {
			for (int j=i; j<=12000; j++) {
				curr = ((double)i)/j;
				if ( (gcd(i,j)==1) && (curr < 0.5) && (curr > third)) {
					count++;
				}
			}
		}
		System.out.println(count);
	}

}
