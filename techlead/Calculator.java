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
package alg.techlead;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;
/**
Given a mathematical expression with just single digits, plus signs, negative signs, and brackets, 
evaluate the expression. Assume the expression is properly formed.

Example:

Input: - ( 3 + ( 2 - 1 ) )
Output: -4
**/
/**
How about if multiply, divide signs are also there 
**/
public class Calculator {
	// 1.
	// 		When I meet an open bracket, keep calculating whenever seeing elements until I meed a close bracket.
	// 		If I meet another open bracket do recursive call
	//
	public static int calculate(String exp, int idx, int cur) {
		if(exp.charAt(idx)=='+') {
			return cur + calculate(exp, idx+1, 0);
		}
		if(exp.charAt(idx)=='-') {
			return cur - calculate(exp, idx+1, 0);
		}
		if(exp.charAt(idx)=='(') {
			if(exp.charAt(idx+1)<='9'&&exp.charAt(idx+1)>='0') {
				return calculate(exp, idx+2, Integer.parseInt(exp.charAt(idx+1)+""));
			} else if(exp.charAt(idx+1)=='-') {
				return -1*calculate(exp, idx+2, 0);
			} else if(exp.charAt(idx+1)=='(') {
				return calculate(exp, idx+2, 0);
			}
		}
		if(exp.charAt(idx)==')') {
			return cur + calculate(exp, idx+1, 0);
		}
		if(exp.charAt(idx)<='9'&&exp.charAt(idx)>='0') {
			return Integer.parseInt(exp.charAt(idx)+"");
		}
		return -1;
	}

	public static void main(String[] args) {
		String str = "-(3+(2-1))";
		String str2 = "-(3+(2-1)-(8-2))";
		System.out.println(calculate(str, 0, 0));
		System.out.println(calculate(str2, 0, 0));
	}
}
