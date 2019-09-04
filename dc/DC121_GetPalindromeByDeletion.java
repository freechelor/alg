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
This problem was asked by Google.

Given a string which we can delete at most k, return whether you can make a palindrome.

For example, given 'waterrfetawx' and a k of 2, you could delete f and x to get 'waterretaw'.
**/

public class DC121_GetPalindromeByDeletion {
	// let's assume that we could get palindrome from a given string,
	// I. if the first element and the last element are the same, we move to the next elements, let say the second element and the element just right before the last element.
	// II. if two element are not the same, we remove the left element and do step I. And we remove the right element and do step I. And we increase count of removed elements by 1.
	// III. if the count goes over k, return false. if not, repeat step II.

	static int count = 0;
	public static boolean getPalindrome(String s, int k, int count, int l, int r) {
		if(k<count) return false;	
		if(l>r) checkPalindrome(
		if(s.elementAt(l)==s.elementAt(r)) return getPalindrome(s, k, count, l+1, r-1);	
	}

	public static void main(String[] args) {
		System.out.println(getPalindrome("waterrfetawx", 2, 0, 0, "waterrfetawx".length()-1));
	}
}
