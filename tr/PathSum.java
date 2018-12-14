package alg.tr;
import java.util.HashMap;

public class PathSum {
	// sum the number of paths from root node to sum to a target sum, from left of root node, and from right of root node
	private int getPathSumFromRoot(TreeNode root, int target) {
		if(root == null) return 0;
		int cnt = getPathSum(root, target, 0);
		int leftCnt = getPathSumFromRoot(root.left, target);
		int rightCnt = getPathSumFromRoot(root.right, target);
		return cnt + leftCnt + rightCnt;
	}

	// sum along a path from root node, count the number the sum gets to the same as target sum
	private int getPathSum(TreeNode node, int tg, int curSum) {
		if(node == null) return 0;
		curSum += node.value;
		int path = 0;
		if(curSum==tg) path++;
		path += getPathSum(node.left, tg, curSum);
		path += getPathSum(node.right, tg, curSum);
		return path;
	}

	public static void main(String args[]) {
		PathSum s = new PathSum();
		TreeNode root = new TreeNode(5);
		TreeNode n1 = new TreeNode(3);
		TreeNode n2 = new TreeNode(4);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(2);
		TreeNode n5 = new TreeNode(2);
		TreeNode n6 = new TreeNode(1);
		TreeNode n7 = new TreeNode(-1);
		TreeNode n8 = new TreeNode(2);
		TreeNode n9 = new TreeNode(9);
		root.setLeft(n1);
		root.setRight(n2);
		n1.setLeft(n3);
		n1.setRight(n4);
		n2.setLeft(n5);
		n5.setLeft(n6);
		n5.setRight(n7);
		n4.setLeft(n8);
		n4.setRight(n9);
		System.out.println(s.getPathSumFromRoot(root, 5));
		System.out.println(s.getPathSumFromRoot(root, 14));
		System.out.println(s.getPathSumFromRoot(root, 12));
	}
}
