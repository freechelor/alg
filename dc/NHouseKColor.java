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
DC#19_Medium
This problem was asked by Facebook.

A builder is looking to build a row of N houses that can be of K different colors. 
He has a goal of minimizing cost while ensuring that no two neighboring houses are of the same color.

Given an N by K matrix where the nth row and kth column represents the cost to build the nth house with kth color, 
return the minimum cost which achieves this goal.
 **/
public class NHouseKColor {
	static int min = Integer.MAX_VALUE;

	public static int getMin(int[][] m, int r, int c) {
		if(r>=m.length) return 0;
		for(int i=0; i<m[0].length; i++) {
			if(c!=i) {
				int v = m[r][i] + getMin(m, r+1, i);
				if(v<min) min = v;
			}	
		}	
		return min;
	}

	public static void main(String[] args) {
		int[][] cost = new int[][] {
			{ 10, 11, 15, 9, 13},
			{ 20, 16, 15, 3, 10},
			{ 10, 12, 43, 59, 29},
			{ 4, 11, 12, 9, 51},
			{ 30, 31, 15, 19, 44},
			{ 8, 21, 35, 2, 12},
			{ 10, 11, 15, 9, 32},
			{ 12, 19, 15, 39, 23},
		};
		getMin(cost, 0, -1);
		System.out.println("Minimum : " + min);
	}
}
