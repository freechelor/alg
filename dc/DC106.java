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
 * DC#106_Medium
 * TC : O(n), SC : O(1)
 **/
public class DC106 {
	public static boolean getPossibleRoute(int[] arr) {
		int i = 0;
		while(i<arr.length) {
			if(arr[i]==0&&i<arr.length-1) return false;
			i += arr[i];
			if(i==arr.length-1) return true;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 1, 3, 1, 2, -2, 0, 0};
		System.out.println(getPossibleRoute(arr));
	}
}
