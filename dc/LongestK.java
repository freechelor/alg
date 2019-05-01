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
import java.util.Hashtable;
import java.util.Vector;

/*Given an integer k and a string s, 
find the length of the longest substring that contains at most k distinct characters.
For example, given s = "abcba" and k = 2, 
the longest substring with k distinct characters is "bcb".*/

public class LongestK {
	Hashtable<Character,Integer> tbl = new Hashtable<>();
	int max = 0;	
	int rMax = Integer.MIN_VALUE;
	int usedC = 0;
	Vector<Character> v = new Vector<>(); // to change vector to any other kind of class
	Character first = null;

	public int getLongest(String s, int k) {
		if(s==null) return max;
		char[] c = s.toCharArray();

		first = c[0];
		System.out.println("INPUT : " + s);
		for(int i = 0; i < c.length; i++) {
			System.out.println("adding : " + c[i]);
			v.add(c[i]);
			if(tbl.get(c[i])!=null) {
				tbl.put(c[i],tbl.get(c[i])+1);
				max++;
				if(max>rMax) {
					rMax = max;
					System.out.println("=================== FROM " + v.elementAt(0) + " to " + v.elementAt(v.size()-1) +
							" length : " + rMax);
				}
			} else if(tbl.get(c[i])==null) {
				if(usedC<k) {
					tbl.put(c[i], 1);
					max++;
					if(max>rMax) {
						rMax = max;
						System.out.println("=================== FROM " + v.elementAt(0) + " to " + v.elementAt(v.size()-1) + " length : " + rMax);
					}
					usedC++;
				} else {
					System.out.println("before entering : " + first);
					while(usedC>=k) {
						first = v.remove(0);
						System.out.println("In while loop : " + first + " , table size : " + tbl.size());
						int cnt = tbl.get(first)-1;
						if(cnt>0)
							tbl.put(first, cnt);
						else {
							tbl.remove(first);
							usedC--;
						}
						max--;
					}
					tbl.put(c[i],1);
					max++;
					usedC++;
				}
			}
		}
		int vs = v.size();
		//System.out.println(v.elementAt(0) + " : " + v.elementAt(vs-1));
		return rMax;
	}

	public static void main(String[] args) {
		System.out.println(new LongestK().getLongest("abcbbbbrrqsboooa",2));
		System.out.println(new LongestK().getLongest("abcbbbbrrqsboooa",3));
	}
}
