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

import alg.tr.TreeNode;
/**
DC#117_Easy
This problem was asked by Facebook.

Given a binary tree, return the level of the tree with minimum sum.

			5
		  /   \
		 7     10
	    / \   /
	   2  4  6
	  /
	 1(O) 
	==> 4

			5
		  /   \
		 7     10
	    / \   /
	   2  4(O)  6
	  /
	 30 
	 ==> 3


			5
		  /   \
		 -5(O) 10
	    / \   /
	  -12 4 6
	  /
	 16 
	 ==> 2

TC : O(n), SC : O(1)
 **/
public class DC117_MinSumLevelOfTree {
	public static int level = 1;
	public static int min = Integer.MAX_VALUE;
	public static int count = 0;
	public static int sum(TreeNode root, int lev) {
		count++;
		if(root==null) return 0;
		int self = root.value + sum(root.left, lev+1) + sum(root.right, lev+1);
		if(min>self) { 
			min = self;
			level = lev;
		}
		return self;
	}


	public static void main(String[] args) {
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(-5);
		root.right = new TreeNode(10);
		root.left.left = new TreeNode(-12);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(16);
		root.right.left = new TreeNode(6);

		sum(root, 1);
		System.out.println("Level : " + level);
		System.out.println("Method call count : " + count);
	}
}
