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

public class SubTree {
	//method1. first find if there is an identical node in bigger tree with root of smaller tree
	//then, compare each node is the same
	//method2. if there's no duplicate elements, convert tree to array and find the first element in the shorter array from the longer list
	//then, going through, check all the sequential elements in the shorter list are the same with elements in the longer list in order
	public static TreeNode findHead(TreeNode n1, TreeNode n2) {
		if(n1==null||n2==null) return null;
		if(n1.value==n2.value) return n1;
		TreeNode lRef = findHead(n1.left, n2);
		if(lRef!=null)  return lRef;
		return findHead(n1.right, n2);
	}

	public static boolean isSame(TreeNode n1, TreeNode n2) {
		if((n1==null&&n2!=null)||(n1!=null&&n2==null)) return false;
		if(n1==null&&n2==null) return true;
		if(n1.value==n2.value) {
			if(n1.left==null&&n1.right==null&&n2.left==null&&n2.right==null) return true;
			return (isSame(n1.left, n2.left)&isSame(n1.right, n2.right));
		} else return false;
	}

	public static boolean isSubTree(TreeNode n1, TreeNode n2) {
		if(n1==null||n2==null) return false;
		TreeNode subHead = null;
		if((subHead=findHead(n1,n2))!=null) {
			return isSame(subHead, n2);
		}
		return false;
	}

	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		n4.left = n7;
		n5.left = n8;
		n6.left = n9;

		TreeNode m3 = new TreeNode(3);
		TreeNode m6 = new TreeNode(6);
		TreeNode m9 = new TreeNode(9);

		m3.right = m6;
		m6.left = m9;

		TreeNode m2 = new TreeNode(2);
		TreeNode m4 = new TreeNode(4);
		TreeNode m5 = new TreeNode(5);
		m2.left = m4;
		m2.right = m5;

		System.out.println(isSubTree(n1, m3));
		System.out.println(isSubTree(n1, m2));
	}
}
