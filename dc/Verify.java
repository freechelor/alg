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
Write an algorithm to justify text. Given a sequence of words and an integer line length k, 
return a list of strings which represents each line, fully justified.

More specifically, you should have as many words as possible in each line. 
There should be at least one space between each word. Pad extra spaces when necessary 
so that each line has exactly length k. Spaces should be distributed as equally as possible, 
with the extra spaces, if any, distributed starting from the left.

If you can only fit one word on a line, then you should pad the right-hand side with spaces.

Each word is guaranteed not to be longer than k.

For example, given the list of words ["the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"] and k = 16, you should return the following:

["the  quick brown", # 1 extra space on the left
"fox  jumps  over", # 2 extra spaces distributed evenly
"the   lazy   dog"] # 4 extra spaces distributed evenly
*/
public class Verify {

	public String distributeWords(String[] w, int k) {
		int i=0;
		String st="";
		String res = "";
		int orgK = k;
		while(i++<w.length) {
			if(w[i].length()<k) {
				st += w[i] + " ";
				k -= w[i].length()+1;
			} else if(w[i].length()==k) {
				st += w[i];
				k -= w[i].length();
			} else if(w[i].length()>k && k>0) {
				st = insertSpaceEvenly(st, k);
				k = 0;
			}
			if(k==0) {
				res += st + ",";
				st = "";
				k = orgK;
			}
		}
		return res;
	}

	public String insertSpaceEvenly(String s, int k) {
		int i = 0;
		while(i++<s.length()) {
			if(s.charAt(i)==' '&&k>0) {
				s = s.substring(0,i) + " " + s.substring(i);
				k--;
				i++;
				while(i++<s.length()) {
					if(!s.charAt(i).equals(" ")) {
						break;
					}
				}
			}
			if(i==s.length()-1 && k>0) {
				i=0;
			}
		}
		return s;
	}

	public static void main(String[] args) {
		String[] words = {"the", "quick", "brown", "fox", "jumps", "over", "the", "lazy", "dog"};
		System.out.println(new Verify().distributeWords(words, 16));
	}
}
