package euler;

public class problem76 {
	
	public static int numOfWays(int num) {
		if (num==0) return 1;
		int sum=0;
		for (int i=1; i<num; i++) {
			sum+=(AuxNumOfWays(num-i,i));
		}
		return sum;
	}
	
	public static int AuxNumOfWays(int num, int max) {
		if (num==0) return 1;
		if (num<0) return 0;
		int sum=0;
		for (int i=max; i>=1; i--) {
			sum+=AuxNumOfWays(num-i, i);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(numOfWays(100));
	}

}
