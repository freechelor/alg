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
/**
DC#102_Medium
This problem was asked by Lyft.

Given a list of integers and a number K, 
return which contiguous elements of the list sum to K.

For example, if the list is [1, 2, 3, 4, 5] and K is 9, 
then it should return [2, 3, 4], since 2 + 3 + 4 = 9.
TC : O(n), SC : O(n)
 **/
public class ContiguousSum {
	public static HashMap<Integer, Integer> map = new HashMap<>();

	public static void findContiguousSum(int[] arr, Integer n) {
		int sum = 0;
		int firstIdx = 0;
		int lastIdx = 0;
		boolean found = false;
	
		for(int i=0; i<arr.length; i++) {
			sum += arr[i];
			map.put(sum, i);

			if(map.get(sum-n)!=null) {
				firstIdx = map.get(sum-n)+1;
				System.out.println( firstIdx + " to " + i);
				found = true;
			}
		}
		if(!found)
		System.out.println("There's no that combination");
		return;
	}

	public static void main(String[] args) {
		int T = 50;
		int[] arr = {5, -1, 10, 3, 9, -2, 4, 12, 7, 9, 22, 1, 3, -4, 3, 6, 9, 5,2, 17, 8, -6, -7};
		for(int i=0; i<arr.length; i++) {
			System.out.printf("%4d", i);
		}
		System.out.println();
		for(int a:arr) {
			System.out.printf( "%4d", a);
		}
		System.out.println();
		findContiguousSum(arr, 50);
	}
}
