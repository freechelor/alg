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
 *
 * DC#273_Easy
This problem was asked by Apple.

A fixed point in an array is an element whose value is equal to its index. 
Given a sorted array of distinct elements, return a fixed point, if one exists. Otherwise, return False.

For example, given [-6, 0, 2, 40], you should return 2. Given [1, 5, 7, 8], you should return False.
 */
public class DC273 {
	// TC : O(log n), SC : O(log n)
	public static boolean findIndexSameToValue(int[] arr, int low, int high) {
		if(arr==null||arr.length==0) return false;
		if(low>high) return false;
		int mid = (low+high)/2;
		if(arr[mid]==mid) return true;
		if(arr[mid]<mid) {
			return findIndexSameToValue(arr, mid+1, high);
		} else {
			return findIndexSameToValue(arr, low, mid-1);
		}
	}

	// TC: O(log n), SC : O(1)
	public static boolean findIndexSameToValueIter(int[] arr) {
		if(arr==null||arr.length==0) return false;
		int low = 0;
		int high = arr.length-1;
		while(low<=high) {
			int mid = (low+high)/2;
			if(arr[mid]==mid) return true;
			if(arr[mid]<mid) low = mid+1;
			else high = mid-1;
		}
		return false;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {-6, 0, 2, 40};
		//int[] arr = new int[] {1, 5, 7, 8};
		System.out.println(findIndexSameToValue(arr, 0, arr.length-1));
		System.out.println(findIndexSameToValueIter(arr));
	}
}
