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
import java.util.LinkedList;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

import alg.tr.TreeNode;

/**
 *
This is your coding interview problem for today.

This problem was asked by Yext.

Two nodes in a binary tree can be called cousins 
if they are on the same level of the tree but have different parents. 
For example, in the following diagram 4 and 6 are cousins.

    1
   / \
  2   3
 / \   \
4   5   6

 */
public class DC284 {
	public static List<TreeNode> getCousins(TreeNode root, TreeNode ch) {
		if(root==null) return null;
		if(root.left==null&&root.right==null) return null;
		List<TreeNode> res = new ArrayList<TreeNode>();
		Queue<TreeNode> q = new LinkedList<TreeNode>();
		q.offer(root);
		int size = q.size();
		boolean flag = false;
		while(!q.isEmpty()) {
			res = new ArrayList<>();
			while(size-->0) {
				TreeNode n = q.poll();
				if(n==null) continue;
				if(n.left==ch) {
					flag = true;
				} else if(n.right==ch) {
					flag = true;
				}
				else {
					res.add(n.left);
					q.offer(n.left);
					res.add(n.right);
					q.offer(n.right);
				}
			}
			if(flag) {
				break;
			}
			size = q.size();
		}
		return res;
	}

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		TreeNode n1 = new TreeNode(2);
		TreeNode n2 = new TreeNode(3);
		TreeNode n3 = new TreeNode(4);
		TreeNode n4 = new TreeNode(5);
		TreeNode n5 = new TreeNode(6);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n10 = new TreeNode(10);
		TreeNode n11 = new TreeNode(11);
		root.left = n1;
		root.right = n2;
		n1.left = n3;
		n1.right = n4;
		n2.right = n5;
		n3.left = n6;
		n4.left = n7;
		n4.right = n8;
		n5.left = n9;
		n5.right = n10;
		List<TreeNode> result = getCousins(root, n6);
		for(TreeNode t : result) {
			if(t!=null) System.out.println(t.value);
		}
	}
}
