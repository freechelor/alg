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
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;
import alg.tr.TreeNode;
/**
DC#258_Easy
This problem was asked by Morgan Stanley.

In Ancient Greece, it was common to write text with the first line going left to right, 
the second line going right to left, and continuing to go back and forth. This style was called "boustrophedon".

Given a binary tree, write an algorithm to print the nodes in boustrophedon order.

For example, given the following tree:

       1
    /     \
  2         3
 / \       / \
4   5     6   7

You should return [1, 3, 2, 4, 5, 6, 7].
**/

/**
 * 1. TC : O(n^2), SC : O(2^n) 
 * 		put a new element into a queue whenever finding it in a given tree
 * 		when we go through all elelments in a level, if print order is fromLeftToRight just print
 * 		if print order is fromRightToLeft put them into stack and when we read all of them in the same level
 * 		print them from stack. when we're done with a level, toggle print direction	
 **/
public class DC258_PrintBoustrophedon {
	public static void print(TreeNode root) {
		Queue<TreeNode> q = new LinkedList<>();
		Stack<TreeNode> st = new Stack<>();

		if(root==null) return;
		q.offer(root);
		boolean toRight = true;
		int i = 0;
		int size = q.size();
		while(!q.isEmpty()) {
			while(i++<size) {
				if(toRight) {
					// print
					TreeNode cur = q.remove();
					System.out.print(cur.value + ",");
					if(cur.left!=null) q.offer(cur.left);
					if(cur.right!=null) q.offer(cur.right);
				} else {
					// put into stack and print
					TreeNode cur = q.remove();
					st.push(cur);
					if(cur.left!=null) q.offer(cur.left);
					if(cur.right!=null) q.offer(cur.right);
				}
			}
			while(!st.isEmpty()) {
				System.out.print(st.pop().value + ",");
			}
			System.out.println();
			toRight = !toRight;
			i=0;
			size = q.size();
		}
		System.out.println();
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		TreeNode node11 = new TreeNode(11);
		TreeNode node12 = new TreeNode(12);
		TreeNode node13 = new TreeNode(13);
		TreeNode node14 = new TreeNode(14);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		node4.right = node9;
		node5.left = node10;
		node6.left = node11;
		node6.right = node12;
		node7.right  = node14;
		print(root);
	}
}
