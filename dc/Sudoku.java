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

public class Sudoku {
	public boolean isProper(int n, int r, int c, int[][] mtx) {
		System.out.println(n + " at ["+r+","+c+"]");
		for(int j = 0; j<r; j++) {
			if(n==mtx[j][c]) { 
				System.out.println("in the row : " + n + " at ["+j+","+c+"]");
				return false;
			}
		}
		for(int i = 0; i<c; i++) {
			if(n==mtx[r][i]) {
				System.out.println("in the column : " + n + " at ["+r+","+i+"]");
				return false;
			}
		}

		int sr = r/3;
		int sc = c/3;
		for(int j = sr*3; j < sr*3+3; j++) {
			for(int i = sc*3; i < sc*3+3; i++) { 
				if(n==mtx[j][i]) { 
					System.out.println("subMat : " + n + " at ["+j+","+i+"]");
					return false;
				}
			}
		}
		return true;
	}

	public boolean solveSudoku(int[][] mtx) {
		boolean isCompleted = true;
		boolean found = false;
		for(int j=0; j<mtx.length; j++) {
			for(int i=0; i<mtx[0].length; i++) {
				if(mtx[j][i]==0) {
					isCompleted = false;
					for(int k=1; k<=9; k++) {
						if(isProper(k, j, i, mtx)) {
							found = true;
							mtx[j][i]=k;
							if(solveSudoku(mtx)) return true;
							else { 
								found = false;
								mtx[j][i]=0;
							}
						}
					}
					if(!found) return false;
				}
			}
		}
		return isCompleted;
	}

	public static void main(String[] args) {
		Sudoku s = new Sudoku();
		/*int[][] mtx = {
			{1, 2, 3, 4, 5, 6, 7, 8, 9},
			{4, 5, 6, 7, 8, 9, 1, 2, 3},
			{7, 8, 9, 1, 2, 3, 4, 5, 6},
			{2, 3, 4, 5, 6, 7, 8, 9, 1},
			{5, 6, 7, 8, 9, 1, 2, 3, 4},
			{8, 9, 1, 2, 3, 4, 5, 6, 7},
			{3, 4, 5, 6, 7, 8, 9, 1, 2},
			{6, 7, 8, 9, 1, 2, 3, 4, 5},
			{9, 1, 2, 3, 4, 5, 6, 7, 8},
		}*/
		int[][] mtx = {
			{1, 0, 3, 4, 5, 6, 7, 8, 9},
			{4, 5, 0, 7, 8, 9, 1, 2, 3},
			{7, 8, 0, 1, 2, 3, 4, 5, 0},
			{2, 3, 0, 0, 0, 7, 8, 9, 1},
			{0, 6, 7, 8, 0, 0, 0, 3, 4},
			{8, 9, 1, 2, 3, 4, 5, 6, 7},
			{3, 4, 5, 0, 7, 0, 9, 1, 0},
			{6, 0, 8, 9, 0, 2, 3, 0, 5},
			{0, 1, 2, 3, 4, 5, 6, 7, 8},
		};
		s.solveSudoku(mtx);
		for(int i = 0; i < mtx.length; i++) {
			for(int j = 0; j < mtx[0].length; j++) {
				System.out.print(mtx[i][j] + ",");
			}
			System.out.println();
		}
	}
}
