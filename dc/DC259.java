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
import java.util.Map;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

/**
This problem was asked by Two Sigma.

Ghost is a two-person word game where players alternate appending letters to a word. 
The first person who spells out a word, or creates a prefix for which there is no possible continuation, loses. 
Here is a sample game:

    Player 1: g
    Player 2: h
    Player 1: o
    Player 2: s
    Player 1: t [loses]

Given a dictionary of words, determine the letters the first player should start with, 
such that with optimal play they cannot lose.

For example, if the dictionary is ["cat", "calf", "dog", "bear"], the only winning start letter would be b.
 */
public class DC259 {
	// TC
	// if I can find a character so that all words starting with a specific character are even
	public static char startsWith(String[] str) {
		HashMap<Character, Integer> map = new HashMap<>();
		for(String s : str) {
			if(map.get(s.charAt(0))!=null) {
				if(map.get(s.charAt(0))==-1) continue;
				else {
					if(s.length()%2!=0) {
						if(!isPrefix(s)) map.put(s.charAt(0), -1);
						else {
							if(
						}
					}
				}
			} else {
				if(s.length()%2!=0) {
					if(!isPrefix(s)) map.put(s.charAt(0), -1);
				} else {
					map.put(s.charAt(0), 0);
				}
			}
		}
		for(Map.Entry<Character,Integer> e : map.entrySet()) {
			if(e.getValue()!=-1) return e.getKey();
		}
		return Character.MAX_VALUE;
	}

	public static String[] prefixes = { "pre", "in" };
	
	public static boolean isPrefix(String pre) {
		for(String p : prefixes) {
			if(p.startsWith(pre)) return true;
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(startsWith(new String[] {"cat", "calf", "dog", "bear"}));
		System.out.println(startsWith(new String[] {"pre", "calf", "cat", "preload"}));
	}
}
