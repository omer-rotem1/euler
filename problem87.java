package euler;

import java.util.HashSet;
import java.util.Set;

public class problem87 {
	
	public static int findNextPrime(int n) {
		if (n==2) return 3;
		while (1==1) {
			n+=2;
			if (auxiliary.isPrime(n)) return n;
		}
	}
	
	public static void main(String[] args) {
		/*
		 * main idea:
		 * have a=2, b=2 and iterate with c over all primes until x = a^2+b^3+c^4>50000000.
		 * Once x is greater than 5M, we'll assign c=2 and increase b to be the next prime, until eventually even with c=2 x>5M.
		 * Then, we assign b,c=2 and increment a to be the next prime etc. Until a^2+2^3+2^4 is too big and then we stop.
		 */
		
		int a=2, b=2, c=2, d=0;
		Set<Integer> s = new HashSet<Integer>();
		double ans;
		while (1==1) {
			ans=Math.pow(a, 2) + Math.pow(b, 3) + Math.pow(c, 4);
			if (ans < 50000000) {
				s.add((int)ans);
				c = findNextPrime(c);
			}
			else {
				c=2;
				b=findNextPrime(b);
				ans=Math.pow(a, 2) + Math.pow(b, 3) + Math.pow(c, 4);
				if (ans > 50000000) {
					b=2;
					a=findNextPrime(a);
					ans=Math.pow(a, 2) + Math.pow(b, 3) + Math.pow(c, 4);
					if (ans > 50000000) {
						break;
				}
			}
		}
	}
		System.out.println(s.size());

}
}
