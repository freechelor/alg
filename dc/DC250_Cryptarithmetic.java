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
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;
/*
DC#250_MEDIUM
A cryptarithmetic puzzle is a mathematical game 
where the digits of some numbers are represented by letters. 
Each letter represents a unique digit.
For example, a puzzle of the form:

  SEND
+ MORE
--------
 MONEY

may have the solution:

{'S': 9, 'E': 5, 'N': 6, 'D': 7, 'M': 1, 'O', 0, 'R': 8, 'Y': 2}

Given a three-word puzzle like the one above, create an algorithm that finds a solution.
*/
public class DC250_Cryptarithmetic {
	// 1. brute force
	// if in a line, from the top X, Y, Z show up, it means X+Y=Z or (X+Y)%10=Z
	// And we know each character is a unique number between 0 and 9 inclusively.
	// So, we can go through iteration of each line's sum assigning unique number to each character till we find the rule is valid.
	static char[] chs = new char[26];
	static boolean[] bool = new boolean[10];
	public static boolean solveCryptarithmetic(String first, String second, String res, int col, int carriage) {
		if(first==null||first.length()==0) return false;
		if(second==null||second.length()==0) return false;	
		if(res==null||res.length()==0) return false;	
		char f = Character.MIN_VALUE;
		char s = Character.MIN_VALUE;
		char r = Character.MIN_VALUE;
		if(col>=first.length()&&col>=second.length()) {
			if(res.length()>col) {
				chs[res.charAt(res.length()-1-col)-'A'] = (char)1;	
				if(!bool[1]) return true;
				else return false;
			}
			return true;
		}

		if(col<first.length()) {
			f = first.charAt(first.length()-1-col);
		}
		if(col<second.length()) {
			s = second.charAt(second.length()-1-col);
		}
		int i = 0;
		while(i<bool.length) {
			if(!bool[i]) {
				bool[i] = true;
				chs[f-'A'] = (char)i;
				int j = i+1;
				while(j<bool.length) {
					if(!bool[j]) {
						bool[j] = true;
						chs[s-'A'] = (char)j;
						r = res.charAt(res.length()-1-col);
						if((int)f+(int)s<10) {
							chs[r-'A'] = (char)((int)f+(int)s+carriage);
							carriage = 0;
						} else {
							chs[r-'A'] = (char)(((int)f+(int)s+carriage)%10);
							carriage = 1;
						}
						boolean result = solveCryptarithmetic(first, second, res, col+1, carriage);
						if(!result) bool[j] = false;
						else return result;
					}
					j++;
				}
				bool[i] = false;
			}
			i++;
		}
		return false;
	}

	public static void main(String[] args) {
		Arrays.fill(bool, false);
		System.out.println(solveCryptarithmetic("SEND", "MORE", "MONEY", 0, 0));
		for(char c : chs) {
			System.out.println((char)(c+'A') + ":" + (int)c);
		}
	}
}
