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
/**
DC#61_Medium
This problem was asked by Google.

Implement integer exponentiation. That is, implement the pow(x, y) function, where x and y are integers and returns x^y.

Do this faster than the naive method of repeated multiplication.

For example, pow(2, 10) should return 1024.

TC : O((log2 y)^2)
 **/
public class DC61_ImpleIntegerExponential {
	public static int pow(int x, int y) {
		int cnt = 0;
		int e = 1;
		int res = 1;
		if(y==0) return 1;
		if(y==1) return x;
		while(e<=y) {
			e *= 2;
			cnt++;
		}
		e /= 2;
		cnt--;

		res = x;
		while(cnt>0) {
			res = res * res;
			cnt--;
		}

		return res * pow(x, y-e);
	}

	public static void main(String[] args) {
		System.out.println(pow(2,8));	// 2^7 = 2^(2^2+2^1+1) = 2^2^2 + 2^2 + 2^1
		System.out.println(Math.pow(2,8));	
		System.out.println(pow(3,5)); // 3^5 = 3^(2^2)*3^1
		System.out.println(Math.pow(3,5));
		System.out.println(pow(5,11)); // 3^5 = 3^(2^2)*3^1
		System.out.println(Math.pow(5,11));
	}
}
