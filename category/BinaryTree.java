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
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class BinaryTree<T> {
	public void printTreeInOrder(Node<T> root) {
		if(root == null) return;
		printTreeInOrder(root.left);
		System.out.println(root.value);
		printTreeInOrder(root.right);
	}

	public void printTreePostOrder(Node<T> root) {
		if(root == null) return;
		printTreePostOrder(root.left);
		printTreePostOrder(root.right);
		System.out.println(root.value);
	}

	public void printTreePreOrder(Node<T> root) {
		if(root == null) return;
		System.out.println(root.value);
		printTreePreOrder(root.left);
		printTreePreOrder(root.right);
	}

	private Queue<Node<T>> q = new LinkedList<Node<T>>();
	public void printTreeLevelOrder(Node<T> root) {
		q.add(root);
		while(q.size()>0) {
			Node<T> n = q.poll();
			System.out.println(n.value);
			if(n.left!=null) q.add(n.left);
			if(n.right!=null) q.add(n.right);
		}
	}

	public static void main(String[] args) {
		Node<String> root = new Node("50");
		Node<String> l1 = new Node("30");
		Node<String> r1 = new Node("70");
		Node<String> l1l1 = new Node("10");
		Node<String> l1r1 = new Node("40");
		Node<String> r1r1 = new Node("80");
		Node<String> r1r1r1 = new Node("810");
		root.left = l1;
		root.right = r1;
		l1.left = l1l1;
		l1.right = l1r1;
		r1.right = r1r1;
		r1r1.right = r1r1r1;
		System.out.println("======= Inorder traverse ==========");
		BinaryTree<String> tree = new BinaryTree<String>();
		tree.printTreeInOrder(root);
		System.out.println("======= Postorder traverse ==========");
		tree.printTreePostOrder(root);
		System.out.println("======= Preorder traverse ==========");
		tree.printTreePreOrder(root);
		System.out.println("======= level order traverse ==========");
		tree.printTreeLevelOrder(root);
	}
}

class Node<T> {
	public T value;
	public Node<T> left;	
	public Node<T> right;	

	public Node(T v) {
		value = v;
	}
}
