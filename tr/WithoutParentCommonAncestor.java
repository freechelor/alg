package alg.tr;

import java.util.Queue;
import java.util.LinkedList;
public class WithoutParentCommonAncestor {
	// find one of nodes in tree
	public static TreeNode getCommon(TreeNode root, TreeNode n1, TreeNode n2) {
		if(root == null||n1==null||n2==null) return null;
		if(root == n1||root == n2) return root;
		if(!cover(root,n1)||!cover(root,n2)) return null;
		boolean n1onLeft = cover(root.left,n1);
		boolean n2onLeft = cover(root.left,n2);
		if(n1onLeft!=n2onLeft) return root;
		if(n1onLeft) return getCommon(root.left, n1, n2);
		else return getCommon(root.right, n1, n2);
	}

	public static boolean cover(TreeNode root, TreeNode n) {
		if(root==null||n==null) return false;
		if(root.value==n.value) return true;
		if(cover(root.left,n)||cover(root.right,n)) return true;
		else return false;
	}

	public static void main(String args[]) {
    	TreeNode root = new TreeNode(5);
	    TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(9);
		TreeNode n4 = new TreeNode(21);
		TreeNode n5 = new TreeNode(2);
		TreeNode n6 = new TreeNode(18);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(32);
		TreeNode n9 = new TreeNode(97);
		root.setLeft(n1);
		root.setRight(n2);
		n1.setLeft(n3);
		n1.setRight(n4);
		n2.setLeft(n5);
		n5.setLeft(n6);
		n5.setRight(n7);
		n4.setLeft(n8);
		n4.setRight(n9);

		System.out.println();
		System.out.println(getCommon(root, n3, n9).value);
	}
}
