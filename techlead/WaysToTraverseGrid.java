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
package alg.techlead;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class WaysToTraverseGrid {
	/**
	 * if we traverse N x M grid, 
	 * we can first move to right and then traverse N x (M-1)
	 * or we can first move to downward and then traverse (N-1) X M
	 * because we can go right or downward only. 
	 *
	 * TC : O(2^k), where k is smaller one among n and m
	 * SC : O(n+m)
	 */
	public static int getWays(int n, int m) {
		if(n==0&&m==0) return 0;
		if(n==0||m==0) return 1;
		// right move + down first move
		return getWays(n, m-1) + getWays(n-1, m);
	}

	static int[][] cache = null;
	public static int getWaysDynamic(int n, int m) {
		if(n==0&&m==0) return 0;
		if(n==0||m==0) return 1;
		// right move + down first move
		if(cache[n][m]!=-1) return cache[n][m];
		cache[n][m] = getWays(n, m-1) + getWays(n-1, m);
		return cache[n][m];
	}

	public static void main(String[] args) {
		int n = 30;
		int m = 15;
		long s = System.currentTimeMillis();
		System.out.println(getWays(n-1,m-1));
		System.out.println((System.currentTimeMillis()-s));
		cache = new int[n][m];
		for(int i=0; i<n; i++) {
			Arrays.fill(cache[i], -1);
		}
		s = System.currentTimeMillis();
		System.out.println(getWaysDynamic(n-1,m-1));
		System.out.println((System.currentTimeMillis()-s));
	}
}
