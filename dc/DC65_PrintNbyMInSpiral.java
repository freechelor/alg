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
 **/
public class DC65_PrintNbyMInSpiral {
	public static void printSpiral(int[][] arr) {
		int ub = 0;
		int bb = arr.length-1;
		int lb = 0;
		int rb = arr[0].length-1;
		int r =0;
		int c =0;
		System.out.println( bb + ":" + rb);
		while(ub<bb && lb<rb) {
			while(c<rb) {
				System.out.println(arr[r][c]);
				c++;
			}
			ub++;
			while(r<bb) {
				System.out.println(arr[r][c]);
				r++;
			}
			rb--;
			while(c>lb) {
				System.out.println(arr[r][c]);
				c--;
			}
			bb--;
			while(r>ub) {
				System.out.println(arr[r][c]);
				r--;
			}
			lb++;
		}
	}

	public static void main(String[] args) {
		int[][] arr = new int[][] {
		 {1,  2,  3,  4,  5},
		 {6,  7,  8,  9,  10},
		 {11, 12, 13, 14, 15},
		 {16, 17, 18, 19, 20}};
		printSpiral(arr);
	}
}
