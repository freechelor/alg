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
package alg.stck;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class StackWithMin {

	public static void main(String[] args) {
		//int[] arr = new int[] { 5, 12, 1, 7, 11, 20, 3, 6 };
		//int[] arr = new int[] { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
		int[] arr = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		MyStack s = new MyStack();
		for(int a : arr ) {
			s.push(a);
		}
		while(!s.isEmpty()) {
			System.out.println(s.min());
			System.out.println(s.pop().value);
		}
	}
}

class ElementWithMin {
	public Integer min;
	public Integer value;

	public ElementWithMin(Integer v, Integer m) {
		value = v;
		min = m;
	}
}

class MyStack {
	public Stack<ElementWithMin> s = new Stack<>();
	
	public ElementWithMin push(Integer obj) {
		if(s.isEmpty()) {
			return s.push(new ElementWithMin(obj, obj.intValue()));
		}
		ElementWithMin prev = s.peek();
		if(prev.min>obj.intValue()) {
			return s.push(new ElementWithMin(obj, obj.intValue()));
		}
		return s.push(new ElementWithMin(obj, prev.min));
	}

	public ElementWithMin pop() {
		return s.pop();
	}

	public int min() {
		ElementWithMin p = s.peek();
		return p.min;
	}

	public boolean isEmpty() {
		return s.isEmpty();
	}
}
