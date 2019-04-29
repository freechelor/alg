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
package alg.tc;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;


// if # of elements 1, let say, n=1, k=0, 'A'(0), 'B'(0)
// if # of elements 2, let say, n=2, k=1, 'AA'(0), 'AB'(1), 'BA'(0), 'BB'(0)
// if # of elements 3, let say, n=3, 'AAA'(0), 'AAB'(2), 'ABA'(1), 'ABB'(2), 'BAA'(0), 'BAB'(1)
// 									 'BAA'(0), 'BAB'(1), 'BBA'(0), 'BBB'(0), 'ABA'(1), 'ABB'(2), 'BBA'(0), 'BBB'(0), 'AAB'(2), 'ABB'(2), 'BAB'(1), 'BBB'(0)
// if # of elements 4, let say, n=4, 'AAAB'(3), 'AABA'(2), 'ABAA'(1), 'BAAA'(0)

public class ABh {
	public static String swap(String s, int i, int j) {
		return s.substring(0,i) + s.charAt(j) + s.substring(i+1,j) + s.charAt(i) + s.substring(j+1);
	}

	public static void main(String[] args) {
		int n = 9;
		int k = 19;
		int hf = n/2;
		int remainder = n%2;
		int hfA = hf;
		int hfB = hf+remainder;
		StringBuffer b = new StringBuffer();
		for(int i=0; i < hf; i++) {
			b.append("A");
		}
		for(int i=0; i < hf+remainder; i++) {
			b.append("B");
		}
		int curK = hfA*hfB;
		String init = b.toString();
		if(curK==k) {
			System.out.println("result : " + b.toString());
		} else {
			int i = 0, j = init.indexOf("B");
			while(curK-hfA>k) {
				init = swap(init, i, j);
				i++;
				j++;
				curK -= hfA;
			}
			
			int rm = curK-k;			
			init = swap(init, j-rm, j);
			System.out.println("result : "  + init);
		}
	}
}
