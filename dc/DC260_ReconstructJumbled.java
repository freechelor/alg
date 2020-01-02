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
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;
/**
DC#260_Medium
This problem was asked by Pinterest.

The sequence [0, 1, ..., N] has been jumbled, 
and the only clue you have for its order is an array representing 
whether each number is larger or smaller than the last. Given this information, 
reconstruct an array that is consistent with it. 
For example, given [None, +, +, -, +], you could return [1, 2, 3, 0, 4].
 **/
/**
 * 1. 
 		recursive : if we have a solution for (n-1)
		if we have (+) at the end, just append n
		if we have (-) at the end, add (n+1) to all the (n-1) elements and append n at the end and minus n from all n elements
**/
public class DC260_ReconstructJumbled {
	public static void reconstruct(int n, List<String> signs, ArrayList<Integer> res) {
		if(n==0) return;
		if(n==1) { res.add(0); return; }
		String sign = null;
		try {
			sign = signs.remove(signs.size()-1);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		reconstruct(n-1, signs, res);
		if(sign.equals("+")) {
			res.add(n-1);
		} else {
			for(int i=0; i<res.size(); i++) {
				res.set(i, res.get(i)+n);
			}
			res.add(n-1);
			for(int i=0; i<res.size(); i++) {
				res.set(i, res.get(i)-(n-1));
			}
		}
	}

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		List<String> signs =  new ArrayList<String>(Arrays.asList("None", "+", "+", "-", "+", "-", "-", "-", "+", "+"));
		for(String s :signs) System.out.print(s + " , " );
		System.out.println();
		reconstruct(10, signs, list);
		for(Integer i : list) {
			System.out.print(i + "," );
		}
		System.out.println();
		List<String> test = new ArrayList<>();//Arrays.asList("a", "b", "c");
		test.add("a");
		test.add("b");
		test.add("c");
		while(test.size()>0) {
			System.out.print(test.remove(test.size()-1)+",");
		}
		System.out.println();
	}
}
