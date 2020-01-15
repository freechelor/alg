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

/**
Hi, here's your problem today. This problem was recently asked by Twitter:

Given a string with the initial condition of dominoes, where:

. represents that the domino is standing still
L represents that the domino is falling to the left side
R represents that the domino is falling to the right side

Figure out the final position of the dominoes. If there are dominoes that get pushed on both ends, the force cancels out and that domino remains upright.

Example:

Input:  ..R...L..R.
Output: ..RR.LL..RR
 */
public class FallingDominoes {
	// 1. TC : O(n), SC : O(n)
	// if we know both of left and right force at a point, we can decide the position of a domino at the point.
	// So, we should find the two forces by going through a given positions.
	public static void decidePosition(String pos) {
		if(pos==null||pos.length()<=1) System.out.println(pos);
		int[] left = new int[pos.length()];
		int[] right = new int[pos.length()];
		for(int i=0; i<pos.length(); i++) {
			if(pos.charAt(i)=='R') {
				right[i]=1;
			} else if(pos.charAt(i)=='L') {
				if(right[i-1]>0) right[i] = right[i-1] + 1;
			} else {
				if(i==0) { right[i]=0; continue; }
				if(pos.charAt(i-1)=='L') right[i] = 0;
				else if(right[i-1]>0) right[i] = right[i-1] + 1;
			}
		}
		for(int i=0; i<right.length; i++) {
			System.out.print(right[i]);
		}
		System.out.println();

		for(int j=pos.length()-1; j>=0; j--) {
			if(pos.charAt(j)=='L') {
				left[j] = 1;
			} else if(pos.charAt(j)=='R') {
				if(left[j+1]>0) left[j] = left[j+1] + 1;
			} else {
				if(j==pos.length()-1) { left[j] = 0; continue; }
				if(pos.charAt(j+1)=='R') left[j] = 0;
				else if(left[j+1]>0) left[j] = left[j+1] + 1;
			}
		}
		for(int i=0; i<left.length; i++) {
			System.out.print(left[i]);
		}
		System.out.println();
		for(int i=0; i<pos.length(); i++) {
			if(pos.charAt(i)=='R'||pos.charAt(i)=='L') { System.out.print(pos.charAt(i)); continue; }
			if(left[i]==0 && right[i]==0) System.out.print(".");
			else if(right[i]==0) {
				System.out.print("L");
			} else if(left[i]==0) {
				System.out.print("R");
			} else {
				if(right[i]-left[i]==0) System.out.print(".");
				else if(right[i]-left[i]>0) System.out.print("L");
				else System.out.print("R");
			}
		}
	}

	public static void decidePositionBydistance(String pos) {
		int rIdx = -1;
		int lIdx = -1;
		for(int j=0; j<pos.length(); j++) {
			int i=j;
			while(i-->=0) {
				if(pos.charAt(i)=='R') { 
					rIdx=i;
					break;
				} else if(pos.charAt(i)=='L') {
					rIdx=-1;
					break;
				}
			}
			i=j;
			while(i++<pos.length()) {
				if(pos.charAt(i)=='L') {
					lIdx=i;
					break;
				} else if(pos.charAt(i)=='R') {
					lIdx=-1;
					break;
				}
			}
			if(Math.abs(i-rIdx)<Math.abs(lIdx)) System.out.print("R");
			else if(Math.abs(i-rIdx)>Math.abs(lIdx)) System.out.print("L");
			else System.out.print(".");
		}
	}

	public static void main(String[] args) {
		String given = "..R...L..R.";
		System.out.println("\nINPUT : " + given);
		decidePosition(given);
		given = "..RR...L..R..L..L..R.L.R.LL..R.";
		System.out.println("\nINPUT : " + given);
		decidePosition(given);
	}
}
