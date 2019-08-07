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
DC#65_Easy
This problem was asked by Amazon.

Given a N by M matrix of numbers, print out the matrix in a clockwise spiral.

For example, given the following matrix:

[[1,  2,  3,  4,  5],
 [6,  7,  8,  9,  10],
 [11, 12, 13, 14, 15],
 [16, 17, 18, 19, 20]]
You should print out the following:

1
2
3
4
5
10
15
20
19
18
17
16
11
6
7
8
9
14
13
12
TC : O(N x M), SC : O(1)
 **/
public class DC65_PrintNbyMInSpiral {
	public static void printSpiral(int[][] arr) {
		int ub = 0;
		int bb = arr.length-1;
		int lb = 0;
		int rb = arr[0].length-1;
		int r =0;
		int c =0;
		// @TODO : just check why total count is in need.
		int total = arr.length*arr[0].length;
		while(ub<=bb && lb<=rb && total>0) {
			System.out.println( ub + " : " + bb + " : " + lb + " : " + rb);
			while(c<rb && total>0) {
				System.out.println(arr[r][c]);
				c++;
				total--;
			}
			ub++;
			while(r<bb && total>0) {
				System.out.println(arr[r][c]);
				r++;
				total--;
			}
			rb--;
			while(c>lb && total>0) {
				System.out.println(arr[r][c]);
				c--;
				total--;
			}
			bb--;
			while(r>ub && total>0) {
				System.out.println(arr[r][c]);
				r--;
				total--;
			}
			lb++;
		}

		if(total>0) {
			System.out.println(arr[r][c]);
			total--;
		}
	}

	public static void main(String[] args) {
		int[][] arr2 = new int[][] {
		 {1,  2,  3,  4,  5},
		 {6,  7,  8,  9,  10},
		 {11, 12, 13, 14, 15},
		 {16, 17, 18, 19, 20},
//		 {16, 17, 18, 19, 20},
		 {26, 27, 28, 29, 30}};

		int[][] arr = new int[][] {
		 {1,  2,  3,  4,  5, 91 },
		 {6,  7,  8,  9,  10, 92},
		 {11, 12, 13, 14, 15, 93},
		 {16, 17, 18, 19, 20, 94},
		 {21, 22, 23, 24, 25, 95}};

		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		printSpiral(arr);
	}
}
