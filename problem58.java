package euler;

public class problem58 {
	
	static int length  = 3;
	static int primes=3;
	static int total=5;
	
	static int diff = 4;
	
	static int curr=9;
	
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
	
	
	public static double updatePrimes() {
		for (int i=0; i<4; i++) {
			curr+=diff;
			if (isPrime(curr)) primes++;
		}
		total+=4;
		length+=2;
		diff+=2;
		return ((double)primes)/total;
	}
	
	
	
	public static void main(String[] args) {
		double result = 1;
		while (result > 0.1) {
			result = updatePrimes();
		}
		System.out.println(length);
	}

}
