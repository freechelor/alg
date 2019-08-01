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
 * DC#63_Easy  @link(DC#98)
This problem was asked by Microsoft.

Given a 2D matrix of characters and a target word, 
write a function that returns whether the word can be found in the matrix by going left-to-right, or up-to-down.

For example, given the following matrix:

[['F', 'A', 'C', 'I'],
 ['O', 'B', 'Q', 'P'],
 ['A', 'N', 'O', 'B'],
 ['M', 'A', 'S', 'S']]
and the target word 'FOAM', 
you should return true, since it's the leftmost column. 
Similarly, given the target word 'MASS', you should return true, since it's the last row.

We will be sending the solution tomorrow, along with tomorrow's question. As always, feel free to shoot us an email if there's anything we can help with.

Have a great day!

@TODO  : Check P.S. Looking to commit to a new habit? Check out Daily Habit Mail to help keep yourself accountable!
 **/

public class SearchWordBoard2 {
	// Case1. IF each Character must be adjacent
	public static boolean canFind(char[][] board, int i, int j, char[] words, int idx) {
		if(board==null || board.length==0) return false;
		if(words.length<=idx) return true;
		if(i<board.length-1 && board[i+1][j]==words[idx]) {
			boolean res = canFind(board, i+1, j, words, idx+1);
			if(res) return true;
		}
		if(j<board[0].length-1 && board[i][j+1]==words[idx]) {
			boolean res = canFind(board, i, j+1, words, idx+1);
			if(res) return true;
		}
		return false;
	}

	// @TODO :
	// Case2. IF not adjacent, what should I do?
	// it means that all what I need to do is to check 
	// if I can find next character in the board i>i of character found previously and j>j of character found previously
	
	public static boolean canFind2(char[][] board, int i, int j, char[] words, int idx) {
		boolean res = false;
		if(words.length<=idx) return true;
		for(int si=i; si<board.length; si++) {
			for(int sj=j; sj<board[0].length; sj++) {
				if(si==i&&sj==j) continue;
				if(board[si][sj]==words[idx]) {
					res = canFind2(board, si, sj, words, idx+1);
					if(res) return res;
				}
			}
		}
		return false;
	}


	public static void main(String[] args) {
		char[][] board = new char[][]
			{{'F', 'A', 'C', 'I'},
			 {'O', 'B', 'Q', 'P'},
			  {'A', 'N', 'O', 'B'},
			   {'M', 'A', 'S', 'S'}};
		char[] words = "FBCS".toCharArray();
		boolean res = false;
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j]==words[0]) {
					res = canFind(board, i, j, words, 1);
				}
				if(res) {
					System.out.println("true");
					break;
				}
			}
			if(res) break;
		}
		if(!res) System.out.println("Case1 Ends False");
		for(int i=0; i<board.length; i++) {
			for(int j=0; j<board[0].length; j++) {
				if(board[i][j]==words[0]) {
					res = canFind2(board, i, j, words, 1);
				}
				if(res) {
					System.out.println("true");
					return;
				}
			}
		}
		System.out.println("false");
	}
}
