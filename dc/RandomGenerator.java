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
import java.util.List;
import java.util.Collections;
import java.util.Random;
import java.util.Stack;
import java.util.Queue;

/*
DC#90_Medium
This question was asked by Google.

Given an integer n and a list of integers l, 
write a function that randomly generates a number from 0 to n-1 that isn't in l (uniform).
*/

public class RandomGenerator {
	private static HashSet<Integer> fset = new HashSet<>();
	private static HashMap<Integer, Integer> map = new HashMap<>();

	// SC : O(n), TC : O(n)
	public static void makeHashSet(int n, List<Integer> list) {
		for(int i=0; i<list.size(); i++) {
			fset.add(list.get(i));
		}
		int idx=0;
		for(int i=0; i < n; i++) {
			if(!fset.contains(i)) map.put(idx++, i);
		}
	}

	public static void main(String[] args) {
		int n = 10;
		List<Integer> l = new ArrayList<>();
		l.add(5);
		l.add(3);
		l.add(100);
		l.add(-2);
		makeHashSet(n,l);
		//for(int i=0; i<30; i++) {
		//	int r = getRandom();
		//	System.out.println(r);
		//}
		new Random().ints(30, 0, 1000).forEach(flt->System.out.println(map.get(flt%map.size())));
		System.out.println("====================================================================");
		new Random().ints(30, 0, 1000).map(d->(d%map.size())).forEach(flt->System.out.println(map.get(flt)));
	}
}
