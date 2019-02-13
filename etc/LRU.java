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
package alg.etc;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;
import java.util.Deque;
import java.util.LinkedList;

public class LRU {
	static HashMap<String, Page> map = new HashMap<>();
	static final int MAX = 10;
	static Deque<Page> deq = new LinkedList<>();

	public static void refer(Page p) {
		if(map.get(p.key)!=null) {
			deq.remove(p);
			deq.addFirst(p);
		} else {
			if(deq.size()>=MAX) {
				map.remove(deq.getLast());
				deq.removeLast();
			}
			map.put(p.key, p);
			deq.addFirst(p);
		}
	}

	public static void print() {
		for(Page p : deq) {
			System.out.println(p.key);
		}
	}

	public static void main(String[] args) {
		Page p1 = new Page("1");
		Page p2 = new Page("2");
		Page p3 = new Page("3");
		Page p4 = new Page("4");
		Page p5 = new Page("5");
		Page p6 = new Page("6");
		Page p7 = new Page("7");
		Page p8 = new Page("8");
		Page p9 = new Page("9");
		Page p10 = new Page("10");
		Page p11 = new Page("11");
		Page p12 = new Page("12");

		refer(p1);
		refer(p10);
		refer(p2);
		refer(p4);
		refer(p12);
		refer(p5);
		refer(p9);
		refer(p6);
		refer(p7);
		refer(p3);
		refer(p8);
		refer(p11);

		print();
	}
}

class Page {
	public String key;
	public Page(String k) {
		key = k;
	}
}
