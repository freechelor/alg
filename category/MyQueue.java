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
public class MyQueue<T> {
	// 1. using linkedlist
	// 		have to implement my own linkedlist
	private Node<T> first = null;
	private Node<T> last = null;
	private int count = 0;
	public void add(T obj) {
		Node<T> n = new Node(obj);
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

	public T remove() {
		if(first==null) return null;
		T tmp = first.obj;
		first = first.next;
		count--;
		return tmp;
	}

	public int size() {
		return count;
	}



	// 2. using stack
	private Stack stack = new Stack();
	private Stack stack2 = new Stack();
	public void add2(Object obj) {
		stack.push(obj);
	}

	public Object remove2() {
		if(stack2.isEmpty()) {
			if(stack.isEmpty()) return null;
			while(!stack.isEmpty()) {
				stack2.push(stack.pop());
			}
			return stack2.pop();
		}
		return stack2.pop();
	}

	public int size2() {
		return stack.size() + stack2.size();
	}

	public static void main(String[] args) {
		MyQueue<Integer> mQ = new MyQueue<>();
		mQ.add(1);
		mQ.add(2);
		mQ.add(3);
		mQ.add(4);
		mQ.add(5);
		System.out.println(mQ.remove() + ":" + mQ.size());
		mQ.add(6);
		mQ.add(7);
		System.out.println(mQ.remove() + ":" + mQ.size());
		System.out.println(mQ.remove() + ":" + mQ.size());
		System.out.println(mQ.remove() + ":" + mQ.size());
		System.out.println(mQ.remove() + ":" + mQ.size());
		System.out.println(mQ.remove() + ":" + mQ.size());
		System.out.println(mQ.remove() + ":" + mQ.size());
		System.out.println(mQ.remove() + ":" + mQ.size());
		mQ.add2(1);
		mQ.add2(2);
		mQ.add2(3);
		mQ.add2(4);
		mQ.add2(5);
		System.out.println(mQ.remove2() + ":" + mQ.size2());
		System.out.println(mQ.remove2() + ":" + mQ.size2());
		System.out.println(mQ.remove2() + ":" + mQ.size2());
		mQ.add2(6);
		mQ.add2(7);
		System.out.println(mQ.remove2() + ":" + mQ.size2());
		System.out.println(mQ.remove2() + ":" + mQ.size2());
		System.out.println(mQ.remove2() + ":" + mQ.size2());
		System.out.println(mQ.remove2() + ":" + mQ.size2());
		System.out.println(mQ.remove2() + ":" + mQ.size2());
	}
}

class Node<T> {
	public Node<T> next;
	public T obj;

	public Node(T obj) {
		this.obj = obj;
	}
}
