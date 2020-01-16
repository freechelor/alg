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
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

/**
This is your coding interview problem for today.

This problem was asked by Spotify.

Write a function, throw_dice(N, faces, total), 
that determines how many ways it is possible to throw N dice with some number of faces each to get a specific total.

For example, throw_dice(3, 6, 7) should equal 15.
*/
public class DC272 {
	// 2. TC :  	, SC : O(n) <- n*t(for cache)+n(for call stack)
	// 	DP(Dynamic Programming)
	public static int findWaysDP(int n, int f, int target) {
		if(cache[n][target]!=-1) return cache[n][target];
		if(n==1&&target<=f) {
			cache[n][target] = 1;
			return 1;
		}
		if(n*f<target) {
			cache[n][target] = 0;
			return 0;
		}
		int ways = 0;
		for(int i=1; i<=target-n+1&&i<=f; i++) {
			ways += findWaysDP(n-1, f, target-i);	
		}
		cache[n][target] = ways;
		return ways;
	}

	// 1. TC : O(f^n), SC : O(n)
	// i.e. 3 dices, 6 faces, target 7
	// (1, 1, 5), (1, 2, 4), (1, 3, 3), (1, 4, 2), (1, 5, 1)
	// (2, 1, 4), (2, 2, 3), (2, 3, 2), (2, 4, 1)
	// (3, 1, 3), (3, 2, 2), (3, 3, 1)
	// (4, 1, 2), (4, 2, 1)
	// (5, 1, 1)
	public static int findWays(int n, int f, int target) {
		if(n==1&&target<=f) return 1;
		if(n*f<target) return 0;
		int ways = 0;
		for(int i=1; i<=target-n+1&&i<=f; i++) {
			ways += findWays(n-1, f, target-i);	
		}
		return ways;
	}

	static int cache[][] = null; 

	public static void init(int[][] arr) {
		for(int i=0; i<arr.length; i++) {
			Arrays.fill(arr[i], -1);
		}
	}

	public static void main(String[] args) {
		int n = 3; int f=6; int t=7;
		cache = new int[n+1][t+1];
		init(cache);
		System.out.println(findWaysDP(n, f, t));
		System.out.println(findWays(n, f, t));
		n = 11; f=8; t=65;
		cache = new int[n+1][t+1];
		init(cache);
		long start = System.currentTimeMillis();
		System.out.println(findWaysDP(n, f, t));
		System.out.println(System.currentTimeMillis()-start);

		start = System.currentTimeMillis();
		System.out.println(findWays(n, f, t));
		System.out.println(System.currentTimeMillis()-start);
	}
}
