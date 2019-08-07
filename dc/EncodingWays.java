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
This problem was asked by Facebook.
Given the mapping a = 1, b = 2, ... z = 26, and an encoded message, count the number of ways it can be decoded.
For example, the message '111' would give 3, since it could be decoded as 'aaa', 'ka', and 'ak'.
You can assume that the messages are decodable. For example, '001' is not allowed.
**/
public class EncodingWays {
	enum ap {A, B, C};
	public int getWays(String n) {
		if(n.length()<1) return 0;
		if(n.length()==1) return 1;
		if(n.length()==2) return 2;
		return getWays(n.substring(1)) + getWays(n.substring(2));
	}

	public static void main(String[] args) {
		System.out.println(new EncodingWays().getWays("1111"));
		System.out.println(new EncodingWays().getWays("1234"));
		System.out.println(new EncodingWays().getWays("111"));
		System.out.println(new EncodingWays().getWays("2612345792"));
		System.out.println(new EncodingWays().getWays("2735022112"));
		System.out.println(EncodingWays.ap.A);
	}
}
