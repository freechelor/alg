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
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

// TODO : Consider Generic
public class MyQueue {
	// 1. using linkedlist
	// 		have to implement my own linkedlist
	private Node first = null;
	private Node last = null;
	private int count = 0;
	public void add(Object obj) {
		Node n = new Node(obj);
		if(last==null) {
			first = n;
			last = n;
			//first.next = last;
			last.next = null;
			count++;
			return;
		}
		count++;
		last.next = n;
		last = n;
	}	

	public Object remove() {
		if(first==null) return null;
		Object tmp = first.obj;
		first = first.next;
		count--;
		return tmp;
	}

	public int size() {
		return count;
	}



	// 2. using stack
	public static void main(String[] args) {
		MyQueue mQ = new MyQueue();
		mQ.add("1");
		mQ.add("2");
		mQ.add("3");
		mQ.add("4");
		mQ.add("5");
		System.out.println(mQ.remove());
		System.out.println(mQ.remove());
		System.out.println(mQ.remove());
		System.out.println(mQ.remove());
		System.out.println(mQ.remove());
		System.out.println(mQ.remove());
	}
}

class Node {
	public Node next;
	public Object obj;

	public Node(Object obj) {
		this.obj = obj;
	}
}
