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
import java.util.Random;
import java.util.Stack;
import java.util.Queue;

/**
DC#51_Medium
This problem was asked by Facebook.

Given a function that generates perfectly random numbers between 1 and k (inclusive), where k is an input, write a funct
ion that shuffles a deck of cards represented as an array using only swaps.

It should run in O(N) time.

Hint: Make sure each one of the 52! permutations of the deck is equally likely.
 **/
public class DC51_ShuffleCards {
	public static int getRandom(int k) {
		return new Random().nextInt(k);
	}

	public static void main(String[] args) {
		int k = 108;
		String[] deck = new String[] {
			"H2", "H3", "H4", "H5", "H6", "H7", "H8", "H9", "H10", "HA", "HJ", "HQ", "HK",
			"S2", "S3", "S4", "S5", "S6", "S7", "S8", "S9", "S10", "SA", "SJ", "SQ", "SK",
			"C2", "C3", "C4", "C5", "C6", "C7", "C8", "C9", "C10", "CA", "CJ", "CQ", "CK",
			"D2", "D3", "D4", "D5", "D6", "D7", "D8", "D9", "D10", "DA", "DJ", "DQ", "DK"};
		if(k>=52) {
			for(int i=0; i<52; i++) {
				int a = getRandom(k);
				int b = getRandom(k);
				while(b==a) {
					b = getRandom(k);
				}
				swap(a,b, deck);
			}
		} else {
			int remainder = 52%k;
			int reverseSet = (remainder==0) 52/k : 52/k+1;
			int set = 52/reverseSet;
		}
		System.out.println();
		for(String a : deck) {
			System.out.printf("%s ", a);
		}
	}

	public static void swap(int a, int b, String[] d) {
		String tmp = d[a%52];
		d[a%52] = d[b%52];
		d[b%52] = tmp;
	}
}
