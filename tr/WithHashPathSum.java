package alg.tr;

import java.util.HashMap;

public class WithHashPathSum {
	//
	int countPathSum(TreeNode root, int tg, int curSum, HashMap<Integer, Integer> map) {
		if(root==null) return 0;
		curSum += root.value;
		int key = curSum - tg;
		int path = 0;
		int interim = 0;
		if(key==tg) {
			path++;
		}
		if((interim=map.getOrDefault(key,0)) > 0) {
			path++;
		}
		map.put(curSum, map.getOrDefault(curSum,0)+1);

		path += countPathSum(root.left, tg, curSum, map);
		path += countPathSum(root.right, tg, curSum, map);
		map.put(curSum, map.get(curSum)-1);
		return path;
	}

	//
	public static void main(String args[]) {
		WithHashPathSum s = new WithHashPathSum();
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
		System.out.println(s.countPathSum(root, 5, 0, new HashMap<Integer, Integer>()));
		System.out.println(s.countPathSum(root, 14, 0, new HashMap<Integer, Integer>()));
		System.out.println(s.countPathSum(root, 12, 0, new HashMap<Integer, Integer>()));
	}
}
