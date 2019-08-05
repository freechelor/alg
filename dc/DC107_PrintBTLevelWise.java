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
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

import alg.tr.*;

/**
DC#107_Easy
This problem was asked by Microsoft.

Print the nodes in a binary tree level-wise. For example, the following should print 1, 2, 3, 4, 5.

  1
 / \
2   3
   / \
  4   5
TC : O(n), SC : O(n)
 **/
public class DC107_PrintBTLevelWise {
	static Queue<TreeNode> q = new LinkedList<>();

	public static void printByTreeLevel(TreeNode n) {
		q.offer(n);
		TreeNode next;
		while((next=q.poll())!=null) {
			System.out.print(next.value + " ");
			if(next.left!=null) q.offer(next.left);
			if(next.right!=null) q.offer(next.right);
		}
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.right.left = new TreeNode(4);
		root.right.right = new TreeNode(5);
		printByTreeLevel(root);
	}
}
