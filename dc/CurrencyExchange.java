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
 *
DC#32_Hard
This problem was asked by Jane Street.

Suppose you are given a table of currency exchange rates, represented as a 2D array. 
Determine whether there is a possible arbitrage: 
that is, whether there is some sequence of trades you can make, 
starting with some amount A of any currency, 
so that you can end up with some amount greater than A of that currency.

There are no transaction costs and you can trade fractional quantities.
 * */
public class CurrencyExchange {
	public static float[] cur = null;
	public boolean getGain(int s, int c, int[][] t, float amt, float fixAmt) {
		if(s!=c && amt*t[c][s]>fixAmt) return true;
		else {
			for(int i=0; i<t.length; i++) {
				if(c!=i) return getGain(s, i, t, amt*t[c][i], fixAmt);
			}
		}
	}

	public static void main(String[] args) {
		// 0 -> 1 -> 2 -> 0
		// 0 -> 2 -> 1 -> 0
		// 0 -> 1 -> 0 	-- meaningless
		// 0 -> 2 -> 0  -- meaningless
		float[][] cTbl = {
			{ 1, 		8.94,   0.87 },
			{ 1/8.94,      1,  241.32},
			{ 1/0.87, 	1/241.32,	1},
		};
		float amt = 109.1;
		cur = new float[cTbl.length];
	}
}
