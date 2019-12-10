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
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class MyStack {
	// using a single queue
	private Queue<Object> q = new LinkedList<>();
	public void push(Object obj) {
		int size = q.size();
		q.add(obj);
		for(int i=0; i<size; i++) {
			Object o = q.remove();
			q.add(o);
		}
	}

	public Object pop() {
		if(q.size()==0) return null;
		return q.remove();
	}

	public int size() {
		return q.size();
	}

	// using two queues
	// push load heavy
	private Queue<Object> q1 = new LinkedList<>();	//temporary holder
	private Queue<Object> q2 = new LinkedList<>();	
	public void push2(Object obj) {
		int size = q1.size();
		q1.add(obj);
		while(!q2.isEmpty()) {
			q1.add(q2.peek());
			q2.remove();
		}
		Queue<Object> tmp = q2;
		q2 = q1;
		q1 = tmp;
	}
	
	public Object pop2() {
		if(q2.isEmpty()) return null;
		return q2.remove();
	}

	public int size2() {
		return q2.size();
	}

	// using two queues
	// pop load heavy
	private Queue<Object> q3 = new LinkedList<>();	//temporary holder
	private Queue<Object> q4 = new LinkedList<>();	
	public void push3(Object obj) {
		q3.add(obj);
	}
	
	public Object pop3() {
		if(q3.isEmpty()) return null;
		while(q3.size()!=1) {
			q4.add(q3.peek());
			q3.remove();
		}
		Object popped = q3.remove();
		Queue<Object> tmp = q3;
		q3 = q4;
		q4 = tmp;
		return popped;
	}

	public int size3() {
		return q3.size();
	}

	public static void main(String[] args) {
		MyStack s = new MyStack();
		s.push("1");
		s.push("2");
		s.push("3");
		s.push("4");
		s.push("5");
		s.pop();
		s.push("11");
		s.push("21");
		s.push("31");
		s.pop();
		int size = s.size();
		for(int i=0; i<size; i++) {
			System.out.println(s.pop());
		}

		System.out.println("=========================================");
		s.push2("11");
		s.push2("21");
		s.push2("31");
		s.push2("41");
		s.push2("51");
		s.pop2();
		s.push2("111");
		s.push2("211");
		s.push2("311");
		s.pop2();
		size = s.size2();
		for(int i=0; i<size; i++) {
			System.out.println(s.pop2());
		}

		System.out.println("=========================================");
		s.push3("11");
		s.push3("21");
		s.push3("31");
		s.push3("41");
		s.push3("51");
		s.pop3();
		s.push3("111");
		s.push3("211");
		s.push3("311");
		s.pop3();
		size = s.size3();
		for(int i=0; i<size; i++) {
			System.out.println(s.pop3());
		}
	}
}
