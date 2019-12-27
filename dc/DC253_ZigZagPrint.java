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
 * DC#253_Medium
This problem was asked by PayPal.

Given a string and a number of lines k, print the string in zigzag form. In zigzag, characters are printed out diagonally from top left to bottom right until reaching the kth line, then back up to top right, and so on.

For example, given the sentence "thisisazigzag" and k = 4, you should print:

t     a     g
 h   s z   a
  i i   i z
   s     g

TC : O(n*k)
SC : O(1)
**/
public class DC253_ZigZagPrint {
	// there are 3 kinds of spaces
	// first is distance from the leftmost
	// second gets narrower from the top : space on the top - row*2
	// third gets wider from the top : space on the top + row*2-1
	// first and then repeat(second + third)
	
	public static void printZigZag(String str, int k) {
		int fs = 0;
		int ss = (k-1)*2-1;
		int ts = 0;
		for(int i=0; i<k; i++) {	// line
			int j=0;
			while(j++<i) System.out.print(" ");
			System.out.print(str.charAt(i));
			int idx=i;
			while(idx<str.length()) {
				int r=0;
				while(r++<ss) System.out.print(" ");
				if(ss!=0) {
					if(idx+ss+1<str.length()) System.out.print(str.charAt(idx=(idx+ss+1)));	
					else break;
				}
				r=0;
				while(r++<ts) System.out.print(" ");
				if(ts!=0) {
					if(idx+ts+1<str.length()) System.out.print(str.charAt(idx=(idx+ts+1)));	
					else break;
				}
			}
			System.out.println();
			ss -= 2;
			if(ss<0) ss = 0;
			ts = 2*i+1;
			if(ts>(k-1)*2-1) ts = (k-1)*2-1;
		}
	}

	public static void main(String[] args) {
		printZigZag("thisisazigzag", 4);	
	}
}
