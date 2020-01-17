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
import java.util.Set;
import java.util.Map;
import alg.list.Node;

/**
Given a linked list of integers, remove all consecutive nodes that sum up to 0.

Example:

Input: 10 -> 5 -> -3 -> -3 -> 1 -> 4 -> -4
Output: 10


The consecutive nodes 5 -> -3 -> -3 -> 1 sums up to 0 so that sequence should be removed. 
4 -> -4 also sums up to 0 too so that sequence should also be removed.
*/
public class RemoveSumTo0 {
	static HashMap<Integer, Pair> map = new HashMap<>();
	public static Node removeConsecutiveZero(Node head) {
		Node fixHead = head;
		Node first = head;
		Node last = head;
		int sum = 0;
		int idx = 0;
		while(head!=null) {
			sum += head.value;
			Pair p;
			if((p=map.get(sum))!=null) {
				if(p.end<0) p.end=idx;
			} else {
				p = new Pair(idx, -1);
			}
			head = head.next;
			idx++;
		}
		Set<Map.Entry<Integer, Pair>> set = map.entrySet();
		int max = 0;
		int start = -1;
		int end = -1;
		for(Map.Entry<Integer, Pair> entry : set) {
			Pair e = entry.getValue();
			if(max<(e.end-e.start)) {
				max = e.end - e.start;
				start = e.start;
				end = e.end;
			}
		}
		int cnt = 0;
		while(cnt++<=start) {
			first = first.next;
			last = last.next;
		}
		while(cnt++<end) {
			last = last.next;
		}
		first.next = last;
		return fixHead;
	}

	public static void main(String[] args) {
		Node n = new Node(10);
		Node n2 = new Node(5);
		Node n3 = new Node(-3);
		Node n4 = new Node(-3);
		Node n5 = new Node(1);
		Node n6 = new Node(4);
		Node n7 = new Node(-4);
		n.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		Node r = removeConsecutiveZero(n);
		while(r!=null) {
			System.out.print(r.value + "->" );
			r = r.next;
		}
	}

	static class Pair {
		int start;
		int end;
		public Pair(int s, int e) {
			this.start = s;
			this.end = e;
		}
	}
}
