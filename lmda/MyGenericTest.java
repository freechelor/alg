package alg.lmda;

import java.util.*;

public class MyGenericTest {
	public static String reverseString(MyString reverse, String str) {
		return reverse.myStringFunction(str);
	}

	public static void main(String args[]) {
		MyGeneric<String> reverse = (str) -> {
			String res = "";
			for(int i=str.length()-1; i>=0; i--) {
				res += str.charAt(i);
			}
			return res;
		};

		System.out.println(reverse.compute("Palindrome"));

		MyGeneric<Integer> power = (a) -> (int)Math.pow(a, 2);
		System.out.println(power.compute(8));

		MyString m = (s) -> {
			String res = "";
			for(int i=s.length()-1; i>=0; i--) {
				res += s.charAt(i);
			}
			return res;
		};
		System.out.println(reverseString(m, "Palindrome"));

		Foo foo = new Foo() {
			@Override
			public String method(String str) {
				return str + " from Foo";
			}
		};

		Foo foo2 = p ->p + " from Foo2";
		System.out.println(foo.method("Test Message"));
		System.out.println(foo2.method("Last itme " )) ;
	}
}
