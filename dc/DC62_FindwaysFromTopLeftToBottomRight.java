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
package alg.dc;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

/**
DC#62_Medium
This problem was asked by Facebook.

There is an N by M matrix of zeroes. 
Given N and M, write a function to count the number of ways of starting at the top-left corner 
and getting to the bottom-right corner. You can only move right or down.

For example, given a 2 by 2 matrix, you should return 2, since there are two ways to get to the bottom-right:

Right, then down
Down, then right
Given a 5 by 5 matrix, there are 70 ways to get to the bottom-right.
TC : O((N+M)!/N!M!), SC : O(1)
 **/
public class DC62_FindwaysFromTopLeftToBottomRight {
	//public static int ways = 0;

	public static int countWays(int N, int M) {
		if(N==0 && M==0) return 1;
		int down = 0;
		int right = 0;
		int ways = 0;
		/*
		if(N>0) down = countWays(N-1, M);
		if(M>0) right = countWays(N, M-1);
		*/
		if(N>0) ways = countWays(N-1, M);
		if(M>0) ways += countWays(N, M-1);
		//return down + right;
		return ways;
	}
	
	public static int factorial(int n) {
		int res = 1;
		while(n>0) {
			res *= n;
			n--;
		}
		return res;
	}

	public static int countWaysByMath(int N, int M) {
		return factorial(N-1+M-1)/factorial(N-1)/factorial(M-1);
	}

	public static void main(String[] args) {
		int N = 5;
		int M = 7;
		System.out.println("result : " + countWays(N-1,M-1));
		System.out.println("result by Math : " + countWaysByMath(N,M));

	}
}
