package alg.tr;

import java.util.Vector;
public class Test {
	public static void main(String[] args) {
		Vector<String> v = new Vector<>();
		v.add("1");
		v.add("2");
		v.add(null);
		v.add(null);
		System.out.println(v.size());
		System.out.println(v);
	}
}
