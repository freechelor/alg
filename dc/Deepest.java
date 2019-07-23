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
import alg.tr.*;

public class Deepest {
	static TreeNode root = new TreeNode(0);

	public TreeNodeWithDepth getDeepest(TreeNodeWithDepth root) {
		if(root.node == null) return null;
		TreeNodeWithDepth left = getDeepest(new TreeNodeWithDepth(root.node.left, root.depth+1));
		TreeNodeWithDepth right = getDeepest(new TreeNodeWithDepth(root.node.right, root.depth+1));
		if(left == null && right==null) return root;
		if(left==null) return right;
		if(right==null) return left;
		if(left.depth>right.depth) {
			return left;
		} else return right;
	}

	public static void main(String[] args) {
		Deepest dp = new Deepest();
		root.left = new TreeNode(1);
		root.right = new TreeNode(2);
		root.left.left = new TreeNode(3);
		root.left.left.left = new TreeNode(31);
		root.left.left.right = new TreeNode(32);
		root.left.left.right.left = new TreeNode(34);
		root.left.left.right.right = new TreeNode(33);
		root.left.right = new TreeNode(4);
		root.right.right = new TreeNode(5);
		root.right.right.right = new TreeNode(6);
		
		System.out.println(dp.getDeepest(new TreeNodeWithDepth(root, 0)).node.value);
	}
}

class TreeNodeWithDepth {
	public TreeNode node;
	public int depth;

	public TreeNodeWithDepth(TreeNode tr, int d) {
		node = tr;
		depth = d;
	}
}
