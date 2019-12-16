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
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class ReverseLinkedList {
	public Node reverse(Node head) {
		if(head==null||head.next==null) return head;
		Node n = reverse(head.next);
		head.next.next = head;
		head.next = null;
		return n;
	}

	public Node reverseIter(Node head) {
//		if(head==null||head.next==null) return head;
		Node prev = null;
		Node cur = head;
		while(cur!=null) {
			Node tmp = cur.next;
			cur.next = prev;
			prev = cur;
			cur = tmp;
		}
		return prev;
	}

	public static void main(String[] args) {
		Node head = new Node(1);
		Node n1 = new Node(2);
		Node n2 = new Node(3);
		Node n3 = new Node(4);
		Node n4 = new Node(5);
		/*
		head.next = n1;
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = null;
		*/

		Node prev = head;
		Node prev2 = head;
		while(prev!=null) {
			System.out.println(prev.value);
			prev = prev.next;
		}
		/*
		Node res = new ReverseLinkedList().reverse(head);
		while(res!=null) {
			System.out.println(res.value);
			res = res.next;
		}
		*/
		Node res2 = new ReverseLinkedList().reverseIter(prev2);
		while(res2!=null) {
			System.out.println(res2.value);
			res2 = res2.next;
		}
	}
}

class Node {
	int value;
	Node next;

	public Node(int v) {
		this.value = v;
	}
}
