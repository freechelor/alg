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
  DC109_Med
  This problem was asked by Cisco.

  Given an unsigned 8-bit integer, swap its even and odd bits. 
  The 1st and 2nd bit should be swapped, the 3rd and 4th bit should be swapped, and so on.

  For example, 10101010 should be 01010101. 11100010 should be 11010001.

Bonus: Can you do this in one line?
TC : O(1), SC : O(1)
 **/
public class DC109_SwapBits {
	public static void main(String[] args) {
		int a = Integer.parseInt("10111010",2);
		System.out.println(Integer.toBinaryString(a));
		int b = 0b10101010;
		int c = 0b01010101;
		System.out.println(Integer.toBinaryString((a&b)>>1));
		System.out.println(Integer.toBinaryString((a&c)<<1));
		System.out.println(Integer.toBinaryString((a&b)>>1|(a&c)<<1));
	}
}
