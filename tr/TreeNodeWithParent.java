package alg.tr;

public class TreeNodeWithParent {
	public TreeNodeWithParent left;
	public TreeNodeWithParent right;
	public TreeNodeWithParent parent;

	public int value;

	public TreeNodeWithParent(int d) {
		value = d;
	}
	
	public void setParent(TreeNodeWithParent p) {
		parent = p;
	}

	public void setLeft(TreeNodeWithParent n) {
		left = n;
	}

	public void setRight(TreeNodeWithParent n) {
		right = n;
	}
}
