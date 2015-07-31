package euler;

import java.util.HashSet;
import java.util.Set;

public class problem74 {
	
	public static int getNextNumber(int n) {
		int count=0;
		while (n>0) {
			count+=factorial(n%10);
			n/=10;
		}
		return count;
	}
	
	public static int factorial(int n) {
		if (n == 0) return 1;
		int count=1;
		for (int i=1; i<=n; i++) {
			count*=i;
		}
		return count;
	}
	
	public static void main(String[] args) {
		int curr;
		int count=0;
		for (int i=1; i<=1000000; i++) {
			curr=i;
			Set<Integer> s = new HashSet<Integer>();
			while (s.size()<61 && !s.contains(curr)) {
				s.add(curr);
				curr = getNextNumber(curr);
			}
			if (s.size()==60) {
				count++;
			}
		}
		System.out.println(count);
	}

}
