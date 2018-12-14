package alg.tr;

import java.util.Queue;
import java.util.LinkedList;
public class CommonAncestor {
	// find one of nodes in tree
	static TreeNodeWithParent getNode(TreeNodeWithParent root, TreeNodeWithParent v) {
		if(root == null) return null;
		if(root.value == v.value) return root;
		TreeNodeWithParent p = getNode(root.left, v);
		if(p!=null) return p;
		TreeNodeWithParent q = getNode(root.right, v);
		if(q!=null) return q;
		return null;
	}

	static TreeNodeWithParent getISection(TreeNodeWithParent node, TreeNodeWithParent v) {
		if(node==null) return null;
		if(getNode(node,v)!=null) return node;
		if(getNode(v,node)!=null) return v;
		while(node!=null) {
			if(getNode(node.parent,v)!=null) return node.parent;
			else node = node.parent;
		}
		return null;
	}

	static public void print(TreeNodeWithParent root) {
		if(root == null) return;
		Queue<TreeNodeWithParent> q = new LinkedList<TreeNodeWithParent>();
		q.add(root);
		int loop = 0;
		while(q.peek()!=null) {
			int size = q.size();
			loop++;
			while(size-->0) {
				TreeNodeWithParent n = q.poll();
				for(int i = 0; i < loop; i++ ) System.out.print("\t");
				System.out.println(n.value + " -> " + ((n.parent==null)? "":n.parent.value));
				if(n.left!=null) q.add(n.left);
				if(n.right!=null) q.add(n.right);
			}
		}
	}

	static public void printDFS(TreeNodeWithParent root) {
		if(root == null) return;
		System.out.print((root.parent==null)?"":root.parent.value + "  ->  " + root.value + "  " );
		printDFS(root.left);
		printDFS(root.right);
	}

	public static void main(String args[]) {
    	TreeNodeWithParent root = new TreeNodeWithParent(5);
	    TreeNodeWithParent n1 = new TreeNodeWithParent(3);
		TreeNodeWithParent n2 = new TreeNodeWithParent(4);
		TreeNodeWithParent n3 = new TreeNodeWithParent(9);
		TreeNodeWithParent n4 = new TreeNodeWithParent(21);
		TreeNodeWithParent n5 = new TreeNodeWithParent(2);
		TreeNodeWithParent n6 = new TreeNodeWithParent(18);
		TreeNodeWithParent n7 = new TreeNodeWithParent(7);
		TreeNodeWithParent n8 = new TreeNodeWithParent(32);
		TreeNodeWithParent n9 = new TreeNodeWithParent(97);
		root.setLeft(n1); n1.parent = root;
		root.setRight(n2); n2.parent = root;
		n1.setLeft(n3); n3.parent = n1;
		n1.setRight(n4); n4.parent = n1;
		n2.setLeft(n5); n5.parent = n2;
		n5.setLeft(n6); n6.parent = n5;
		n5.setRight(n7); n7.parent = n5;
		n4.setLeft(n8); n8.parent = n4;
		n4.setRight(n9); n9.parent = n4;

		print(root);
		printDFS(root);
		System.out.println();
		TreeNodeWithParent r1 = getNode(root, n9);
		//System.out.println(r1.value);
		//System.out.println(r1.parent.value + " , " + ((r1.left==null)?"leaf":r1.left.value) + " , " + ((r1.right==null)?"leaf":r1.right.value));
		TreeNodeWithParent it = getISection(r1, n3);
		System.out.println(it.value);
	}
}
