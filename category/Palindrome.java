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
package alg.category;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class Palindrome {
// 1. to find longest palindrome
// 	1.1. You can find it by a brute force way,
// 	I mean first iterate loop to find every substring from a given string,
//	and then check they are palindrome or not	
//	so it will take O(n^2) in TC to find every single substring and it will need O(n) for checking it is palindrome or not for each string. Its total TC is O(n^3)

// 	1.2. to avoid redundant check of palindrome I can use dynamic programming
//	first starting with just recursive
	//boolean[][] palindrome = new boolean[][];
	int max = 1;
	public int longestPalindrome(String s) {
		int i=0;
		int j=s.length();
		if(isPalindrome(s.substring(i,j))) {
			return j-i;
		}
		int left=0, right=0;
		if(i+1<s.length()) left = longestPalindrome(s.substring(i+1,j));
		if(j-1>=0) right = longestPalindrome(s.substring(i,j-1));
		//return Math.max(max,Math.max(left,right));
		return Math.max(left,right);
	}	

//	1.3. use DP
	private static int[][] palindrome = null;
	public int longestDPPalindrome(String s, int start, int end) {
		int i=start;
		int j=end;
		if(palindrome[i][j]>0) return palindrome[i][j];
		else {
			if(isPalindrome(s.substring(start,end+1))) {
				palindrome[i][j] = j-i+1;
				return palindrome[i][j];
			}
		}
		int left=0,right=0;
		if(i+1<s.length()) {
			if(palindrome[i+1][j]>0) left = palindrome[i+1][j];
			else left = longestDPPalindrome(s, i+1, j);
		}
		if(j-1>=0) {
			if(palindrome[i][j-1]>0) right = palindrome[i][j-1];
			else right = longestDPPalindrome(s, i, j-1);
		}
		palindrome[start][end]=Math.max(left, right);
		return palindrome[start][end];
	}

	private boolean isPalindrome(String s) {
		int i = 0;
		int j = s.length()-1;
		while(i<j) {
			if(s.charAt(i)==s.charAt(j)) {
				i++; j--;
			} else return false;
		}
		return true;
	}

// 2. to make a given string palindrome using minimum number of insertions



	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		String str = "geeksskeegforfabcdefggfedcba"; 
		palindrome = new int[str.length()][str.length()];
		for(int i=0; i<palindrome.length; i++) {
			Arrays.fill(palindrome[i],-1);
		}
		for(int i=0; i<palindrome.length; i++) {
			for(int j=0; j<palindrome.length; j++) {
				if(i==j) palindrome[i][j] = 1;
			}
		}
		System.out.println(p.longestPalindrome("geeksskeegfor"));
		System.out.println(p.longestPalindrome("abbargeeksskeegfor"));
		System.out.println(p.longestPalindrome("geeksskeegforfabcdefggfedcba"));
		System.out.println(p.longestDPPalindrome(str,0, str.length()-1));
		System.out.println(p.longestDPPalindrome("abbargeeksskeegfor", 0, "abbargeeksskeegfor".length()-1));
		System.out.println(p.longestDPPalindrome("geeksskeegfor", 0, "geeksskeegfor".length()-1));
	}
}
