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

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class PythagorianTriplets {
	static HashSet<Integer> set = new HashSet<>();

	// TC : O(n^2)
	// SC : O(n)
	public static boolean isExisting(int[] arr) {
		for(int a:arr) {
			set.add(a*a);
		}

		for(int i=0; i<arr.length-1; i++) {
			for(int j=i+1; j<arr.length; j++) {
				if(set.contains(arr[i]*arr[i]+arr[j]*arr[j])) return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = {3, 5, 7, 11, 12, 14};
		System.out.println(isExisting(arr));
	}
}
