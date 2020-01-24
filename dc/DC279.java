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
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;
/**
DC#279_EASY
This problem was asked by Twitter.

A classroom consists of N students, whose friendships can be represented in an adjacency list. 
For example, the following descibes a situation where 0 is friends with 1 and 2, 3 is friends with 6, and so on.

{0: [1, 2],
 1: [0, 5],
 2: [0],
 3: [6],
 4: [],
 5: [1],
 6: [3]} 

Each student can be placed in a friend group, 
which can be defined as the transitive closure of that student's friendship relations. 
In other words, this is the smallest set such that no student in the group has any friends outside this group. 
For the example above, the friend groups would be {0, 1, 2, 5}, {3, 6}, {4}.

Given a friendship list such as the one above, determine the number of friend groups in the class.
*/
public class DC279 {
	// TC : O(n^2), SC : O(n)
	// make a group when I find a new number
	// if you see a number already you've seen before, add the number into the same group
	static List<HashSet<Integer>> gr = new ArrayList<>();
	public static int findNumberOfGroups(HashMap<Integer,List<Integer>> map) {
		for(Map.Entry<Integer, List<Integer>> e : map.entrySet()) {
			Integer k = e.getKey();
			List<Integer> list = e.getValue();
			boolean found = false;
			for(HashSet<Integer> set : gr) {
				if(set.contains(k)) {
					set.addAll(list);
					found = true;
					break;
				} else {
					for(Integer i:list) {
						if(set.contains(i)) {
							set.add(k);
							set.addAll(list);
							found = true;
							break;
						}
					}
				}
			}	
			if(!found) {
				HashSet<Integer> newSet = new HashSet<>();
				newSet.add(k);
				newSet.addAll(list);
				gr.add(newSet);
			}
		}
		return gr.size();
	}

	public static void main(String[] args) {
		HashMap<Integer,List<Integer>> map = new HashMap<Integer, List<Integer>>();
		map.put(0, Arrays.asList(new Integer[]{1,2}));
		map.put(1, Arrays.asList(new Integer[]{0,5}));
		map.put(2, Arrays.asList(new Integer[]{0}));
		map.put(3, Arrays.asList(new Integer[]{6}));
		map.put(4, Arrays.asList(new Integer[]{}));
		map.put(5, Arrays.asList(new Integer[]{1}));
		map.put(6, Arrays.asList(new Integer[]{3}));

		System.out.println(findNumberOfGroups(map));
	}
}	
