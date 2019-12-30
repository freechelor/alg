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
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

/**
This problem was asked by Fitbit.

Given a linked list, 
rearrange the node values such that they appear in alternating low -> high -> low -> high ... form. 
For example, 
given 1 -> 2 -> 3 -> 4 -> 5, 
you should return 1 -> 3 -> 2 -> 5 -> 4.
 **/
public class DC256_RearrangeLowHigh {
	public static LinkedNode rearrange(LinkedNode head) {
		if(head==null) return null;
		if(head.next==null) return head;
		if(head.next.next==null) return head;
		LinkedNode next = rearrange(head.next);	
		if(head.value>next.value) {
			if(next.value<next.next.value) {
				head.next = next;
				return head;
			} else {
				LinkedNode tmp = head.next;
				head.next = next.next;
				next.next = tmp;
				return next;
			}
		} else {
			if(next.value>next.next.value) {
				head.next = next;
				return head;
			} else {
				LinkedNode tmp = head;
				head.next = next.next;
				next.next = tmp;
				return next;
			}
		}
	}

	public static void main(String[] args) {
		LinkedNode head = new LinkedNode(1);
		LinkedNode fix = head;
		LinkedNode l1 = new LinkedNode(2);
		LinkedNode l2 = new LinkedNode(3);
		LinkedNode l3 = new LinkedNode(4);
		LinkedNode l4 = new LinkedNode(5);
		head.next = l1;
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		/*
		while(head!=null) {
			System.out.print(head.value + "->");
			head = head.next;
		}
		System.out.println();
		*/
		fix = rearrange(fix);
		while(fix!=null) {
			System.out.print(fix.value + "->");
			fix = fix.next;
		}
		System.out.println();
	}
}

class LinkedNode {
	public int value;
	public LinkedNode next;
	public LinkedNode(int v) {
		this.value = v;
	}
}
