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

public class Query {
	public String[] getWords(String s, String[] set) {
		Vector<String> v = new Vector<String>();
		for(String r : set) {
			boolean matched = false;
			for(int i =0; i < s.length(); i++) {
				if(s.charAt(i)==r.charAt(i)) {
					matched = true;
				} else {
					matched = false;	
					break;
				}
			}
			if(matched) v.add(r);
		}
		String[] res = new String[v.size()];
		v.copyInto(res);
		return res;
	}

	public static void main(String[] args) {
		String q = "de";
		String[] s = {"dog", "denote", "design", "debris", "star", "moon", "sun", "delta"};
		String[] result = (new Query()).getWords(q, s);
		for(String a:result) 
		{
			System.out.print(a + ",");
		}
		System.out.println();
	}
}
