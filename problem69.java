package euler;

public class problem69 {
	
	
	static boolean isPrime(int n) {
		if (n==1) return false;
		if (n==2) return true;
	    if (n%2==0) return false;
	    for(int i=3;i*i<=n;i+=2) {
	        if(n%i==0)
	            return false;
	    }
	    return true;
	}	
	
	public static int gcd(int a, int b) {
		   if (b==0) return a;
		   return gcd(b,a%b);
	}
	
	public static double phiDividedByN (int n) {
		double result=1;
		double one=1.0;
		if (isPrime(n)) {
			return result * (1 - one/n);
		}
		if (n%2==0)  {
			result = result * (1 - one/2);
		}
		for (int i=3; i<=n/2; i+=2) {
			if (n%i==0 && isPrime(i)) {
				result = result * (1 - one/i);
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		double min=9;
		int minN=0;
		double result;
		for (int i=2; i<=1000000; i++) {
			result = phiDividedByN(i);
			System.out.println("i=" + i + " result=" + result);
			if (result<min) {
				min=result;
				minN=i;
			}
		}
		System.out.println(minN);
	}
	

}
