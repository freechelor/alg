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
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

import alg.tr.TreeNode;
/**
DC#89_Medium
This problem was asked by LinkedIn.

Determine whether a tree is a valid binary search tree.

A binary search tree is a tree with two children, left and right, 
and satisfies the constraint that the key in the left child must be less than or equal to the root 
and the key in the right child must be greater than or equal to the root.
**/
// SC : O(n) when the number of treenode is n, TC : O(n)
public class DeterminValidBST {
	public static boolean isValidBST(TreeNode root) {
		if(root==null) return true;
		if(isValidBST(root.left)&&isValidBST(root.right)) {
			if(root.left==null&&root.right==null) {
				return true;
			} else if(root.left==null) {
				if(root.value<=root.right.value) return true;
				else return false;
			} else if(root.right==null) {
				if(root.value>=root.left.value) return true;
				else return false;
			} else {
				if(root.value>=root.left.value&&root.value<=root.right.value) return true;
				else return false;
			}
		} else return false;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(70);
		root.left = new TreeNode(40);
		root.right = new TreeNode(90);
		root.left.left = new TreeNode(38);
		root.left.right = new TreeNode(60);
		root.right.left = new TreeNode(80);
		root.right.right = new TreeNode(100);
		root.right.right.right = new TreeNode(111);
		System.out.println(isValidBST(root));
	}
}
