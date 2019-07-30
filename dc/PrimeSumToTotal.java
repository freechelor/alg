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
DC#101_Easy
This problem was asked by Alibaba.
Given an even number (greater than 2), return two prime numbers whose sum will be equal to the given number.
A solution will always exist. See Goldbach's conjecture.

Example:
Input: 4
Output: 2 + 2 = 4
If there are more than one solution possible, return the lexicographically smaller solution.  
If [a, b] is one solution with a <= b, and [c, d] is another solution with c <= d, then 
[a, b] < [c, d]
If a < c OR a==c AND b < d.
TC : O(nsqrt(n))
**/
public class PrimeSumToTotal {
	public static boolean isPrime(int n) {
		for(int i=2; i<=Math.sqrt(n); i++) {
			if(n%i==0) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int n = 39;
		for(int i=2; i<=n/2; i++) {
			if(isPrime(i)&&isPrime(n-i)) {
				System.out.println( i + " : " + (n-i));
			}
		}
	}
}
