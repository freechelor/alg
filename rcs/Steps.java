package alg.rcs;

public class Steps {
	static long getWays(int n) {
		// base cases
		if(n==0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 4;
		// w(4) = w(3) + w(2) + w(1) = 4 + 2+ 1 = 7
		// w(5) = w(4) + w(3) + w(2) = 7 + 4 + 2 = 13
		return getWays(n-1)+getWays(n-2)+getWays(n-3);
	}

	static long getWays(int n, long[] c) {
		// base cases
		if(n==0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 4;
		// use cache
		if(c[n]!=0) return c[n];
		c[n] = getWays(n-3, c)+getWays(n-2, c)+getWays(n-1, c);
		return c[n];
	}

	// TODO : what is the best way to keep memory usage low, as paramters or global variables? 
	// TODO : have to know how java manages stack and heap memory 
	static long getWaysDynamics(int n, long[] c) {
		// base cases
		if(n==0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 4;
		c[0] = 0; c[1] = 1; c[2] = 2; c[3] = 4;
		for(int i=4; i < n; i++) {
			//if(c[i]!=0) return c[i];
			c[i] = c[i-3] + c[i-2] + c[i-1];
		}
		return c[n-3]+c[n-2]+c[n-1];
	}

	static long getWaysDynamicsOpt(int n) {
		// base cases
		if(n==0) return 0;
		if(n==1) return 1;
		if(n==2) return 2;
		if(n==3) return 4;
//		c[0] = 0; c[1] = 1; c[2] = 2; c[3] = 4;
		long a = 4;
		long b = 2;
		long d = 1;
		long e;
		for(int i=4; i < n; i++) {
			e = a + b + d;
			d = b;
			b = a;
			a = e;
			//c[i] = c[i-3] + c[i-2] + c[i-1];
		}
		return a + b + d;
	}

	public static void main(String args[]) {
		int cnt = Integer.parseInt(args[0]);
		//long s = System.nanoTime();
		//System.out.println(getWays(cnt));
		//System.out.println((System.nanoTime()-s));
		long[] cache = new long[cnt+1];
		System.out.println("==========Top Down==============");
		long s = System.nanoTime();
		System.out.println(getWays(cnt, cache));
		System.out.println((System.nanoTime()-s));

		long[] cache2 = new long[cnt];
		System.out.println("==========Bottom Up==============");
		s = System.nanoTime();
		System.out.println(getWaysDynamics(cnt, cache2));
		System.out.println((System.nanoTime()-s));

		System.out.println("==========Bottom Up-Saving==============");
		s = System.nanoTime();
		System.out.println(getWaysDynamicsOpt(cnt));
		System.out.println((System.nanoTime()-s));
	}
}
