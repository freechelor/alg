package dailycoding.alg.tr;

public class LockUnlock {
	public static void printTree(Node root) {
		if(root==null) return;
		System.out.print(root.status + ",");
		printTree(root.left);
		printTree(root.right);
	}
	
	public static void main(String args[]) {
		Node root = new Node(true);
		Node n1 = new Node(true);
		Node n2 = new Node(true);
		Node n3 = new Node(true);
		Node n4 = new Node(true);
		Node n5 = new Node(true);
		Node n6 = new Node(true);
		
		root.left = n1; n1.parent = root;
		root.right = n2; n2.parent = root;
		n1.left = n3; n3.parent = n1;
		n1.right = n4; n4.parent = n1;
		n2.left = n5; n5.parent = n2;
		n2.right = n6; n6.parent = n2;
		
		printTree(root);
		System.out.println();
		System.out.println("unlock n2 : " + n2.unlock());
		printTree(root);
		System.out.println();
		System.out.println("unlock root : " + root.unlock());
		printTree(root);
		System.out.println();
		System.out.println("unlock n1 : " + n1.unlock());
		
		printTree(root);
		System.out.println();
		System.out.println("unlock n6 : " + n6.unlock());
		printTree(root);
		System.out.println();
		System.out.println("lock n2 : " + n2.lock());
		printTree(root);
		System.out.println();
		System.out.println("lock root : " + root.lock());
		printTree(root);
	}
}

class Node {
	public Node parent;
	public Node left;
	public Node right;
	public boolean status=true;
	public boolean homo=true;
	
	public Node(boolean s) {this.status = s;}
	
	public Node(Node p, Node l, Node r, boolean s, boolean h) {
		this.parent = p;
		this.left = l;
		this.right = r;
		this.status = s;
		this.homo = h;
	}
	
	public void notifyChange() {
		if(left.status==right.status && left.homo && right.homo) {
			this.homo = true;
		} else {
			this.homo = false;
		}
		if(this.parent!=null) this.parent.notifyChange();
	}
	
	public boolean isLocked() {
		return this.status;
	}
	
	public boolean lock() {
		if(left==null&&right==null) {
			changeLeaf(true);
			return true;
		}
		if(left==null && left.homo) {
			changeLeft(true);
			return true;
		}
		if(right==null && right.homo) {
			changeRight(true);
			return true;
		}				
		if((left.status==right.status && left.homo && right.homo)||isHomoAncestor()) {
			change(true);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean unlock() {
		if(left==null&&right==null) {
			changeLeaf(false);
			return true;
		}
		if(left==null && left.homo) {
			changeLeft(false);
			return true;
		}
		if(right==null && right.homo) {
			changeRight(false);
			return true;
		}		
		if((left.status==right.status && left.homo && right.homo)||isHomoAncestor()) {
			change(false);
			return true;
		} else {
			return false;
		}
	}
	
	
	private void changeLeaf(boolean to) {
		this.status = to;
		this.homo = true;
		if(this.parent!=null) this.parent.notifyChange();		
	}
	
	private void changeLeft(boolean to) {
		this.status = to;
		if(this.status==left.status) this.homo = true;
		else this.homo = false;
		if(this.parent!=null) this.parent.notifyChange();
	}
	
	private void changeRight(boolean to) {
		this.status = to;
		if(this.status==right.status) this.homo = true;
		else this.homo = false;
		if(this.parent!=null) this.parent.notifyChange();
	}	
	
	private void change(boolean to) {
		this.status = to;
		if(this.status==left.status) this.homo = true;
		else this.homo = false;
		if(this.parent!=null) this.parent.notifyChange();
	}
	
	public boolean isHomoAncestor() {
		Node tmp = this.parent;
		if(tmp==null) return true;
		boolean parentStatus = tmp.status; 
		while(tmp!=null&&tmp.status==parentStatus) {
			tmp = tmp.parent;
		}
		if(tmp==null) return false;
		return true;
	}
}
