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
package alg.q;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class HeteroQ {
	//method1. hold 3 different kinds of q.
	//one only holds cats, another only holds dogs, and the last holds both of them
	//TC : O(1), SC : O(2N) -> O(N)
	//if memory is not in so critical condition, this could be a solution




	//method2. in case of lack of memory, BF:
	// just hold one queue for every data.
	// and every time it gets request, scan from the first element sequentially
	// TC : 

	LinkedList<Animal> list = new LinkedList<>();
	public void add(Animal a) {
		list.add(a);
	}

	public 

	public static void main(String[] args) {
		Dog d1 = new Dog();
		Dog d2 = new Dog();
		Cat c1 = new Cat();
		Cat c2 = new Cat();
		Cat c3 = new Cat();
		Cat c4 = new Cat();
		Cat c5 = new Cat();
		Cat c6 = new Cat();
		Node n1 = new Node(d1);
		Node n2 = new Node(d2);
		Node n3 = new Node(c1);
		Node n4 = new Node(c2);
		Node n5 = new Node(c3);
		Node n6 = new Node(c4);
		Node n7 = new Node(c5);
		Node n8 = new Node(c6);
		n1.next = n2;
		n2.next = n3;
		n3.next = n4;
		n4.next = n5;
		n5.next = n6;
		n6.next = n7;
		n7.next = n8;

		HeteroQ q = new HeteroQ();
		q.add(n1);
	}
}

class Node {
	public Animal ani;
	public Animal next;
	public Node(Animal ani) {
		this.ani = ani;
	}
}

class Animal {
}

class Dog extends Animal {
	public final string type = "Dog";
}

class Cat extends Animal {
	public final string type = "Cat";
}
