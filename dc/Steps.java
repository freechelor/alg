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
import java.util.Vector;
import java.util.HashSet;

public class Steps {
	static HashSet<String> v = new HashSet<>();

	public static int getWays(int n) {
		if(n==0) return 1;
		if(n==1) return 1;
		return getWays(n-1) + getWays(n-2);
	}

	public static void getWays(int n, String pre) {
		if(n==0) { 
			if(pre.charAt(pre.length()-1)==',') { 
				System.out.print("before : " + pre + " => ");
				pre = pre.substring(0,pre.length()-1);
				System.out.println("after : " + pre );
			}
			if(v.contains("{"+pre+"}")) System.out.println("n=0 duplicate element : " + pre);
			System.out.println("n=0 {"+pre+"}");
			v.add("{" + pre + "}");
			return;
		}
		if(n==1) {
			if(v.contains("{"+pre+"1}")) System.out.println("n=1 duplicate element : " + pre+"1");
			System.out.println("n=1 {"+pre+"1}");
			v.add("{" + pre + "1}");
			return;
		}
		getWays(n-1, "1," + pre);
		getWays(n-2, "2," + pre);

		return;
	}

	public static void main(String[] args) {
		int n = 9;
		getWays(n, "");
		String tmp = null;
		int i = 0;
		for(String a:v) {
			System.out.println(i++ + " :" +a);
		}
		System.out.println(getWays(n));
	}
}
