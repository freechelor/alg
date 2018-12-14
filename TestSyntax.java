package alg;

public class TestSyntax {
	private static void testArg(String... p) {
		System.out.println(p[0]);
		for(String v : p) {
			System.out.println(v);
		}
	}

	public static void main(String args[]) {
		testArg("1", "2", "3");
	}
}
