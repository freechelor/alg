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
package alg.ds;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class MyHashByArray {
	private static int SIZE = 100;
	static List[] idx = new ArrayList[SIZE];

	private static void put(Object k, Object v) {
		int key = getIdx(k);
		List list = idx[key];
		if(list==null) list = new ArrayList();
		@SuppressWarnings("unchecked")
		list.add(new Entry(k,v));
	}

	@SuppressWarnings("unchecked")
	private static Object get(Object k) {
		Object v = null;
		int key = getIdx(k);
		if(idx[key]!=null) {
			List list = idx[key];
			for(int i = 0; i < list.size(); i++) {
				@SuppressWarnings("unchecked")
				Entry tmp = (Entry)list.get(i);
				if(tmp.getKey().equals(k)) v=tmp.getValue();
			}
		}
		return v;
	}

	private static int getIdx(Object o) {
		return o.hashCode()%SIZE;
	}

	public static void main(String[] args) {
		put("test", "testv1");
		put("test2", "testv2");
		put("test3", "testv3");
		put("test4", "testv4");

		System.out.println((String)get("test2"));
	}
}

class Entry {
	public Object key;
	public Object value;

	public Entry(Object k, Object v) {
		key = k;
		value = v;
	}

	public Object getKey() {
		return this.key;
	}

	public Object getValue() {
		return this.value;
	}
}
