package alg.rcs;

public class NCents {
	static int QUATER = 25;
	static int DIME = 10;
	static int NICKEL = 5;
	static int PENNY = 1;
	static int[] cache = new int[1000];

	static int getWays(int n) {
		cache[0] = 1;
		cache[1] = 1;
		cache[5] = 2;
		if(n<0) return 0;
		if(n==0) return cache[0];
		// using cache
		if(cache[n]!=0) return cache[n];
		// caching
		cache[n] = getWays(n-QUARTER) + getWays(n-DIME) + getWays(n-NICKEL) + getWays(n-PENNY);
		return cache[n];
	}

	public static void main(String args[]) {
		NCents cents = new NCents();
		System.out.println(cents.getWays(26));
	}
}
/*
27

(27-25) + (27-10) + (27-5) + (27-1)

(2-25)=0 + (2-10)=0 + (2-5)=0 + (2-1)=1
									(1-25)+ (1-10)+(1-5)+(1-1)
(17-25)=0 + (17-10)=7 + (17-5)=12 + (17-1)=16
(22-25)=0 + (22-10)=12 + (22-5)=17 + (22-1)=21
(26-25)=1 + (26-10)=16 + (26-5)=21 + (26-1)=25
*/
