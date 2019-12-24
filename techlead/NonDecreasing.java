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

public class NonDecreasing {
	//1. No dip -> O
	//2. more than or equal to two dips -> X
	//3. 
	// 3.1. one dip at the beginning and the end -> O
	// 3.2. arr[i] <= arr[i+2]
	
	public static boolean isPossible(int[] arr) {
		int cnt = 0;
		int idx = -1;
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i]>arr[i+1]) {
				cnt++;
				idx = i;
			}
		}
		if(cnt==0) return true;
		if(cnt>1) return false;
		if(idx==0||idx==arr.length-2) return true;
		if(arr[idx]<=arr[idx+2]) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] arr = {
			{1, 2, 9, 20, 4, 3}, 
			{20, 1, 2, 3, 4, 5}, 
			{1, 3, 5, 7, 9, 11},
			{1, 3, 5, 7, 9, 2}, 
			{10, 15, 11, 13, 14, 17}, 
			{10, 15, 11, 15, 16, 18}, 
			{10, 15, 11, 14, 16, 21}};
		for(int i=0; i<arr.length; i++) {
			System.out.println(isPossible(arr[i]));
		}
	}
}
