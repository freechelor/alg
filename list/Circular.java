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
package alg.list;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class Circular {
	// how to detect if the list is circular.
	// if circular, how to tell between infinity list and loop list
	//
	//
	//method1. hash
	//when going through each element, check if the element is already there if it is there, it' forms loop
	//TC : O(n), SC : O(n)
	//TODO : if you don't have enough memory, you have to think up any other ideas
	static HashMap<Node,Integer> map = new HashMap<>();
	public static Node getEntryPoint(Node s) {
		Node cur = s.next;
		while(cur!=null) {
			if(map.get(cur)!=null) return cur;
			else {
				map.put(cur,1);
			}
			cur = cur.next;
		}
		return null;
	}

	//method2.
	//move one pointer slower by 1 and move another pointer faster by 2
	// if the two meet somewhere it forms loop TODO : what about infinity case?
	// in the case, to find entry point, we need to move k+a times from the point where they meet
	public static Node getEntryPoint2(Node s) {
		// fist find the point
		Node p;	
		Node fh = s;
		Node sh = s;
		int cnt=0;
		do {
			cnt++;
			sh = sh.next;
			fh = fh.next.next;
		} while(sh!=null&fh.next!=null&fh!=sh);
		if(fh!=sh) return null;
		p = fh;
		// move the point k+a 
		for(int i = 0; i < cnt; i++) {
			p = p.next;
		}
		return p;
				
	}	


	public static void main(String[] args) {
		Node n1 = new Node(1);
		Node n2 = new Node(2);
		Node n3 = new Node(3);
		Node n4 = new Node(4);
		Node n5 = new Node(5);
		Node n6 = new Node(6);
		Node n7 = new Node(7);
		Node n8 = new Node(8);
		Node n9 = new Node(9);
		Node n10 = new Node(10);
		Node n11 = new Node(11);
		Node n12 = new Node(12);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;
		n10.next = n11;
		n11.next = n6;

		Node result;
		System.out.println(result=getEntryPoint(n1));
		if(result!=null) System.out.println(result.value);
		System.out.println(result=getEntryPoint2(n1));
		if(result!=null) System.out.println(result.value);
	}
}
