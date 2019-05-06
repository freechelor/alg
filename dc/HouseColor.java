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
import java.util.Arrays;

public class HouseColor {
	static int min = Integer.MAX_VALUE;
	static int[][] cache = null;
	static public int getMinDP(int[][] c, int house, int color, int e) {
		if(house>=c.length) return 0;
		int subMin = Integer.MAX_VALUE;
		for(int j=0; j<color; j++) {
			if(e==j) {
				continue;
			} else {
//				System.out.print(c[house][j] + " , ");
				int tmp = 0;
				if(cache[house+1][j]==0) {
					cache[house+1][j] = getMinDP(c, house+1, color, j);
					System.out.printf("cache[%d][%d]=%d", house+1, j, cache[house+1][j]);
					System.out.println();
					tmp = c[house][j] + cache[house+1][j];
				} else {
					System.out.println(">>>>>>>>>>>>>> HIT >>>>>>>>>>>>>>>>>>>>");
					tmp = c[house][j] + cache[house+1][j];
				}
				System.out.println();
				if(subMin>tmp) subMin = tmp;
			}
		}
		return subMin;
	}

	static public int getMin(int[][] c, int house, int color, int e) {
		if(house>=c.length) return 0;
		int subMin = Integer.MAX_VALUE;
		for(int j=0; j<color; j++) {
			if(e==j) {
				continue;
			} else {
//				System.out.print(c[house][j] + " , ");
				int tmp = c[house][j] + getMin(c, house+1, color, j);
//				System.out.println();
				if(subMin>tmp) subMin = tmp;
			}
		}
		return subMin;
	}

	public static void main(String[] args) {
		int[][] c = {
			{10, 3, 5, 6},	//3
			{8, 9, 5, 4},	//4
			{7, 4, 5, 6},//5
			{10, 3, 9, 5},//3
			{5, 8, 5, 6},//5
			{6, 8, 9, 5},//6
			{8, 3, 4, 2},//2
			{3, 8, 5, 9},//3
			{5, 3, 8, 6},//3
			{12, 3, 8, 6},//3
			{5, 3, 9, 6},//3
			{8, 3, 8, 6},//3
			{5, 3, 8, 16},//3
			{1, 3, 18, 6},//3
			{5, 7, 8, 6},//3

			{10, 3, 5, 6},	//3
			{8, 9, 5, 4},	//4
			{7, 4, 5, 6},//5
			{10, 3, 9, 5},//3
			//{5, 8, 5, 6},//5
			//{6, 8, 9, 5},//6
			//{8, 3, 4, 2},//2
			//{3, 8, 5, 9},//3
			//{5, 3, 8, 6},//3
		};
		cache = new int[c.length+1][c[0].length];
		for( int i =0; i < cache.length; i++) {
			Arrays.fill(cache[i],0);
		}
		long l = System.nanoTime();
		System.out.println(getMin(c, 0, 4, -1));
		long elp = System.nanoTime()-l;
		long l2 = System.nanoTime();
		System.out.println(getMinDP(c, 0, 4, -1));
		long elp2 = System.nanoTime()-l2;
		System.out.println( elp/1000000 + " : " + elp2/1000000);
	}
}
