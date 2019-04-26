package alg.lmda;

import java.util.*;
import java.util.stream.*;
public class MySupplier {
	static int[] fibs = {0,1};
	public static void main(String args[]) {
		Stream<Integer> fibo = Stream.generate(()->{
			int result = fibs[1];
			int fib3 = fibs[0] + fibs[1];
			fibs[0] = fibs[1];
			fibs[1] = fib3;
			return result;
		});

		fibo.forEach(System.out::print);
	}
}
