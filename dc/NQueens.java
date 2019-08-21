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

public class NQueens {
	// check if it's valid position in the board not to attack any other queens already placed
	public boolean setQueen(int x, int y, int[][] mtx) {
		if(mtx[x][y]>=0) return true;
		else return false;
	}

	public void setInvalid(int x, int y, int[][] mtx) {
		System.out.printf("setInvalid : [%d, %d]\n", x, y);
		for(int i=0; i<mtx[x].length; i++) { 
			if(y!=i) mtx[x][i] += -1;
		}
		for(int j=0; j<mtx.length; j++) {
			if(x!=j) mtx[j][y] += -1;
		}
		for(int i=0; i<mtx.length; i++) {
			for(int j=0; j<mtx[0].length; j++) {
				if(Math.abs(x-i)==Math.abs(y-j) && (x!=i&&y!=j)) mtx[i][j] += -1;
			}
		}
		mtx[x][y] -= 10000;
	}

	public void setValid(int x, int y, int[][] mtx) {
		for(int i=0; i<mtx[x].length; i++) {
			if(y!=i) mtx[x][i] += 1;
		}
		for(int j=0; j<mtx.length; j++) {
			if(x!=j) mtx[j][y] += 1;
		}
		for(int i=0; i<mtx.length; i++) {
			for(int j=0; j<mtx[0].length; j++) {
				if(Math.abs(x-i)==Math.abs(y-j) && (x!=i&&y!=j)) mtx[i][j] += 1;
			}
		}
		mtx[x][y] += 10000;
	}

	public int k = 0;
	public Vector v = new Vector();
	public boolean solveNQueens(int[][] mtx, int sx, int sy, int n) {
		System.out.println("K value : " + k);
		for(int i=sx; i<mtx.length; i++) {
			boolean found = false;
			for(int j=sy; j<mtx[0].length; j++) {
				if(setQueen(i, j, mtx)) {
					v.add(new Pos(i,j));
					if(n-1==0) return true;
					if(solveNQueens(mtx, sx+1, 0, n-1)) return true;
					else {
						v.remove(new Pos(i,j));
					}
				}
			}
			if(!found) {
				Post p = v.remove(v.size()-1); 
				setValid(p.x, p.y, mtx);
				return solveNQueens(mtx, p.x-1, p.y+1, n);
			}
		}
		return false;
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
		NQueens nQ = new NQueens();
		int[][] mtx = {
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0},
			{0, 0, 0, 0, 0, 0, 0, 0}};
		if(nQ.solveNQueens(mtx, 0, 0, 8)) nQ.print(mtx);
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
