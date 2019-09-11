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
		return 0;
	}


	// make hashmap which has characters as keys and indices as values
	// loop the given string when meet one of characters given, find other characters from hashmap and calculate distance, the sum of distances of farthest ones to the left and the right is the distance
	// i.e.
	// figehaeci, at index 3, on the left to the i distance is 2, on the right to the 
	/*public static void main(String[] args) {
		// a e i e a a e i i e a
		//
	}*/

	static final int no_of_chars = 256; 
	
	// Function to find smallest window containing 
	// all characters of 'pat' 
	// THIS SOLUTION is NOT for the problem, but for similar one
	static String findSubString(String str, String pat) { 
		int len1 = str.length(); 
		int len2 = pat.length(); 
	
		// check if string's length is less than pattern's 
		// length. If yes then no such window can exist 
		if (len1 < len2) 
		{ 
			System.out.println("No such window exists"); 
			return ""; 
		} 
	
		int hash_pat[] = new int[no_of_chars]; 
		int hash_str[] = new int[no_of_chars]; 
	
		// store occurrence ofs characters of pattern 
		for (int i = 0; i < len2; i++) 
			hash_pat[pat.charAt(i)]++; 
	
		int start = 0, start_index = -1, min_len = Integer.MAX_VALUE; 
	
		// start traversing the string 
		int count = 0; // count of characters 
		for (int j = 0; j < len1 ; j++) 
		{ 
			// count occurrence of characters of string 
			hash_str[str.charAt(j)]++; 
	
			// If string's char matches with pattern's char 
			// then increment count 
			if (hash_pat[str.charAt(j)] != 0 && 
				hash_str[str.charAt(j)] <= hash_pat[str.charAt(j)] ) 
				count++; 
	
			// if all the characters are matched 
			if (count == len2) 
			{ 
				// Try to minimize the window i.e., check if 
				// any character is occurring more no. of times 
				// than its occurrence in pattern, if yes 
				// then remove it from starting and also remove 
				// the useless characters. 
				while ( hash_str[str.charAt(start)] > hash_pat[str.charAt(start)] 
					|| hash_pat[str.charAt(start)] == 0) 
				{ 
	
					if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]) 
						hash_str[str.charAt(start)]--; 
					start++; 
				} 
	
				// update window size 
				int len_window = j - start + 1; 
				if (min_len > len_window) 
				{ 
					min_len = len_window; 
					start_index = start; 
				} 
			} 
		} 
	
		// If no window found 
		if (start_index == -1) 
		{ 
		System.out.println("No such window exists"); 
		return ""; 
		} 
	
		// Return substring starting from start_index 
		// and length min_len 
		return str.substring(start_index, start_index + min_len); 
	} 

	// we will move from the first character of string to a next one.
	// if the character matches one of characters given, we will set the index in another array int[]
	// if all int[] is set, get value difference between the minimum index and the maximum index	
	// and then, compare the value with the previous minimum value and if needed update
	// then, move to next in the string and update index if the character matches with one in char[] array
	// then, calculate the length again
	static HashMap<Character, Integer> map = new HashMap<>();
	static boolean hasSolution = true;
	public static String shortestString(String org, char[] c) {
		int[] flag = new int[c.length];
		int count = 0;
		int[] charset = new int[26];
		int shortest = Integer.MAX_VALUE;
		int start = 0;
		int end = 0;
		for(int i=0; i<c.length; i++) {
			charset[c[i]-'a'] = 1;
		}
		for(int i=0; i < org.length(); i++) {
			if(charset[org.charAt(i)-'a']==1) {
				map.put(new Character(org.charAt(i)), i);
				int min = Integer.MAX_VALUE;
				int max = Integer.MIN_VALUE;
				for(int j=0; j<c.length; j++) {
					int tmp = map.getOrDefault(c[j], -1);
					if(tmp!=-1) {
						hasSolution = true;
						if(tmp<min) min = tmp;
						if(tmp>max) max = tmp;
					} else {
						hasSolution = false;
						break;
					}
				}
				if(hasSolution) {
					if(shortest>max-min) { 
						shortest = max-min;
						start = min;
						end = max;
						System.out.println("min : " + min + " , max : " + max);
					}
				}
			}
		}
		return org.substring(start, end+1);
	}

	// Driver Method 
	public static void main(String[] args) { 
		String str = "this is a test string"; 
		String pat = "tist"; 
	
		System.out.println("Smallest window is :\n " + 
						findSubString(str, pat)); 
		String str2 = "figehaecawouthbowdheslbieoahwakleiqtehdkhgioeni";
		//String str2 = "figehaeci";
		System.out.println(shortestString(str2, new char[] {'a','e','i'}));
	} 
}
