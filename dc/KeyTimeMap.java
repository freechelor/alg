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
DC#97_MEDIUM
This problem was asked by Stripe.

Write a map implementation with a get function that lets you retrieve the value of a key at a particular time.

It should contain the following methods:

set(key, value, time): sets key to value for t = time.
get(key, time): gets the key at t = time.
The map should work like this. If we set a key at a particular time, 
it will maintain that value forever or until it gets set at a later time. 
In other words, when we get a key at a time, 
it should return the value that was set for that key set at the most recent time.

Consider the following examples:

d.set(1, 1, 0) # set key 1 to value 1 at time 0
d.set(1, 2, 2) # set key 1 to value 2 at time 2
d.get(1, 1) # get key 1 at time 1 should be 1
d.get(1, 3) # get key 1 at time 3 should be 2
d.set(1, 1, 5) # set key 1 to value 1 at time 5
d.get(1, 0) # get key 1 at time 0 should be null
d.get(1, 10) # get key 1 at time 10 should be 1
d.set(1, 1, 0) # set key 1 to value 1 at time 0
d.set(1, 2, 0) # set key 1 to value 2 at time 0
d.get(1, 0) # get key 1 at time 0 should be 2

TC : O(1), SC : O(n)
 **/
public class KeyTimeMap {
	static HashMap<String, HashMap<String, String>> map = new HashMap<>();
	public static void setData(String k, String t, String v) {
		if(map.get(k)==null) {
			HashMap<String, String> tmp = new HashMap<>();
			tmp.put(t, v);
			map.put(k, tmp);
		} else {
			HashMap<String, String> tmp = map.get(k);
			tmp.put(t, v);
		}
	}

	public static String getData(String k, String t) {
		if(map.get(k)==null) return null;
		else {
			HashMap<String, String> tmp = map.get(k);
			return tmp.get(t);
		}
	}

	public static void main(String[] args) {
		setData("1","1","0");
		setData("1","2","2");
		setData("2","2","5");
		setData("2","4","10");
		setData("3","9","50");
		System.out.println(getData("1","1"));
		System.out.println(getData("2","4"));
		setData("1","1","99");
		setData("1","2","10");
		System.out.println(getData("1","2"));
		System.out.println(getData("1","1"));
	}
}
