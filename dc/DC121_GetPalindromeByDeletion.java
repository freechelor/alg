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

TC : O(2^n), SC : O(2^n)
**/

public class DC121_GetPalindromeByDeletion {
	// let's assume that we could get palindrome from a given string,
	// I. if the first element and the last element are the same, we move to the next elements, let say the second element and the element just right before the last element.
	// II. if two element are not the same, we remove the left element and do step I. And we remove the right element and do step I. And we increase count of removed elements by 1.
	// III. if the count goes over k, return false. if not, repeat step II.

	public static boolean getPalindrome(String s, int k, int count, int l, int r) {
		System.out.println("l : " + l + " r : " + r + ", length = " + s + ", k = " + k + " , count = " + count);
		if(k<count) return false;	
		if(l>=r) return checkPalindrome(s);
		System.out.println("l : " + l + " r : " + r + ", length = " + s);
		if(s.charAt(l)==s.charAt(r)) return getPalindrome(s, k, count, l+1, r-1);	
		else {
			String tmp1 = s.substring(0,r) + s.substring(r+1);
			String tmp2 = s.substring(0,l) + s.substring(l+1);
			boolean one = getPalindrome(tmp1, k, count+1, l, r-1);
			boolean two = getPalindrome(tmp2, k, count+1, l+1, r-1);
			return (one||two);
		}
	}

	public static boolean checkPalindrome(String s) {
		System.out.println("check Palindrome : " + s);
		int l =0;
		int r = s.length()-1;
		while(l<r) {
			if(s.charAt(l)==s.charAt(r)) {l++; r--;}
			else return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println(getPalindrome("waterrfetawx", 2, 0, 0, "waterrfetawx".length()-1));
	}
}
