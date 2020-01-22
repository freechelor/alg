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
	// ... probably lost the way
	public static void getTrees(int n, TreeNode head, TreeNode cur, List<TreeNode> list) {
		if(n==0) { list.add(head); return; }
		// only left
		TreeNode left = new TreeNode(0);
		TreeNode right = new TreeNode(0);
	}

	public static List<TreeNode> getTreeset(int low, int high) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if(low>high) {
			list.add(null);
		}
		for(int i=low; i<=high; i++) {
			List<TreeNode> left = getTreeset(low, i-1);	
			List<TreeNode> right = getTreeset(i+1, high);	

			if(left==null&&right==null) {
				TreeNode head = new TreeNode(i);
				head.left = null;
				head.right = null;
			}
			else if(left==null) {
				for(int r=0; r<right.size(); r++) {
					TreeNode head = new TreeNode(i);
					head.left = null;
					head.right = right.get(r);
					list.add(head);
				}
			} else if(right==null) {
				for(int l=0; l<left.size(); l++) {
					TreeNode head = new TreeNode(i);
					head.left = left.get(l);
					head.right = null;
					list.add(head);
				}
			} else {
				for(int l=0; l<left.size(); l++) {
					for(int r=0; r<right.size(); r++) {
						TreeNode head = new TreeNode(i);
						head.left = left.get(l);
						head.right = right.get(r);
						list.add(head);
					}
				}
			}
		}
		return list;
	}
	
	public static void printTree(TreeNode node) {
		if(node==null) return;
		System.out.println(node.value);
		printTree(node.left);
		printTree(node.right);
	}

	public static void main(String[] args) {
		int n = 5;
		List<TreeNode> list = getTreeset(1, n);
		System.out.println("size of list : " + list.size());
		for(TreeNode head : list) {
			System.out.println("========================================");
			printTree(head);

		}
	}
}
