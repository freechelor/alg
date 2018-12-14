package alg.tr;

public class ValidateBTS {
	static boolean checkBTS(TreeNode n, Integer min, Integer max) {
		if(n==null) return true;
		if((min!=null&&n.value<=min)||(max!=null&&n.value>max)) return false;
		if(!checkBTS(n.left, min, n.value)||!checkBTS(n.right, n.value, max)) return false;
		return true;
	}

	public static void main(String arggs[]) {
		//					30(root)
		//		15(n1)					50(n6)
		//	7(n2)	25(n3)			45(n7)	70(n8)
		//3(n4)			28(n5)
		TreeNode root = new TreeNode(30);
		TreeNode n1 = new TreeNode(15);
		TreeNode n2 = new TreeNode(7);
		TreeNode n3 = new TreeNode(25);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(28);
		TreeNode n6 = new TreeNode(50);
		TreeNode n7 = new TreeNode(45);
		TreeNode n8 = new TreeNode(70);
		root.left = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.right = n5;
		root.right = n6;
		n6.left = n7;
		n6.right = n8;

		System.out.println(checkBTS(root, null, null));
	}
}
