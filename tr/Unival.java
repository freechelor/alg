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

public class Unival {
/*	public static int cntUnival(TreeNode r) {
		if(r==null) return 0;
		if(r.left==null && r.right==null) {
			return 1;
		}
		if(r.left!=null && r.right!=null && r.left.value==r.value && r.right.value==r.value)  {
			return 1 + cntUnival(r.left) + cntUnival(r.right);
		} else if(r.right==null) {
			if(r.value==r.left.value) {
				return 1 + cntUnival(r.lefT);
			} else {
				return cntUnival(r.left);
			}
		} else if(r.left==null) {
			if(r.value==r.right.value) {
				return 1 + cntUnival(r.right);
			} else {
				return cntUnival(r.right);
			}
		}

		return 0;
	}
*/
	public static boolean isUnival(TreeNode n) {
		if(n==null) return false;
		if(n.left==null&&n.right==null) return true;
		if(n.left!=null&&n.right!=null) {
			if(n.left.value==n.value && n.right.value==n.value) {
				return isUnival(n.left)&&isUnival(n.right);
			} else return false;
		} else if(n.left==null) {
			if(n.right.value==n.value) {
				return isUnival(n.right);
			} else return false;
		} else {
			if(n.left.value==n.value) {
				return isUnival(n.left);
			} else return false;
		}
	}

	static int cnt = 0;
	public static void cntUnival(TreeNode r) {
		if(r==null) return;
		if(isUnival(r)) cnt++;
		if(r.left!=null) cntUnival(r.left);
		if(r.right!=null) cntUnival(r.right);
	}

			//      n1
	//      	n2			 		n3
	//		n4			n5				n6
	//	n7		n8					n9
	public static void main(String[] args) {
		TreeNode n1 = new TreeNode(4);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(4);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(4);
		TreeNode n8 = new TreeNode(4);
		TreeNode n9 = new TreeNode(9);

		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n2.right = n5;
		n3.right = n6;
		n4.left = n7;
		n4.right = n8;
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

		cntUnival(n1);
		System.out.println(cnt);
	}
}
