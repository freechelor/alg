/**
 * TODO : 
 * 1. Time/Space Complexity Analysis
 * 		BUT, MOST OF ALL, IT IS IMPORTANT TO 1.1. LIST POSSIBLE/AVAILABLE SOLUTIONS AND 1.2. THINK ABOUT COMPLEXITY FIRST AND IN ADVANCE,
 * 		1.3. START WITH BEST COMPLEXITY SOLUTION
 * 2. Improve Algorithm/Performance
 * 3. Learn unfamiliar syntax 
 * 4. Any other ways to consider + compare in terms of Time/Space complexity
 *
 */
package alg.dc;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;
import java.util.function.*;

public class Delay {
	public void test(int n, DelayInf inf) {
		inf.call(n);
	}

	public static void main(String[] args) {
		DelayInf d = n -> {
			try {
				Thread.sleep(n);
				System.out.println("test");
			} catch(Exception ex) {
				//throw ex;
				System.out.println(ex.toString());
			}
		};
		new Delay().test(1000, d);
	}
}

@FunctionalInterface
interface DelayInf {
	public void call(int n);
}
