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

public class Intersection {
	// method1. compare elements from a list with ones from the other list 
	// it could take c1Xc2 at the worst case


	// method2. hashing elements in a list first and then get and check if elements from the other list exist in the hash table
	// TODO : Have to check HashMap key comparison logic
	// 			method equals() in Object class compares objects with reference
 			     /* The {@code equals} method for class {@code Object} implements
 			          * the most discriminating possible equivalence relation on objects;
					  * that is, for any non-null reference values {@code x} and
					  * {@code y}, this method returns {@code true} if and only
					  * if {@code x} and {@code y} refer to the same object
					  * ({@code x == y} has the value {@code true}).*/
	// it could tabke c1+c2 at the worst case
	//
	static HashMap<Node, Integer> map = new HashMap<>();
	public static Node getIntersectedNode2(Node f, Node s) {
		Node cur=f.next;
		while(cur!=null) {
			map.put(cur,1);
			cur = cur.next;
		}
		Node cur2 = s.next;
		while(cur2!=null) {
			if(map.get(cur2)!=null) return cur2;
			cur2 = cur2.next;
		}
		return null;
	}
	// method3. if two list has intersection, there must be at least an element which has the same value
	// and then check the references are the same
	//
	//
	// method4. if the two list has intersection, they must have the same last element
	// so, go up till the end of each list and check if they are the same
	//
	public static Node getIntersectedNode(Node f, Node s) {
		return null;
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
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;
		n8.next = n9;
		n9.next = n10;

		Node n11 = new Node(100);
		Node n12 = new Node(101);
		Node n13 = new Node(102);
		Node n14 = new Node(4);
		Node n15 = new Node(104);
		Node n16 = new Node(105);
		Node n17 = new Node(106);
		n11.next = n12;
		n12.next = n13;
		n13.next = n14;
		n14.next = n15;
		n15.next = n16;
		n16.next = n17;
	
		Node result;
		System.out.println(result=getIntersectedNode2(n1, n11));
		if(result!=null) System.out.println(result.value);
		if(n4.equals(n14)) System.out.println("Equals");
		else System.out.println("Different");
	}
}
