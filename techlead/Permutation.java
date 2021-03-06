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

public class Permutation {
	/**
	 * 1. permuation of {1, 2, 3} is {1, 2, 3}, {1, 3, 2}, {2, 1, 3}, {2, 3, 1}, {3, 1, 2}, {3, 2, 1}
	 * for a set of a single element. e.g. {1} -> {1}
	 * for a set of two elements. e.g. {1,2} 
	 * 	-> {1,2}, {2,1}. we can get it from swapping two elements
	 * for a set of 3 elements. .e.g. {3,1,2} 
	 * 	-> {3,1,2}, {3,2,1}. first we get by just adding a new element at the beginning of permutation of a set of 2 eleemnts
	 * 	then, swap 3 with other elements. {1, 3, 2}, {2, 1, 3} from {3, 1, 2} and {2, 3, 1}, {1, 2, 3} from {3, 2, 1}
	 * 	So if we already have permutation of a set of n elements, we can get permutation of a set of (n+1) elements by adding a new element and swapping it with other elements.
	 * 	
	 * 	TC : O(n!), SC : O(n!)
	 *
	 * 	@TODO : what if allowing duplication, e.g. for {1, 2, 3} => {1,1,1}, {2,2,2}, {3,3,3}
	 **/

	static List<Integer[]> res = new ArrayList<Integer[]>();
	public static List<Integer[]> getPermuation(Integer[] arr) {
		if(arr==null||arr.length==0) return new ArrayList<Integer[]>();
		int start = 0;
		return getPermutationHelper(arr, start);
	}

	public static List<Integer[]> getPermutationHelper(Integer[] arr, int s) {
		if(arr.length==s) {
			Integer[] clone = new Integer[arr.length];
			System.arraycopy(arr, 0, clone, 0, arr.length);
			res.add(clone);
		}
		for(int i=s; i<arr.length; i++) {
			int tmp = arr[s];
			arr[s] = arr[i];
			arr[i] = tmp;
			getPermutationHelper(arr, s+1);
			
			tmp = arr[s];
			arr[s] = arr[i];
			arr[i] = tmp;
		}
		return res;
	}


	// for Duplication case
	// TC : O(n^n), SC : O(n^n)
	public static List<Integer[]> getPermutationDup(Integer[] arr) {
		if(arr==null||arr.length==0) return new ArrayList<Integer[]>();
		return getPermutationDupHelper(new Integer[arr.length], arr, 0);
	}

	public static List<Integer[]> getPermutationDupHelper(Integer[] arr, Integer[] inArr, int s) {
		if(arr.length==s) {
			Integer[] clone = new Integer[arr.length];
			System.arraycopy(arr, 0, clone, 0, arr.length);
			res.add(clone);
			return res;
		}
		for(int i=0; i<inArr.length; i++) {
			arr[s] = inArr[i];
			getPermutationDupHelper(arr, inArr, s+1);
		}	
		return res;
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[] { 1, 2, 3};
		List<Integer[]> result = getPermuation(arr);
		System.out.println("# of cases : " + result.size());
		for(Integer[] rArr : result) {
			for(int e : rArr) {
				System.out.print(e + ",");
			}
			System.out.println();
		}
		System.out.println("Permutation duplicated");
		res = new ArrayList<Integer[]>();
		List<Integer[]> result2 = getPermutationDup(arr);
		System.out.println("# of cases : " + result2.size());
		for(Integer[] rArr : result2) {
			for(int e : rArr) {
				System.out.print(e + ",");
			}
			System.out.println();
		}
	}
}
