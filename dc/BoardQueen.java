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

public class BoardQueen {
	public static int count = 0;

	public static void placeQueens(int[][] b, int r) {
		if(b.length<=r) {
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

	public static void main(String[] args) {
		int n = 2;
		int[][] board = new int[n][n];
		for(int i=0; i<board.length; i++) {
			Arrays.fill(board[i], 0);
		}
		for(int i=0; i<board.length; i++) {
			board[0][i] = 1;
			invalidate(board, 0, i);
			placeQueens(board, 1);
			unInvalidate(board, 0, i);
		}
		System.out.println("Total : " + count);
	}
}
