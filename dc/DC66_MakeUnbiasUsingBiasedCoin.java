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
import java.util.Random;

/**
DC#66_Medium
This problem was asked by Square.

Assume you have access to a function toss_biased() which returns 0 or 1 with a probability that's not 50-50 (but also not 0-100 or 100-0). You do not know the bias of the coin.

Write a function to simulate an unbiased coin toss.
 **/
public class DC66_MakeUnbiasUsingBiasedCoin {
	static boolean cnt = true;
	static boolean cnt2 = true;

	public static int getUnbiased() {
		if(getBiased()==0) {
			if(cnt) {
				cnt = !cnt;
			   	return 0;
			} else {
				cnt = !cnt;
				return 1;
			}
		} else {
			if(cnt2) {
				cnt2 = !cnt2;
			   	return 0;
			} else {
				cnt2 = !cnt2;
				return 1;
			}
		}
	}

	public static int getUnbiasedByBook() {
		int first = getBiased();
		if(first==0 && getBiased()==1) {
			return 1;
		}
		if(first==1 && getBiased()==0) {
			return 0;
		}
		return getUnbiasedByBook();
	}

	static int[] p = new int[] { 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1 };
	public static int getBiased() {
		return p[new Random().nextInt(3)];
	}

	static int zeroCnt = 0;
	static int oneCnt = 0;

	public static void main(String[] args) {
		for(int i=0; i<10000000; i++) {
			int res = getUnbiasedByBook();
//			System.out.println(res);
			if(res == 0 ) zeroCnt++;
			else oneCnt++;
		}
		System.out.println("zeroCnt : " + zeroCnt + " , oneCnt : " + oneCnt);
	}
}
