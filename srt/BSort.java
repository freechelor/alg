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
package alg.srt;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

/*
 * TC : O(n2)
 * 	worst case : O(n2) - invert sorted
 * 	best case : O(n) - already sorted
 * 	avg case : O(n2)
 * SC : O(1)
 **/
public class BSort {
	public static void bSort(Integer[] arr) {
		for( int i = 0; i < arr.length; i++) {
			for( int j = i+1; j < arr.length; j++) {
				int tmp;
				if(arr[i]>arr[j]) {
					tmp = arr[i];
					arr[i] = arr[j];
					arr[j] = tmp;
				}
			}
		}
	}

	public static void print(Integer arr[]) {
		for( int a : arr ) {
			System.out.print(a + " " );
		}
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[] {10, 25, 30, 1, 9, 51, 7, 109, 62, 23 };
		ArrayList<Integer> list = 
			new ArrayList<Integer>(Arrays.asList(10, 25, 30, 1, 9, 51, 7, 109, 62, 23));
		arr = new Integer[list.size()];
		list.toArray(arr);
		bSort(arr);
		print(arr);
	}
}
