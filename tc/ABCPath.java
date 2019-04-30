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
package alg.tc;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;


public class ABCPath {
	static int max = 0;
	public Queue<Pos> getPosition(char elm, int x, int y, String[] mtx) {
		Queue<Pos> q = new LinkedList<Pos>();
		int sx, sy, ex, ey;
		sx = x-1; ex=x+1;
		sy = y-1; ey=y+1;
		if(x==0) sx=0;
		if(x==mtx.length-1) ex=mtx.length-1;
		if(y==0) sy=0;
		if(y==mtx[0].length()-1) ey=mtx[0].length()-1;
		for(int i = sx; i <= ex; i++) {
			String t = mtx[i];
			for(int j = sy; j <= ey; j++) {
				if(t.charAt(j)==elm) q.add(new Pos(i, j));
			}
		}
		if(q.size()==0) return null;
		else {
			return q;
		}
	}

	public void getPath(char elm, int x, int y, String[] mtx, int cur) {
		Queue<Pos> res = getPosition(elm, x, y, mtx);
		if(res==null) {
			if(cur>max) max=cur;
		} else {
			System.out.println("Trying to find :" + elm + ":" + (cur+1));
			cur++;
			while(res.size()>0) {
				Pos p = res.remove();
				System.out.println((char)(elm) + " : " + p.x + " , " + p.y);
				getPath((char)(elm+1), p.x, p.y, mtx, cur);
			}
		}
	}

	public int getLPath(String[] s) {
		// 0. find starting point element 'A'
		// 1. try to find next element in 8 adjacents
		// 2. if found, increase path length by 1, and go find next element repeat step 2.
		// 3. if not found, decrease path length by 1, and try step 2 starting from other next elements
		// 4. print path length
		//

		return 0;
	}

//	ABCD
//	BCDE
//	DEFG
//	GFHR
//	HIKS
//	LJNG
//	UOME
//	PQNO
	public static void main(String args[]) {
		String[] mtx = {
  "ABCD",
  "BCDE",
  "DEFG",
  "GFHR",
  "HIKS",
  "LJNL",
  "UOME",
  "PQNO"};
		ABCPath p = new ABCPath();
		p.getPath('A', 0, 0, mtx, 0);
		System.out.println(max);
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
