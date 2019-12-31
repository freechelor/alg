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
Hi, here's your problem today. This problem was recently asked by AirBNB:

Given two strings, determine the edit distance between them. 
The edit distance is defined as the minimum number of edits (insertion, deletion, or substitution) needed to change one string to the other.

For example, "biting" and "sitting" have an edit distance of 2 (substitute b for s, and insert a t).

TC : O(n^3)
SC : O(n^3)
*/
public class EditDistance {
	static int[][] eDis = null;
	public static int getEditDistance(String s1, int idx1, String s2, int idx2) {
		if(idx1<s1.length()&&idx2<s2.length()) {
			if(eDis[idx1][idx2]>=0) return eDis[idx1][idx2];
		}
		if(s1==null&&s2==null) {
			return 0;
		}
		if(s1==null||s1.length()==0) return s2.length();
		if(s2==null||s2.length()==0) return s1.length();
		if(s1.length()==idx1) {
			if(s2.length()==idx2) return 0;
			else return s2.length()-idx2;
		} else if(s2.length()==idx2) {
			return s1.length()-idx1;
		}
		if(s1.charAt(idx1)==s2.charAt(idx2)) {
			return getEditDistance(s1, idx1+1, s2, idx2+1);
		} else {
			int chg = 1+getEditDistance(s1, idx1+1, s2, idx2+1);
			int del1 = 1+getEditDistance(s1, idx1+1, s2, idx2);
			int del2 = 1+getEditDistance(s1, idx1, s2, idx2+1);
			eDis[idx1][idx2] = Math.min(Math.min(chg,del1), del2);
			return eDis[idx1][idx2];
		}
	}

	public static void main(String[] args) {
		String s1="rbiating";
		String s2="sitting";
		s1 = "kittenworkkitten";
		s2 = "sittingrorksitting";
		eDis = new int[s1.length()+1][s2.length()+1];
		for(int i=0; i<eDis.length; i++) {
			Arrays.fill(eDis[i], -1);
		}
		System.out.println(getEditDistance(s1, 0, s2, 0));
	}
}
