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
DC#113_Medium
This problem was asked by Google.

Given a string of words delimited by spaces, reverse the words in string. For example, given "hello world here", return "here world hello"

Follow-up: given a mutable string representation, can you perform this operation in-place?
 **/
public class DC113_ReverseStringiWSpaceDel {
	// we can scan string from the first and when we meet a space we can store a word we've been reading through
	// we want to reverse the order of words, ie. a word we meet first has to be written later that we would meet later
	// for the case, we could use Stack
	//
	// TODO : what about in-place reverse??
	static Stack<String> s = new Stack<>();

	public static void parseNStack(String stc) {
		String word = null;
		int prev = 0;
		for(int i=0; i<stc.length(); i++) {
			if(stc.charAt(i)==' ') { word = stc.substring(prev, i); s.push(word); prev=i;}
		}
		s.push(stc.substring(prev));
	}

	public static void reverse(String stc) {
		parseNStack(stc);
		while(!s.empty()) {
			System.out.print(s.pop() + " ");
		}
	}

	public static void swap(char[] c, int f, int l) {
		char tmp = c[l];
		c[l] = c[f];
		c[f] = tmp;
	}

	public static char[] reverseInplace(char[] chars, int f, int l) {
		while(f<l) {
			swap(chars, f, l);
			f++;
			l--;
		}
		return chars;
	}

	public static char[] reversePart(char[] c, int s) {
		int f = s;
		int l = s;
		while(c[s]!=' ' && s < c.length) {
			s++;	
		}
		l = s-1;
		reverseInplace(c, f, l);
	}

	public static void main(String[] args) {
		reverse("Hello World here");
		System.out.println();
		System.out.println(reversePart(reverseInplace("Hellllllooooooo World Here")));
	}
}
