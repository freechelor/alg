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
DC#98_Easy
Given a 2D board of characters and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, 
where "adjacent" cells are those horizontally or vertically neighboring. 
The same letter cell may not be used more than once.

For example, given the following board:

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
exists(board, "ABCCED") returns true, 
exists(board, "SEE") returns true, 
exists(board, "ABCB") returns false.
TC : O(AB*3^N) where A is the number of rows and B is the number of columns and N is the length of a word, SC : O(1)
 **/
public class SearchWordBoard {
	public static boolean isAdjacent(char[][] board, int i, int j, char[] c, int idx) {
		if(idx>=c.length) return true;
		char tmp = board[i][j];
		if(i>0 && board[i-1][j] == c[idx]) {
			board[i][j]='0';
			boolean res = isAdjacent(board, i-1, j, c, idx+1);
			if(res) return res;
			else {
				board[i][j] = tmp;
			}
		} 
		if(i<board.length-1 && board[i+1][j] == c[idx]) {
			board[i][j]='0';
			boolean res = isAdjacent(board, i+1, j, c, idx+1);
			if(res) return res;
			else {
				board[i][j] = tmp;
			}
		} 
		if(j>0 && board[i][j-1] == c[idx]) {
			board[i][j]='0';
			boolean res = isAdjacent(board, i, j-1, c, idx+1);
			if(res) return res;
			else {
				board[i][j] = tmp;
			}
		} 
		if(j<board[0].length-1 && board[i][j+1] == c[idx]) {
			board[i][j]='0';
			boolean res = isAdjacent(board, i, j+1, c, idx+1);
			if(res) return res;
			else {
				board[i][j] = tmp;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] arr = new char[][] 
		{
		  {'A','B','C','E'},
		  {'S','F','C','S'},
		  {'A','D','E','E'}
		};
		//String word = "ABCCED";
		//String word = "SEE";
		String word = "ABCB";
		char[] words = word.toCharArray();
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++) {
				if(arr[i][j]==words[0]) {
					if(isAdjacent(arr, i, j, words, 1)) {
						System.out.println("true");
						return;
					}
				}
			}
		}
		System.out.println("false");
	}
}
