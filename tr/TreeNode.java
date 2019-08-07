package alg.tr;

public class TreeNode {
	public TreeNode left;
	public TreeNode right;
	public int value;
	public String val;

	public TreeNode(String v) {
		val = v;
	}

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
