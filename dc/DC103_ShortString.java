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
DC#103_Medium
_NOT_INVENT_CLUE
This problem was asked by Square.

Given a string and a set of characters, 
return the shortest substring containing all the characters in the set.

For example, given the string "figehaeci" and the set of characters {a, e, i}, 
you should return "aeci".

If there is no substring containing all the characters in the set, return null.
 **/

/**
from collections import defaultdict

def smallest(s1, s2):
    assert s2 != ''
    d = defaultdict(int)
    nneg = [0]  # number of negative entries in d
    def incr(c):
        d[c] += 1
        if d[c] == 0:
            nneg[0] -= 1
    def decr(c):
        if d[c] == 0:
            nneg[0] += 1
        d[c] -= 1
    for c in s2:
        decr(c)
    minlen = len(s1) + 1
    j = 0
    for i in xrange(len(s1)):
        while nneg[0] > 0:
            if j >= len(s1):
                return minlen
            incr(s1[j])
            j += 1
        minlen = min(minlen, j - i)
        decr(s1[i])
    return minlen
**/
public class DC103_ShortString {
	// brute force
	// window size from the number of characters, let say 3 if charaters are {a,e,i}	
	// check if every character exists in the window sliding with its first index from 0 to length of window-1
	// TC : O(n x w x c) -> O(n^3xc) where c is the number of characters, w is the size of windows, and n is the length of a given string


	public static int len(String s, char[] c) {
		// the distance from the fist matching character to the second matching character	
		// plus len(substring(index of the second matching charater), char[] except the first matching character)
	}

	// make hashmap which has characters as keys and indices as values
	// loop the given string when meet one of characters given, find other characters from hashmap and calculate distance, the sum of distances of farthest ones to the left and the right is the distance
	// i.e.
	// figehaeci, at index 3, on the left to the i distance is 2, on the right to the 
	public static void main(String[] args) {
		// a e i e a a e i i e a
		//
	}
}
