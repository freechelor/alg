package alg.tr;

public class TreeNode {
	TreeNode left;
	TreeNode right;
	int value;

	public TreeNode(int d) {
		value = d;
	}
	
	public void setLeft(TreeNode n) {
		left = n;
	}

	public void setRight(TreeNode n) {
		right = n;
	}
}
