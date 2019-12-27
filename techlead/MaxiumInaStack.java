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
https://mail.google.com/mail/u/1/#inbox/FMfcgxwGCZwpHqGVfpQQKXdwlbdvmjNt
 **/
public class MaxiumInaStack {
	static Stack<Pair> s = new Stack<>();
	public static void push(int v) {
		if(!s.isEmpty()) {
			Pair e = s.peek();
			if(e.max<v) {
				s.push(new Pair(v, v));
			} else {
				s.push(new Pair(v, e.max));
			}
		} else s.push(new Pair(v, v));
	}

	public static int pop() {
		return s.pop().value;
	}

	public static int max() {
		return s.peek().max;
	}

	public static void main(String[] args) {
		push(3);
		System.out.println(max());
		push(2);
		System.out.println(max());
		push(5);
		System.out.println(max());
		push(1);
		System.out.println(max());
		push(3);
		System.out.println(max());
		push(9);
		System.out.println(max());
		push(8);
		System.out.println(max());
		pop();
		System.out.println(max());
		pop();
		System.out.println(max());
		pop();
		System.out.println(max());
		pop();
		System.out.println(max());
		pop();
		System.out.println(max());
		pop();
		System.out.println(max());
	}
/*
	static class Pair {
		int value;
		int max;
		public Pair(int v, int m) {
			value = v;
			max = m;
		}
	}
	*/
}

class Pair {
	int value;
	int max;
	public Pair(int v, int m) {
		value = v;
		max = m;
	}
}
