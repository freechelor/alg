/**
 * TODO : 
 * 1. Time/Space Complexity Analysis
 * 		BUT, MOST OF ALL, IT IS IMPORTANT TO 1.1. LIST POSSIBLE/AVAILABLE SOLUTIONS AND 1.2. THINK ABOUT COMPLEXITY FIRST AND IN ADVANCE,
 * 		1.3. START WITH BEST COMPLEXITY SOLUTION
 * 2. Improve Algorithm/Performance
 * 3. Learn unfamiliar syntax 
 * 4. Any other ways to consider + compare in terms of Time/Space complexity
 *
 */
package alg.category;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class Fibo {
	/*
	 * TC : O(2^n)
	 * SC : if we consider function call stack size O(n), if not O(1)
	 * https://www.geeksforgeeks.org/program-for-nth-fibonacci-number/
	 *
	 */
	public static int fibo(int n) {
		// base case
		// fibo(0) = 0, fibo(1) = 1
		// 1. recursive
		if(n<=1) return n;
		return fibo(n-2) + fibo(n-1);
	}

	/*
	 * TC : O(n)
	 * SC : O(n)
	 */
	public static int fiboIter(int n) {
		int[] fib = new int[n+1];
		Arrays.fill(fib, -1);
		fib[0] = 0;
		fib[1] = 1;
		if(n<=1) return fib[n];
		for(int i=2; i<fib.length; i++) {
			fib[i] = fib[i-1] + fib[i-2];
		}
		return fib[n];

	}

	/*
	 * TC : O(n)
	 * SC : O(1)
	 */
	public static int fiboShort(int n) {
		if(n<=1) return n;
		int a = 0;
		int b = 1;
		int r = a+b;
		for(int i=2; i<n; i++) {
			a = b;
			b = r;	
			r = a+b;
		}
		return r;
	}

	public static void main(String[] args) {
		int N = 9;
		System.out.println(fibo(N));
		System.out.println(fiboIter(N));
		System.out.println(fiboShort(N));
	}
}
