/**
 *
 * TODO : 
 * 1. Time/Space Complexity Analysis
 * 		BUT, MOST OF ALL, IT IS IMPORTANT TO 1.1. LIST POSSIBLE/AVAILABLE SOLUTIONS AND 1.2. THINK ABOUT COMPLEXITY FIRST AND IN ADVANCE,
 * 		1.3. START WITH BEST COMPLEXITY SOLUTION
 * 2. Improve Algorithm/Performance
 * 3. Learn unfamiliar syntax 
 * 4. Any other ways to consider + compare in terms of Time/Space complexity
 *
 */
package alg.dc;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;
import java.util.stream.*;
import java.util.*;

public class MaxSum {
	public static int[] hdr = null;
	public int getMaxsumDP(int[] arr, int s) {
		if(arr==null||arr.length==0) return 0;
		if(s>arr.length-1) return 0;
		if(s==arr.length-1) if(arr[s]>0) return arr[s]; else return 0;
		if(s==arr.length-2) {
			if(arr[s]>arr[s+1])  if (arr[s]>0) return arr[s]; else return 0;
			else { if(arr[s+1]>0) return arr[s+1]; else return 0;} 
		}
		if(s<arr.length && hdr[s]!=Integer.MIN_VALUE) {
			return hdr[s];
		}
		return Math.max(hdr[s+1]=getMaxsumDP(arr, s+1), hdr[s+2]=(arr[s]+getMaxsumDP(arr, s+2)));
		//return Math.max(getMaxsum(arr, s+1), arr[s]+getMaxsum(arr, s+2));
	}

	public int getMaxsum(int[] arr, int s) {
		if(arr==null||arr.length==0) return 0;
		if(s>arr.length-1) return 0;
		return Math.max(getMaxsum(arr, s+1), arr[s]+getMaxsum(arr, s+2));
	}

	public static void main(String[] args) {

		Random random = new Random();
		//IntStream stream = random.ints(50, -100, 156);
		//int[] sData = stream.limit(50).toArray();
		//random.ints(50,100,156).forEach(System.out::println);
		IntStream stream = random.ints(50, -50, 100).limit(100);
		int[] sData = stream.toArray();
		for(int a:sData) System.out.print(a + ",");
		System.out.println();
		int[] data = { 3, 7, 0, 9, -10, 32, 9, 45, -12, -7, 11, 0 ,27, -3};
			
		hdr = new int[data.length];
		Arrays.fill(hdr, Integer.MIN_VALUE);

		long s = System.currentTimeMillis();
		System.out.println(new MaxSum().getMaxsum(data,0));
		System.out.println("Elapsed Time : " + (System.currentTimeMillis()-s));

		s = System.currentTimeMillis();
		System.out.println(new MaxSum().getMaxsumDP(data,0));
		System.out.println("Elapsed Time : " + (System.currentTimeMillis()-s));

		hdr = new int[sData.length];
		Arrays.fill(hdr, Integer.MIN_VALUE);

		s = System.currentTimeMillis();
		System.out.println(new MaxSum().getMaxsumDP(sData,0));
		System.out.println("Elapsed Time : " + (System.currentTimeMillis()-s));

		s = System.currentTimeMillis();
		System.out.println(new MaxSum().getMaxsum(sData,0));
		System.out.println("Elapsed Time : " + (System.currentTimeMillis()-s));

		IntStream stream2 = random.ints(50, -50, 100).limit(1000);
		int[] sData2 = stream2.toArray();

		hdr = new int[sData2.length];
		Arrays.fill(hdr, Integer.MIN_VALUE);

		s = System.currentTimeMillis();
		System.out.println(new MaxSum().getMaxsumDP(sData2,0));
		System.out.println("Elapsed Time : " + (System.currentTimeMillis()-s));

		s = System.currentTimeMillis();
		System.out.println(new MaxSum().getMaxsum(sData2,0));
		System.out.println("Elapsed Time : " + (System.currentTimeMillis()-s));
	}
}
