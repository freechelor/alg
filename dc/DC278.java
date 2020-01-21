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

import alg.tr.TreeNode;

/**
This problem was asked by Amazon.

Given an integer N, construct all possible binary search trees with N nodes.
 */
public class DC278 {
	//
	// There are 3 cases at a node.
	// One case is that a node has 2 children. Other is that a node has only left child.
	// And the other is that a node has only right child.
	public static void getTrees(int n, TreeNode head, TreeNode cur, List<TreeNode> list) {
		if(n==0) { list.add(head); return; }
		// only left
		TreeNode left = new TreeNode(0);
		TreeNode right = new TreeNode(0);
		head
		cur.left = left;
		cur.right = right;
	}
	
	public static void main(String[] args) {
	}
}
