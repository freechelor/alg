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

public class MyHashMap<K,V> {
	private static int SIZE = 99999;
	private Entry<K,V>[] ent = new Entry[SIZE];

	int hash(K k) {
		return k.hashCode()%SIZE;
	}

	// in the usual cases, TC would be O(1)
	// in the worst case, TC would be O(n)
	// SC is O(1)
	void put(K k, V v) {
		int h = hash(k);
		if(ent[h]==null) {
			ent[h] = new Entry(k, v, null);
		} else {
			Entry<K,V> e = ent[h];
			while(e.next!=null) {
				if(e.key.equals(k)) {
					e.value = v;
					return;
				} else {
					e = e.next;
				}
			}
			if(e.key.equals(k)) {
				e.value = v;
			} else {
				e.next = new Entry(k, v, null);
			}
		}
	}

	// same with put method in terms of TC and SC
	V get(K k) {
		int h = hash(k);
		if(ent[h]==null) return null;
		else {
			Entry<K,V> e = ent[h];
			while(e.next!=null) {
				if(e.key.equals(k)) return e.value;
				else e.next = e;
			}
			if(e.key.equals(k)) return e.value;
			else return null;
		}
	}

	// @TODO : NEED TO REMIND
	// It was very hard for me to figure out how remove method works
	// same with put/get method in terms of TC and SC
	V remove(K k) {
		int h = hash(k);
		Entry<K,V> head = ent[h];
		Entry<K,V> prev = null;
		
		while(head!=null) {
			// if there is the same key
			if(head.key.equals(k)) {
				break;
			}
			prev = head;
			head = head.next;
		}

		// there is no entry or does not have the same key
		if(head==null) {
			return null;
		}

		if(prev!=null) prev.next = head.next;
		else ent[h] = head.next;
		return head.value;
	}

	public static void main(String[] args) {
		MyHashMap<String, String> map = new MyHashMap<>();
		map.put("test", "testv1");
		map.put("test2", "testv2");
		map.put("test3", "testv3");
		map.put("test4", "testv4");
		System.out.println(map.get("test2"));
		System.out.println(map.get("test4"));
		map.put("test4", "testv5");
		System.out.println(map.get("test4"));
		map.put("test4", "testv4");
		System.out.println(map.get("test4"));
		map.put("test4", "testv6");
		System.out.println(map.get("test4"));
		System.out.println(map.remove("test2"));
		System.out.println(map.get("test2"));
	}
}

class Entry<K,V> {
	public K key;
	public V value;
	public Entry<K,V> next;

	public Entry(K k, V v, Entry<K,V> n) {
		key = k;
		value = v;
		next = n;
	}
}
