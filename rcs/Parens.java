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
package alg.rcs;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class Parens {
	static void getParens(List<String> list, int n) {
		parens(list, "", n, n, n);
	}

	static void parens(List<String> list, String res, int n, int op, int cl) {
		if(0==op&&0==cl) {
			System.out.println("ADD RESULT");
			list.add(res);
			return;
		}
		// at the beginning
		if(n==op) {
			res = "(";
			parens(list, res, n, op-1, cl);
		} else {
			// if open parens are still available, anytime they could be selected
			if(op>0) parens(list, res+"(", n, op-1, cl);
			// ONLY when open parens are used more than close parens and OF COURSE close parens are stil available(>0), close parens could be selected
			if(op<cl&&cl>0) parens(list, res+")", n, op, cl-1);
		}
	}
	// ()
	// ()() (())
	// ()()() ()(()) (()()) (())() ((()))
	public static void main(String[] args) {
		List<String> list = new ArrayList<String>();
		getParens(list, 4);
		list.forEach(u->System.out.println(u));
	}
}

// TODO :
// Stack Memory(for recursive calls) vs Heap Memory
