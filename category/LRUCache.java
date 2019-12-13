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
package alg.category;

import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Set;
import java.util.Stack;
import java.util.Queue;

public class LRUCache {
	private HashMap<Integer, Entity> map;
	private Entity first, last;
	private final int LRU_SIZE = 4;
	public LRUCache() {
		map = new HashMap<>();
	}

	public Object get(int key) {
		Entity res;
		if(map.containsKey(key)) {
			res = map.get(key);
			removeCache(res);
			addCache(res);
			return res.value;
		}
		return null;
	}

	public void put(int key, Object data) {
		if(map.containsKey(key)) {
			Entity e = map.get(key);
			e.value = data;
			removeCache(e);
			addCache(e);
		} else {
			Entity newEntity = new Entity();
			newEntity.key = key;
			newEntity.value = data;
			newEntity.prev = null;
			newEntity.next = null;
			if(map.size()>=LRU_SIZE) {
				// the order to remove data from hash and list is important!
				// removal and addition from cache could change reference 
				System.out.println("current Last : " + last.value + " , key : " + last.key);
				map.remove(last.key);
				System.out.println("current Last : " + last.value + " , key : " + last.key);
				removeCache(last);
			}
			addCache(newEntity);
			map.put(key, newEntity);
		}
	}


	public void removeCache(Entity e) {
		if(e.prev!=null) {
			//first = e.next;
			e.prev.next = e.next;
		} else {
			//e.prev.next = e.next;
			first = e.next;
		}

		if(e.next!=null) {
			//last = e.prev;
			e.next.prev = e.prev;
		} else {
			//e.next.prev = e.prev;
			last = e.prev;
		}
	}

	public void addCache(Entity e) {
		e.next = first;
		e.prev = null;
		if(first!=null) first.prev = e;
		first = e;
		if(last==null) last = first;
	}

	public void printCurrent() {
		Entity head = first;
		while(head!=null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
		System.out.println(last.value);

		Set<Map.Entry<Integer,Entity>> l = map.entrySet();
		for(Map.Entry<Integer,Entity> s : l) {
			System.out.print(s.getKey() + " : " + s.getValue().value + " ");
		}
		System.out.println();
	}

	public static void main(String[] args) {
		LRUCache cache = new LRUCache();
		System.out.println("STEP 1");
		cache.put(1, "a");
		cache.printCurrent();
		System.out.println("STEP 2");
		cache.put(2, "b");
		cache.printCurrent();
		System.out.println("STEP 3");
		cache.put(1, "A");
		cache.printCurrent();
		System.out.println("STEP 4");
		cache.put(3, "c");
		cache.printCurrent();
		System.out.println("STEP 5");
		cache.put(4, "d");
		cache.printCurrent();
		System.out.println("STEP 6");
		cache.put(5, "e");
		cache.printCurrent();
		System.out.println("STEP 7");
		cache.put(6, "f");
		cache.printCurrent();
		
		for(int i=1; i<=6; i++) {
			System.out.println(i + " : " + cache.get(i));
		}
	}
}

class Entity {
	int key;
	Object value;
	public Entity prev;
	public Entity next;
}
