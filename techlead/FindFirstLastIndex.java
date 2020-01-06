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

public class FindFirstLastIndex {
	/**
	 * use binary search
	 * we need to use binary search 2 times. 
	 * one for finding the first occurence and the other one for finding the last occurrence.
	 * for finding the first occurence, when we find a target, we need to check the previous one to it.
	 * if the previous one is less than(because the array is sorted) target or index that we found is 0 return the index
	 * if not, it means there is other elements which are the same as target, so find a target again in the left half
	 * for finding the last occurrence, viceversa.
	 * TC : O(log n), SC : O(log n) for recursion, O(1) for iteration
	 */

	public static void findRange(int[] arr, int target) {
		if(arr==null||arr.length==0) System.out.println("-1, -1");
		int first = findIndex(arr, 0, arr.length-1, target, true);
		int last = findIndex(arr, 0, arr.length-1, target, false);
		System.out.println("by recursion \n" + first + " , " + last);
		first = findIndexIter(arr, 0, arr.length-1, target, true);
		last = findIndexIter(arr, 0, arr.length-1, target, false);
		System.out.println("by iteration \n" + first + " , " + last);
	}

	public static int findIndex(int[] arr, int s, int e, int target, boolean isFirst) {
		if(s>e) return -1;
		//@TODO(check) if(s>=e) return -1;  Wrong : have to check when s==e, which means a single element in this round.
		int mid = (s+e)/2;
		if(isFirst) {
			if(arr[mid]==target&&(mid==0||arr[mid-1]<target)) {
				return mid;
			} else if(arr[mid]<target) {
				return findIndex(arr, mid+1, e, target, isFirst);
			} else {
				return findIndex(arr, s, mid-1, target, isFirst);		// @TODO(check) arr[mid]==target we should check left area
			}
		} else {
			if(arr[mid]==target&&(mid==arr.length-1||arr[mid+1]>target)) {
				return mid;
			} else if(arr[mid]<=target) {
				return findIndex(arr, mid+1, e, target, isFirst);		// @TODO(check) arr[mid]==target we should check right area
			} else {
				return findIndex(arr, s, mid-1, target, isFirst);
			}
		}
	}

	public static int findIndexIter(int[] arr, int left, int right, int target, boolean isFirst) {
		if(left>right) return -1;
		int mid=-1;
		if(isFirst) {
			while(left<=right) {
				mid=(left+right)/2;
				if(arr[mid]==target&&(mid==0||arr[mid-1]<target)) {
					return mid;
				} else if(arr[mid]<target) {
					left = mid+1;
				} else {
					right = mid-1;
				}
			}
		} else {
			while(left<=right) {
				mid=(left+right)/2;
				if(arr[mid]==target&&(mid==arr.length-1||arr[mid+1]>target)) {
					return mid;
				} else if(arr[mid]>target) {
					right = mid-1;
				} else {
					left = mid+1;
				}
			}
		}
		return mid;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, 3, 3, 4, 5, 7,7, 8, 9, 9, 10, 11};
		findRange(arr, 9);	
	}
}
