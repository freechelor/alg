package alg.list;

public class Node {
	public Node next;
	int value;

	public Node(int v) {
		this.value = v;
	}

	public Node next() {
		return next;
	}
}
