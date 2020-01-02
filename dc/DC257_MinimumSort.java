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
import java.util.Comparator;
/**
DC#257_Easy
This problem was asked by WhatsApp.

Given an array of integers out of order, 
determine the bounds of the smallest window that must be sorted in order for the entire array to be sorted. 
For example, given [3, 7, 5, 6, 9], 
you should return (1, 3).
 **/
/**
 * 1. TC : O(n^2), SC : O(1)
	if the leftmost is the minimum, and the rightmost is the maximum -> move to next one
	if the leftmost is the min, but the rightmost is not the max -> move to the next to leftmost
	if the leftmost is not the min, but the rightmost is the max -> move to the next to rightmost
	if the leftmost is not the min, and the rightmost is not the max -> return the size of the window

	2. TC : O(n logn), SC : O(n) 
	sort a given array and compare a new sorted array and a given array first
	we need to consider array in order of both of ascending and descending
**/
public class DC257_MinimumSort {
	/**
	 *
	 */
	public static Window getSmallestWindows(Integer[] arr) {
		if(arr==null||arr.length==0) return new Window(-1,-1);
		if(arr.length==1) return new Window(0,0);
		Integer[] temp = new Integer[arr.length];
		Integer[] temp2 = new Integer[arr.length];
		System.arraycopy(arr, 0, temp2, 0, arr.length);
		System.arraycopy(arr, 0, temp, 0, arr.length);
		Arrays.sort(arr);
		/*
		Arrays.sort(temp2, 
			new Comparator<Integer>() {
				@Override
				public int compare(Integer o1, Integer o2) {
					return o1-o2;
				}
			});
			*/
		int left = 0;
		int right = arr.length-1;
		while(left<right) {
			if(arr[left]==temp[left]) {
				left++;
			} else break;
		}
		while(left<right) {
			if(arr[right]==temp[right]) {
				right--;
			} else break;
		}
		int size = right-left;

		Arrays.sort(temp2, (a,b) -> b-a);

		int left2 = 0;
		int right2 = temp2.length-1;
		while(left2<right2) {
			if(temp2[left2]==temp[left2]) {
				left2++;
			} else break;
		}
		while(left2<right2) {
			if(temp2[right2]==temp[right2]) {
				right2--;
			} else break;
		}
		if(right2-left2<size) return new Window(left2,right2);
		return new Window(left,right);
	}

	public static void main(String[] args) {
		Integer[] arr = { 11, 9, 7, 5, 6, 1 };
		Window res = getSmallestWindows(arr);
		System.out.println(res.start + " , "  + res.end);
	}
}
class Window {
	int start;
	int end;

	public Window(int s, int e) {
		this.start = s;
		this.end = e;
	}
}
