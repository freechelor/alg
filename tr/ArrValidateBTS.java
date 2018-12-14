package alg.tr;

public class ArrValidateBTS {
	static int size = 0;
	static int getSizeofTree(TreeNode n) {
		if(n==null) return 0;
		if(n.left!=null) getSizeofTree(n.left);
		size++;
		if(n.right!=null) getSizeofTree(n.right);
		return size;
	}

	static void setArr(TreeNode n) {
		arr = new Integer[getSizeofTree(n)];
	}

	static Integer[] arr = null;
	static int idx = 0;
	static Integer[] copyToArr(TreeNode n) {
		if(n==null) return null;
		if(n.left!=null) copyToArr(n.left);
		arr[idx] = n.value;
		idx++;
		if(n.right!=null) copyToArr(n.right);
		return arr;
	}

	static boolean isOrdered(Integer[] arr) {
		if(arr==null||arr.length==1) return true;
		for(int i=0; i < arr.length-1; i++) {
			if(arr[i]>arr[i+1]) return false;
		}
		return true;
	}

	static boolean checkBTS(TreeNode n) {
		return isOrdered(copyToArr(n));
	}

	public static void main(String arggs[]) {
		//					30(root)
		//		15(n1)					50(n6)
		//	7(n2)	25(n3)			45(n7)	70(n8)
		//3(n4)			28(n5)
		TreeNode root = new TreeNode(70);
		TreeNode n1 = new TreeNode(15);
		TreeNode n2 = new TreeNode(7);
		TreeNode n3 = new TreeNode(25);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(28);
		TreeNode n6 = new TreeNode(50);
		TreeNode n7 = new TreeNode(45);
		TreeNode n8 = new TreeNode(30);
		root.left = n1;
		n1.left = n2;
		n1.right = n3;
		n2.left = n4;
		n3.right = n5;
		root.right = n6;
		n6.left = n7;
		n6.right = n8;

		setArr(root);
		System.out.println(checkBTS(root));
	}
}
