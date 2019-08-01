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
import java.util.Vector;
/**
DC#96_Easy
brute force : TC:O(n^n), SC:(n)
@TODO : is it possible to reduce TC?
**/
public class Permutation {
	static List<String> list = new ArrayList<>();
	public static void getPerm(Vector v, String s) {
		if(v.size()==0) {
			list.add(s);	
			return;
		} else {
			for(int i=0; i<v.size(); i++) {
				String elm = (String)v.remove(i);

				getPerm(v, s+elm);
				v.add(i,elm);
			}
		}
		
	}

	public static void main(String[] args) {
		Vector v = new Vector();
		v.add("1");
		v.add("2");
		v.add("3");
		v.add("4");
		v.add("5");
		v.add("6");
		v.add("7");
		v.add("8");
		v.add("9");
		v.add("a");
		/*
		v.add("b");
		v.add("c");
		v.add("d");
		v.add("e");
		v.add("f");
		v.add("g");
		v.add("h");
		v.add("i");
		v.add("j");
		v.add("k");
		v.add("l");
		v.add("m");
		v.add("o");
		v.add("p");
		v.add("q");
		v.add("r");
		v.add("s");
		v.add("t");
		v.add("u");
		v.add("v");
		v.add("w");
		v.add("x");
		v.add("y");
		v.add("z");
		*/
				
		getPerm(v,"");
		for(String r:list) {
			System.out.println(r);
		}	
	}
}
