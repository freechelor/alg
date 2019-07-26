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
This problem was asked by Microsoft.

You have an N by N board. 
Write a function that, given N, returns the number of possible arrangements of the board 
where N queens can be placed on the board without threatening each other, 
i.e. no two queens share the same row, column, or diagonal.
@TODO : TC : n+n+n , n
@TODO : if asked the list of postions of queens placed properly
 **/
public class BoardQueen {
	public static int count = 0;

	public static void placeQueens(int[][] b, int r) {
		if(b.length<=r) {
			for(int i=0; i<b.length; i++) {
				System.out.println();
				for(int j=0; j<b[0].length; j++) {
					System.out.printf("%2d", (b[i][j]<0)? 0: b[i][j]);
				}
			}
			System.out.println();
			count++;
			return;
		}
		boolean found = false;
		for(int i=0; i<b.length; i++) {
			if(b[r][i]==0) {
				found = true;
				b[r][i] = 1;
				invalidate(b, r, i);
				placeQueens(b, r+1);
				unInvalidate(b, r, i);
				b[r][i] += -1;
			}
		}
		if(!found) return;
	}

	public static void invalidate(int[][] b, int r, int c) {
		// invalidate elm in row
		for(int i=0; i<b.length; i++) {
			if(i!=r) b[i][c] += -1;
		}	
		// invalidate elm in col
		for(int i=0; i<b.length; i++) {
			if(i!=c) b[r][i] += -1;
		}	

		// invalidate elm in diagonal
		for(int i=r+1; i<b.length; i++) {
			for(int j=0; j<b.length; j++) {
				if(Math.abs(i-r)==Math.abs(j-c)) b[i][j] += -1;
			}
		}	
	}
	
	public static void unInvalidate(int[][] b, int r, int c) {
		// uninvalidate elm in row
		for(int i=0; i<b.length; i++) {
			if(i!=r) b[i][c] += 1;
		}	
		// invalidate elm in col
		for(int i=0; i<b.length; i++) {
			if(i!=c) b[r][i] += 1;
		}	

		// invalidate elm in diagonal
		for(int i=r+1; i<b.length; i++) {
			for(int j=0; j<b.length; j++) {
				if(Math.abs(i-r)==Math.abs(j-c)) b[i][j] += 1;
			}
		}	
	}

	// to speed up calculation time, we can use symetric feature
	// let say, just calculate for half the columns and make it 2 times
	// in case the number of columns is odd, should calculate for the column in the middle of columns and plus
	public static void runCases(int n) {
		int[][] board = new int[n][n];
		for(int i=0; i<board.length; i++) {
			Arrays.fill(board[i], 0);
		}
		for(int i=0; i<board.length; i++) {
			board[0][i] = 1;
			invalidate(board, 0, i);
			placeQueens(board, 1);
			unInvalidate(board, 0, i);
			board[0][i] += -1;
		}
	}

	public static void main(String[] args) {
		for(int i=4; i<7; i++) {
			runCases(i);
			System.out.println(i + " by " + i +  " - Total : " + count);
			count = 0;
		}
	}
}

class Pair {
	public int r;
	public int c;
	public Pair(int a, int b) {
		r = a;
		c = b;
	}
}
