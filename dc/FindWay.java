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

public class FindWay {
	public int Min = Integer.MAX_VALUE;
	public int cur = 0;
	public boolean findWay(in[][] mtx, Pos s, Pos e) {
		int cMax = mtx[0].length;
		int rMax = mtx.length;
		int 
		for(int i=s.r-1; i<=s.r+1; i++) {
			for(int j=s.c-1; j<=s.c+1; j++) {
				if((i!=s.r||j!=s.c)&&isValid(mtx,i,j)) {
					if(findWay(mtx, new Pos(i,j), e)) { 
						cur++;
						return true;	
					} else {
					}
				}
			}
		}
		return false;
	}

	public boolean isValid(int[][] mtx, int x, int y) {
		if(x>=0&&x<mtx.length&&y>=0&&y<mtx[0].length&&mtx[x][y]==0) {
			return true;
		}
		return false;
	}	

	public static void main(String[] args) {
		int[][] = {{0,0,0,0}, {1,1, 0, 1}, {0, 0, 0, 0}, {0,0,0,0}};
	}
}

class Pos {
	public int r;
	public int c;

	public Pos(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
