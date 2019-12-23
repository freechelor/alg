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
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class NonDuplicate {
	static HashMap<Integer,Integer> map = new HashMap<>();
	static int result = 0;
	// 1. I can do that by brute force. if range is limited. -> create array with fixed length and iterate throuhg all the elements when it meets an element, update of the number of occurrences increased by 1 if not set to 1
	// after that, iteracte throught the array from the beginning, if we meet the elements with value 1 it's the unique element. 
	// TC : O(n)
	// SC : O(n)
	//

	// 2. we can use HashMap
	// every time we meet elements during iterating through all the elements, we put the element into a hashmap,
	// if the element already exists in the hashmap, increase matched value by 1, if not set to 1
	// TC : O(n)
	// SC : O(n)
	//
	public static int getUniqueByHashMap(int[] arr) {
		for(int i:arr) {
			if(map.get(i)==null) {
				map.put(i,1);
			} else {
				map.put(i, map.get(i)+1);
			}
		}
		Set<Map.Entry<Integer,Integer>> set = map.entrySet();
		for(Map.Entry<Integer,Integer> e : set) {
			if(e.getValue()==1) return e.getKey();
		}
		return -1;
	}

	// 3. I can do that by just apply exlusive OR to sequential elements
	// TC : O(n)
	// SC : O(1)
	public static int getUniqueByXOR(int[] arr) {
		for(int i: arr) {
			result ^= i;
		}
		return result;
	}

	public static void main(String[] args) {
		int[] test = { 4, 3, 2, 1, 5,3, 4, 2,1};
		System.out.println(getUniqueByHashMap(test));
		System.out.println(getUniqueByXOR(test));
	}
}
