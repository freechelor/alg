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
DC#95_Hard
**/
public class SmallestBigger {
	public int[] getSmallest(int[] arr, int s) {
		if(arr==null || arr.length==0) return null;
		int[] tmp = new int[arr.length-s];
		System.arraycopy(arr, s, tmp, 0, tmp.length);
		if(isSorted(tmp)) return null;
		Arrays.sort(tmp);
		for(int i=s; i<arr.length; i++) {
			arr[i] = tmp[i-s];
		}
		return arr;	
	}

	public boolean isSorted(int[] arr) {
		for(int i=0; i<arr.length-1; i++) {
			if(arr[i]>arr[i+1]) return false;
		}
		return true;
	}

	public int[] getSmallestOfBigger(int[] arr, int s) {
		if(arr==null || arr.length==0) return null;
		int r = Integer.MAX_VALUE;
		int p = arr[s];
		int res = -1;
		int idx = -1;
		for(int i=s; i<arr.length; i++) {
			if(p<arr[i] && arr[i]<r) {
				r = arr[i];
				idx = i;
			}
		}
		if(idx!=-1) {
			res = r;
			swap(arr, idx, s);
			return getSmallest(arr, s+1);	
		} else {
			return null;
		}
	}

	public void swap(int[] arr, int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
		return;
	}

	public static void main(String[] args) {
		SmallestBigger obj = new SmallestBigger();	
		int[] arr = new int[] { 1, 4, 2, 3};
		int[] res = null;
		for(int i=arr.length-1; i>=0; i++) {
			res = obj.getSmallestOfBigger(arr, arr.length-1);
			if(res!=null) break;
		}
		if(res==null) res = obj.getSmallest(arr, 0);

		for(int r : res) {
			System.out.print(r + ",");
		}
	}
}
