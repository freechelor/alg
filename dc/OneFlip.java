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

public class OneFlip {
	public static boolean canBeDecreasable(int[] arr) {
		int cnt=0;
		for(int i=1; i<arr.length-1; i++) {
			if(arr[i-1]>arr[i]) {
			 cnt++;
			 if(cnt>1) return false;
			   if(arr[i]>=arr[i+1]) {
					return false;
			   } else {
				   if(arr[i-1]>arr[i+1]) return false;
				   if(cnt>1) return false;
			   }
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 5, 7, 9, 11, 13 };
		int[] arr2 = new int[] { 1, 3, 9, 7, 9, 11, 13 };
		int[] arr3 = new int[] { 1, 3, 5, 2, 9, 11, 13 };
		int[] arr4 = new int[] { 1, 3, 5, 1, 9, 15, 13 };
		int[] arr5 = new int[] { 1, 3, 5, 1, 4, 15, 13 };
		System.out.println(canBeDecreasable(arr));
		System.out.println(canBeDecreasable(arr2));
		System.out.println(canBeDecreasable(arr3));
		System.out.println(canBeDecreasable(arr4));
		System.out.println(canBeDecreasable(arr5));
	}
}
