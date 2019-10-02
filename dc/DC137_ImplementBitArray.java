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
 This problem was asked by Amazon.

Implement a bit array.

A bit array is a space efficient array that holds a value of 1 or 0 at each index.

    init(size): initialize the array with size
    set(i, val): updates index at i with val where val is either 1 or 0.
    get(i): gets the value at index i.
 */

/*
 * How do I approach this problem?
 * Simply put,
 * first, I can use HashMap whose key is an index and value is a value where value is either 1 or 0.
 * access, remove, insert, update will be done in O(1)
 * second, I can use LinkedList access, remove, insert, update will be done in O(n), right? // TODO : check this out
 *
 * But, I have to make it space efficient
 * Actually, I don't need more space than 1 bit for storing 0 or 1
 * I can use bit shift to set val at index i or get val from index i
 *
 * TC : O(1), SC : O(n)
 */
public class DC137_ImplementBitArray {
	static HashMap<Integer, Integer> map = null;
	static byte[] bits = null;
	static byte one = (byte)0b00000001;

	public static void init(int size) {
		map = new HashMap<>(size);
		int group = size/8;	
		int idx = size%8;
		bits = new byte[group+1];
	}

	public static void set(int idx, int val) {
		map.put(idx,val);
		int group = idx/8;
		int rem = idx%8;
		if(val==0) {
			bits[group] = (byte)(bits[group] & (~(one<<rem)));
		} else if(val==1) {
			bits[group] = (byte)(bits[group]|(one<<rem));
		}
	}

	public static int get(int idx) {
		map.get(idx);
		int group = idx/8;
		int rem = idx%8;
		byte b = (byte)((bits[group]&(one<<rem))>>rem);
		return b;
	}

	public static void main(String[] args) {
		init(10);
		set(3,1);
		set(9,1);
		for(int i=0; i<10; i++) {
			System.out.println("index = " + i + ", value = " + get(i));
		}
	}
}
