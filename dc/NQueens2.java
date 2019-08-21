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
import java.util.Vector;

public class NQueens2 {
	Vector<Integer> v = new Vector<>();
	public boolean solveNQueens(int[][] mtx, int r) {
		boolean found = false;
		// if first case
		for(int i=0; i<8; i++) {
			if(r==0) v.add(i);

			for(int j=0; j<8; j++) {
				if(j
			}
		}
		
	}

	public void print() {
		System.out.println("Solved");
	}

	public void print(int[][] mtx) {
		for(int i=0; i<mtx.length; i++) {
			for(int j=0; j<mtx[0].length; j++) {
				System.out.printf("%6d, ", mtx[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		NQueens2 nQ = new NQueens2();
		int[][] mtx = {
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0}};
		if(nQ.solveNQueens(mtx,0)) nQ.print(mtx);
		else System.out.println("Not solved");
	}
}

class Pos {
	int x;
	int y;
	public Pos(int x, int y) {
		this.x = x;
		this.y = y;
	}
}
