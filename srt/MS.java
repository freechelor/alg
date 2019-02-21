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

public class MS {
	public static Integer[] tmpArr;

	public static void print(Integer[] arr) {
		for(int a : arr) {
			System.out.print(a + " ");
		}
		System.out.println();
	}

	public static void merge(Integer[] arr, int s, int m, int e) {
		int idx = s;
		int i = s;
		int j = m+1;
		System.out.println(i + ", " + m + " , " + j + " , " + e);
		while(i<=m && j<=e) {
			if(tmpArr[i]<=tmpArr[j]) {
				arr[idx++] = tmpArr[i++];
			} else {
				arr[idx++] = tmpArr[j++];
			}
		}
		while(i<=m) {
			arr[idx++] = tmpArr[i++];
		}
		while(j<=e) {
			arr[idx++] = tmpArr[j++];
		}
		for(int k=s; k<=e; k++) {
			tmpArr[k] = arr[k];
		}
	}

	public static void mSort(Integer[] arr, int s, int e) {
		if(arr==null||arr.length==0) return;
		if(s>=e) return;
		int m = (s+e)/2;
		mSort(arr, s, m);
		mSort(arr, m+1, e);
		merge(arr, s, m, e);
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[] {10, 25, 30, 1, 9, 51, 7, 109, 62, 23 };
		ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(10, 25, 51, 30, 1, 9, 51, 99, 7, 7, 109, 62, 23));
		arr = new Integer[list.size()];
		list.toArray(arr); 
		tmpArr = new Integer[arr.length];
		//tmpArr = arr.clone();
		for(int i = 0; i < arr.length; i++) {
			tmpArr[i] = arr[i];
		}	
		mSort(arr, 0, arr.length-1);
		print(arr);
	}
}
