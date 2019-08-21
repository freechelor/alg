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
DC#64_Hard
This problem was asked by Google.

A knight's tour is a sequence of moves by a knight on a chessboard such that all squares are visited once.

Given N, write a function to return the number of knight's tours on an N by N chessboard.
**/
public class DC64_KnightsTouronNbyN {
	public static int total = 0;
	public static int cnt = 0;

	public static boolean isValid(Position p, int[][] board) {
		if(p.x>=0 && p.x<board.length && p.y>=0 && p.y<board[0].length) {
			if(board[p.x][p.y]==0) {
				return true;
			}
		}
		return false;
	}

	public static void findWays(Position p, int[][] board) {
		if(!isValid(p,board)) return;
		Position prev = p;
		board[p.x][p.y] = -1;
		total--;
		if(total==0) {
			cnt++;		
		} else {
		// try to 8 direction
			Position t = new Position(p.x+1, p.y+2);
			findWays(t, board);
			t.x = p.x-1;
			findWays(t, board);

			t = new Position(p.x+1, p.y-2);
			findWays(t, board);
			t.x = p.x-1;
			findWays(t, board);

			t = new Position(p.x+2, p.y+1);
			findWays(t, board);
			t.x = p.y-1;
			findWays(t, board);

			t = new Position(p.x-2, p.y+1);
			findWays(t, board);
			t.x = p.y-1;
			findWays(t, board);
			if(total>0) return;
		}
		board[p.x][p.y] = 0;
		total++;
	}

	public static void reset(int N, int[][] arr) {
		for(int i=0; i<N; i++) {
			Arrays.fill(arr[0], 0);
		}
	}

	public static void main(String[] args) {
		int N = 3;
		total = N*N;
		int[][] b = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				reset(N, b);
				findWays(new Position(i,j), b);
			}
		}
		System.out.println("Count : " + cnt);
	}
}

class Position {
	public int x;
	public int y;

	public Position(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
