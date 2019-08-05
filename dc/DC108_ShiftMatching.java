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
import java.util.Vector;


/**
  DC108_Easy
  This problem was asked by Google.

  Given two strings A and B, return whether or not A can be shifted some number of times to get B.

  For example, if A is abcde and B is cdeab, return true. If A is abc and B is acb, return false.^[

TC : O(n^2), SC : O(n)
 **/
public class DC108_ShiftMatching {
	public static Vector find(char c, String s) {
		char[] cs = s.toCharArray();
		Vector<Integer> v = new Vector<>();
		for(int i=0; i<cs.length; i++) {
			if(c==cs[i]) v.add(i);
		}
		return v;
	}

	public static boolean cyclic(String a, String b, int idx) {
		for(int i=0; i<a.length(); i++) {
			if(a.charAt(i)==b.charAt((idx+i)%a.length())) {
			} else return false;
		}
		return true;
	}

	public static void main(String[] args) {
		String a = "abcde";
		String b = "cdaeb";

		if(a.length()==b.length()) {
			Vector<Integer> idx = find(a.toCharArray()[0], b);
			for(int i=0; i<idx.size(); i++) {
				if(cyclic(a, b, idx.get(i))) {System.out.println("true"); return;}
			}
		} else {
			System.out.println("false");
		}
		System.out.println("false");
	}
}
