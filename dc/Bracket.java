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

public class Bracket {
	public static Stack<String> st = new Stack<String>();

	public boolean matching(String a, String b) {
		if(a.equals("{") && b.equals("}")) {
			return true;
		}
		if(a.equals("[") && b.equals("]")) {
			return true;
		}
		if(a.equals("(") && b.equals(")")) {
			return true;
		}
		return false;
	}

	public boolean put(String b) {
		if(st.empty()) { 
			st.push(b);
			return true;
		}
		String prev = st.peek();
		if(matching(prev, b)) {
			st.pop();
		} else if(b.equals("[") || b.equals("{") || b.equals("(")) {
			st.push(b);
		} else {
			return false;
		}
		return true;
	}


	public static void main(String[] args) {
		Bracket br = new Bracket();
		String set = "{[]}({{[]()([{})}})"; //args[0]; 
		String[] sets = set.split("");
		for(int i=0; i<sets.length; i++) {
			if(!br.put(sets[i])) {
				System.out.println("NOT well formed!");
				break;
			}	
		}
		if(st.size()==0) System.out.println("Well formed!!");
	}
}
