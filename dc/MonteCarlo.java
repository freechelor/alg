package alg.dc;

/**
	The area of a circle is defined as PI*r^2. 
	Estimate PI to 3 decimal places using a Monte Carlo method.
	Hint: The basic equation of a circle is x2 + y2 = r2.
**/
import java.util.*;
import java.util.stream.*;

public class MonteCarlo {
	public static void main(String args[]) {
		double r = 1.0;
		int cnt = 0;
		int nCnt = 0;
		long limit = Integer.MAX_VALUE/100;
		Random ran = new Random();
		double[] x = ran.doubles(0,1).limit(limit).toArray();
		double[] y = ran.doubles(0,1).limit(limit).toArray();

//		System.out.println("LIMIT : " + limit/1000);
		for(int i = 0; i < x.length; i++) {
//			if(i<100) System.out.println(x[i] + " : " + y[i] + " : " + 
//					Math.pow(x[i],2) + Math.pow(y[i],2) + " : " + Math.pow(r,2));
			if((Math.pow(x[i],2) + Math.pow(y[i],2))<=Math.pow(r,2)) cnt++;
			else nCnt++;
		}	
		System.out.println("Fall in the circle : " + cnt);
		System.out.println("Fall out of the circle : " + nCnt);
		System.out.println(cnt*4/(double)limit);
		//PI * r^2/4 : r^2 = cnt : Max
		//r^2*cnt = PI * r^2/4 * MAX
		//cnt = PI *1/4 * MAX; 
		//PI = cnt * 4 /MAX;
	}
}
