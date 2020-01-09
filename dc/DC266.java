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
/**
 *
This problem was asked by Pivotal.

A step word is formed by taking a given word, adding a letter, and anagramming the result. 
For example, starting with the word "APPLE", you can add an "A" and anagram to get "APPEAL".

Given a dictionary of words and an input word, create a function that returns all valid step words.
 */
public class DC266_ValidStepWord {
	/**
	 * 1. 
	 * 		Anagramming means we can change order of character in a word.
	 * 		So, if we have the same number of individual character from 2 words, we can make the words the same.
	 * 		first, sort each word in a dictionary, 
	 * 		second, add a letter and sort the word
	 * 		third, find it from the dictionary which has sorted characters.
	 * 		TC : O(m log n), where m is the number of words in the dictionary and n is the longest word.
	 * 			 because I have to sort all the words in dictionary (m log n)
	 * 			 and I have to sort a given word (log gw), where a length of a given word is gw
	 * 		SC : O(log n), where n is the longest word in the dictionary and we need space complexity for sorting itself
	 * 		https://www.bigocheatsheet.com/
	 * 		TODO: there's another thing that I missed. you need to find which letter you should add to a given word.
	*/

	public String[] findValidStepWords(String[] dic
	public static void main(String[] args) {
		String word = args[0];
		String[] dic = new String[] { "appeal", "" };
		String[] res = findValidStepWords(dic, word);
		for(String r : res) {
			System.out.print( r + " ");
		}
		System.out.println();
	}
}
