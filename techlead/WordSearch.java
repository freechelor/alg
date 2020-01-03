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
package alg.techlead;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

/**
You are given a 2D array of characters, and a target string. 
Return whether or not the word target word exists in the matrix. 
Unlike a standard word search, the word must be either going left-to-right, or top-to-bottom in the matrix.

Example:

{{'F', 'A', 'C', 'I'},
 {'O', 'B', 'Q', 'P'},
 {'A', 'N', 'O', 'B'},
 {'M', 'A', 'S', 'S'}}


Given this matrix, and the target word FOAM, you should return true, as it can be found going up-to-down in the first column.
 **/
public class WordSearch {
	// 1. TC : O(N+2^k) -> O(2^k) where N is total number of elements in matrix and k is the length of a word to find
	// 	  SC : O(k)
	// 		find the first character from the given word in the given matrix
	// 		then, find the next character from the given word in the right or downward
	//
	public static boolean searchWord(char[][] mtx, String word) {
		int i = 0;
		int j = 0;
		for( ; i<mtx.length; i++) {
			for( ; j<mtx[0].length; j++) {
				if(mtx[i][j]==word.charAt(0)) {
					boolean res = searchWordHelper(i,j, mtx, word, 1);
					if(res) return true;
				}
			}
		}	
		return false;
	}

	public static boolean searchWordHelper(int r, int c, char[][] mtx, String word, int idx) {
		if(idx>=word.length()) return true;
		boolean findRight = false;
		boolean findDown = false;
		if(r+1<mtx.length&&mtx[r+1][c]==word.charAt(idx)) findRight = searchWordHelper(r+1, c, mtx, word, idx+1);
		if(c+1<mtx[0].length&&mtx[r][c+1]==word.charAt(idx)) findDown = searchWordHelper(r, c+1, mtx, word, idx+1);
		return findRight||findDown;
	}

	public static void main(String[] args) {
		char[][] mtx = new char[][] {
			{'S', 'F', 'A', 'C', 'I'},
			{'T', 'O', 'O', 'Q', 'P'},
			{'V', 'A', 'N', 'A', 'B'},
			{'K', 'R', 'A', 'S', 'M'}};
		System.out.println(searchWord(mtx, "VANO"));
	}
}
