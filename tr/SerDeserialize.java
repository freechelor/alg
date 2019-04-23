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
package alg.tr;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;
import java.util.Vector;

public class SerDeserialize {
	private static StringBuffer list = new StringBuffer();
	private static void serialize(TreeNode root) {
		if(root==null) list.append(":null");
		list.append(":").append(root.val);
		serialize(root.left);
		serialize(root.right);
	}

	// 		   	70
	// 		 15		30
	//	   20  24
	//	11
	//80
	//  70:15:20:11:80:null:null:24:null:null:30:null:null
// [70, 15, 7, 3, 25, 28, 80, 75, 130]
	private static TreeNode deserialize(TreeNode node, String list) {
		if(list.length()<=0) return node;
		String elm = list.substring(0,list.indexOf(":"));
		String rest = list.substring(list.indexOf(":")+1);	
		if(node.left==null) {
			if(elm.equals("null")) {
				node.left = null;
			} else node.left = new TreeNode(elm);
			deserialize(node, rest);
		} else {
			if(elm.equals("null")) {
				node.right = new TreeNode(elm);
			} else node.right = null;
			deserialize(node, rest);
		}
		return node;
	}

	public static void main(String[] args) {
		TreeNode root = getRoot();
		System.out.println("starting tree");
		printTree(root);
		System.out.println("serialized tree");
		serialize(root);
		String des = list.toString();
		System.out.println(des);
		TreeNode result = deserialize(
				new TreeNode(des.substring(0,des.indexOf(":"))), des.substring(des.indexOf(":")+1));
		System.out.println("deserialized tree");
		printTree(result);
		System.out.println(compareTrees(root, result));
	}

	private static boolean compareTrees(TreeNode n1, TreeNode n2) {
		if(n1==null && n2==null) return true;
		if(n1==null || n2==null) return false;
		if(n1.value==n2.value) {
			return(compareTrees(n1.left, n2.left)&&compareTrees(n1.right, n2.right));
		} else return false;
	}
	
	public static void printTree(TreeNode n) {
		if(n==null) return;
		System.out.println(n.val);
		printTree(n.left);
		printTree(n.right);
	}

	private static TreeNode getRoot() {
		TreeNode root = new TreeNode("70");
		TreeNode n1 = new TreeNode("15");
		TreeNode n2 = new TreeNode("7");
		TreeNode n3 = new TreeNode("25");
		TreeNode n4 = new TreeNode("3");
		TreeNode n5 = new TreeNode("28");
		TreeNode n6 = new TreeNode("80");
		TreeNode n7 = new TreeNode("75");
		TreeNode n8 = new TreeNode("130");
		root.left = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.right = n5;
		root.right = n6;
		n6.left = n7;
		n6.right = n8;

		return root;
	}
}
