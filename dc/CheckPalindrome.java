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
DC#104_Easy
This problem was asked by Google.
Determine whether a doubly linked list is a palindrome. 
What if it's singly linked?

For example, 1 -> 4 -> 3 -> 4 -> 1 returns True while 1 -> 4 returns False.
For Doubly Linked List, TC : O(n), SC : O(1)
For Singly Linked List, TC : O(n), SC : O(n)
 **/
public class CheckPalindrome {
	// in case of doubly linked list
	public static boolean isPalindrome(DNode n) {
		DNode first = n;
		DNode last = n;
		while(last.next!=null) {
			last = last.next;
		}
		while(first.val==last.val) {
			first = first.next;
			last = last.prev;	
			if(first.next==last.prev||first.next==last&&last.prev==first) return true;
		}
		return false;
	}

	static Stack<Single> s = new Stack<>();
	// in case of singly linked list
	public static boolean isPalindrome(Single n) {
		Single head = n;
		while(n!=null) {
			System.out.println(n.toString());
			s.push(n);
			n = n.next;
		}

		while(head!=null) {
			Single vv = s.pop();
			if(head.val==vv.val) {
				System.out.println("head : " + head.toString() + " , stack : " + vv.toString());
				head = head.next;
			} else return false;
		}
		return true;
	}	

	public static void main(String[] args) {
		DNode n = new DNode(1);
		n.add(new DNode(4));
		n.next.add(new DNode(3));
		n.next.next.add(new DNode(4));
		n.next.next.next.add(new DNode(1));
		System.out.println(isPalindrome(n));

		Single single = new Single(1);
		System.out.println("first : " + single.toString());
		single.add(new Single(4));
		single.next.add(new Single(3));
		single.next.next.add(new Single(4));
		single.next.next.next.add(new Single(1));
		System.out.println(isPalindrome(single));
	}
}

class DNode {
	public DNode prev, next;
	public int val;

	public DNode(int v) {
		val = v;
	}

	public void add(DNode n) {
		n.prev = this;
		this.next = n;
	}

	public void remove(DNode n) {
		DNode cPrev = prev;
		DNode cNext = next;
		while(cPrev!=null) {
			if(cPrev.equals(n)) {
				cPrev.prev.next = cPrev.next;
				cPrev.next.prev = cPrev.prev;
				return;
			}
			cPrev = prev.prev;
		}

		while(cNext!=null) {
			if(cNext.equals(n)) {
				cNext.prev.next = cNext.next;
				cNext.next.prev = cNext.prev;
				return;
			}
			cNext = next.next;
		}
	}
}

class Single {
	public Single next;
	public int val;

	public Single(int v) {
		val = v;
	}

	public void add(Single s) {
		this.next = s;
	}
}
