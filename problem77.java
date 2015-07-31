package euler;

public class problem77 {
	
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
	public static int PrimenumOfWays(int num) {
		if (num==0) return 1;
		int sum=0;
		for (int i=2; i<num; i++) {
			if (isPrime(i))
				sum+=(AuxNumOfWays(num-i,i));
		}
		return sum;
	}
	
	public static int AuxNumOfWays(int num, int max) {
		if (num==0) return 1;
		if (num<0) return 0;
		int sum=0;
		for (int i=max; i>=2; i--) {
			if (isPrime(i))
				sum+=AuxNumOfWays(num-i, i);
		}
		return sum;
	}
	
	
	
	public static void main(String[] args) {
		int i=10;
		while (PrimenumOfWays(i)<=5000) {
			i++;
		}
		System.out.println(i);
	}

}
