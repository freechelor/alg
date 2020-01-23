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

import alg.list.Node;

// Jan/9/2020
public class RemoveKthInList {

	// when we reach the last element, we need to know kth ahead of it
	// But, we can't go back because just singly linked list is given here.
	// So, we need to have 2 points so that one is ahead of the other by k
	// When the point which is preceding first reach the end of the list, the other point will be behind it by k.
	public static Node removeKthFromTheEnd(Node head, int k) {
		Node lead = head;
		Node follow = head;
		while(lead.next!=null&&k-->0) {
			lead = lead.next;
		}		
		if(lead.next==null&&k>0) return null;
		while(lead.next!=null) {
			lead = lead.next;
			follow = follow.next;
		}

		Node check = head;
		if(check==follow) {
			head = check.next;
			check.next = null;
			return head;
		}

		while(check.next!=follow) {
			check = check.next;
		}
		check.next = follow.next;		
		return head;
	}
	public static void main(String[] args) {
		int k = 3;
		Node head = new Node(1);
		Node head2 = head;
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);
		Node node5 = new Node(5);
		Node node6 = new Node(6);
		Node node7 = new Node(7);
		Node node8 = new Node(8);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = node8;
		node8.next = null;
		System.out.println(" given " );
		while(head!=null) {
			System.out.print(head.value + "->");
			head = head.next;
		}
		System.out.println();
		System.out.println("removed");
		Node res = removeKthFromTheEnd(head2, 10);
		while(res!=null) {
			System.out.print(res.value + "->");
			res = res.next;
		}
		System.out.println();
	}
}
