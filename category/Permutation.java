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
package alg.category;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class Permutation {
	private List<String> list = new ArrayList<>();
	private void getPermutation(char[] c, String res, int idx) {
		if(idx==c.length) {
			list.add(res);
			return;
		}
		for(int i=idx; i<c.length; i++) {
			if(!Character.isDigit(c[i])) {
				res += Character.toLowerCase(c[i]);
				getPermutation(c, res, idx+1);	
				res = res.substring(0,res.length()-2)+Character.toUpperCase(c[i]);
				getPermutation(c, res, idx+1);
			} else {
				res += c[i];
				getPermutation(c, res, idx+1);
			}
		}
	}

    public List<String> letterCasePermutation(String S) {
        // get character arrays from a given string
        // check it's a letter or not
        // if it's a letter, take lowercase of it or take uppercase of it then move to next character
		getPermutation(S.toCharArray(), "", 0);
		return list;
    }

	public static void main(String args[]) {
		Permutation pm = new Permutation();
		List<String> r = pm.letterCasePermutation("a1b1");
		for(String s: r) {
			System.out.println(s);
		}
	}
}
