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
This question was asked by Apple.
Given a binary tree, find a minimum path sum from root to a leaf.
For example, the minimum path in this tree is [10, 5, 1, -1], which has sum 15.

		  10
		 /  \
		5    5
	   /\     \
	 -3  2     1
			   /
			 -1

	SC : O(N), TC : O(N)
**/
public class DC135_PathToMinimumSum {
	static List<Integer> path = new ArrayList<>();
	static String finalPath = null;
	static int min = Integer.MAX_VALUE;
	static int currentSum = 0;
	public static void traverseTree(TreeNode root) {
		if(root==null) return;	
		if(root.left==null && root.right==null) {
			// compare sum till here with min
			currentSum += root.value;
			path.add(root.value);
			if(currentSum<min)  { 
				min = currentSum;
				// save to miminum path variable
				finalPath = "";
				for(int a : path) {
					finalPath += a + " ";
				}
			}
			currentSum -= root.value;
			path.remove(path.size()-1);
			return;
		} else {
			// add current node
			path.add(root.value);
			currentSum += root.value;
			// traverse both sub-tree
			traverseTree(root.left);
			traverseTree(root.right);
			// remove current node
			path.remove(path.size()-1);
			currentSum -= root.value;
		}
	}

	public static void traverseTreeRecursive(TreeNode root) {
		if(root==null) return;	
		if(root.left==null && root.right==null) {
			// compare sum till here with min
			currentSum += root.value;
			path.add(root.value);
			if(currentSum<min)  { 
				min = currentSum;
				// save to miminum path variable
				finalPath = "";
				for(int a : path) {
					finalPath += a + " ";
				}
			}
			currentSum -= root.value;
			path.remove(path.size()-1);
			return;
		} else {
			// add current node
			path.add(root.value);
			currentSum += root.value;
			// traverse both sub-tree
			traverseTree(root.left);
			traverseTree(root.right);
			// remove current node
			path.remove(path.size()-1);
			currentSum -= root.value;
		}
	}
	public static void main(String[] args) {
		TreeNode root = new TreeNode(10);
		TreeNode n1 = new TreeNode(5);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(2);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(-1);
		TreeNode n6 = new TreeNode(-3);
		root.left = n1;
		root.right = n2;
		root.left.right = n3;
		root.left.left = n6;
		root.right.right = n4;
		root.right.right.left = n5;
		traverseTree(root);
		System.out.println(finalPath);
	}
}
