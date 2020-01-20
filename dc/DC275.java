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
DC#275_MEDIUM
This problem was asked by Epic.

The "look and say" sequence is defined as follows: beginning with the term 1, 
each subsequent term visually describes the digits appearing in the previous term. 
The first few terms are as follows:

1
11
21
1211
111221
312211
13112221
1113213211
31131211131221

As an example, the fourth term is 1211, since the third term consists of one 2 and one 1.

Given an integer N, print the Nth term of this sequence.
 */
public class DC275 {
	
	// What is complexity?	
	public static String visualPrint(String s, int n) {
		if(s==null||s.length()==0) return null;
		while(--n>0) {
			String result = "";
			char cur = s.charAt(0);
			char prev = s.charAt(0);
			int cnt=0;
			for(int i=0; i<s.length(); i++) {
				cur = s.charAt(i);
				if(cur==prev) cnt++;
				else {
					result += cnt+""+prev;
					prev = cur;
					cnt = 1;
				}
			}
			result += cnt+""+cur;
			s = result;
		}
		return s;
	}

	public static void main(String[] args) {
		System.out.println(visualPrint("1", 2));
		System.out.println(visualPrint("1", 3));
		System.out.println(visualPrint("1", 4));
		System.out.println(visualPrint("1", 5));
		System.out.println(visualPrint("1", 6));
		System.out.println(visualPrint("1", 7));
	}
}
