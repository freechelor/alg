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
DC#34_medium

Given a string, 
find the palindrome that can be made by inserting the fewest number of characters as possible anywhere in the word. 
If there is more than one palindrome of minimum length that can be made, 
return the lexicographically earliest one (the first one alphabetically).

For example, given the string "race", you should return "ecarace", 
since we can add three letters to it (which is the smallest amount to make a palindrome). 
There are seven other palindromes that can be made from "race" by adding three letters, 
but "ecarace" comes first alphabetically.
*/
public class Palindrome {
	private boolean isPalindrome(String s) {
		int l = 0;
		int r = s.length()-1;
		while(l<r) {
			if(s.charAt(l)==s.charAt(r)) {
				l++;
				r--;
			} else return false;
		}
		return true;
	}	

	private String shortestPalindrome(String s) {
		if(isPalindrome(s)) return s;
		else {
			if(s.charAt(0)==s.charAt(s.length()-1)) {
				return s.charAt(0) + shortestPalindrome(s.substring(1, s.length()-1)) + s.charAt(0);
			} else {
				String a = s.charAt(0) + shortestPalindrome(s.substring(1)) + s.charAt(0);	
				String b = s.charAt(s.length()-1) + shortestPalindrome(s.substring(0, s.length()-1)) + s.charAt(s.length()-1);	
				if(a.length()>b.length()) return b;
				else if(a.length()<b.length()) return a;
				else {
					if(a.compareTo(b)<0) return a;
					else return b;
				}
			}
		}
	}

	private HashMap<String, String> cache = new HashMap<>();
	private String shortestPalindromeDP(String s) {
		if(cache.get(s)!=null) return cache.get(s);
		if(isPalindrome(s)) {
			cache.put(s,s);
			return s;
		}
		else {
			if(s.charAt(0)==s.charAt(s.length()-1)) {
				String tmp = s.charAt(0) + shortestPalindrome(s.substring(1, s.length()-1)) + s.charAt(0);
				cache.put(s, tmp);
				return tmp;
			} else {
				String a = s.charAt(0) + shortestPalindrome(s.substring(1)) + s.charAt(0);	
				String b = s.charAt(s.length()-1) + shortestPalindrome(s.substring(0, s.length()-1)) + s.charAt(s.length()-1);	
				if(a.length()>b.length()) {
					cache.put(s,b);
					return b;
				} else if(a.length()<b.length()) { 
					cache.put(s,a);
					return a;
				}
				else {
					if(a.compareTo(b)<0) { 
						cache.put(s,a);
						return a;
					} else { 
						cache.put(s,b);
						return b;
					}
				}
			}
		}
	}
	public static void main(String[] args) {
		Palindrome p = new Palindrome();
		System.out.println(p.isPalindrome("goog"));
		long s = System.currentTimeMillis();
		System.out.println(p.shortestPalindrome("agjoewksdaglsdsgoosealoeowogoogle"));
		System.out.println(p.shortestPalindrome("agjoweijadlskdjalecaraceaheigh"));
		System.out.println(System.currentTimeMillis()-s);
	
		s = System.currentTimeMillis();
		System.out.println(p.shortestPalindromeDP("agjoewksdaglsdsgoosealoeowogoogle"));
		System.out.println(p.shortestPalindromeDP("agjoweijadlskdjalecaraceaheigh"));
		System.out.println(System.currentTimeMillis()-s);
	}
}
