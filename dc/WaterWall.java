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
You are given an array of non-negative integers that represents a two-dimensional elevation map 
where each element is unit-width wall and the integer is the height. 
Suppose it will rain and all spots between two walls get filled up.

Compute how many units of water remain trapped on the map in O(N) time and O(1) space.

For example, given the input [2, 1, 2], we can hold 1 unit of water in the middle.

Given the input [3, 0, 1, 3, 0, 5], we can hold 3 units in the first index, 2 in the second, and 3 in the fourth index (we cannot hold 5 since it would run off to the left), so we can trap 8 units of water.
 **/
public class WaterWall {

	// IGNORING RESTRICTION
	//
	public static int[] left;
	public static int[] right;
	// TC : O(n) , SC : O(n)
	public int getWater(int[] w) {
		int max = 0;
		int rmax = 0;
		left[0] = 0;
		right[right.length-1]=0;
		for(int i=1; i<w.length; i++) {
			if(w[i-1]>max) {
				//max = left[i];
				max = w[i-1];
				left[i] = w[i-1];
			} else {
				left[i] = max;
			}
		}
		for(int j=w.length-2; j>=0; j--) {
			if(w[j+1]>rmax) {
				//rmax = right[j];
				rmax = w[j+1];
				right[j] = w[j+1];
			} else {
				right[j] = rmax;
			}
		}
		for(int i=0; i<w.length; i++) {
			System.out.println(left[i] + " : " + right[i]);
		}
		for(int i=0; i<w.length; i++) {
			System.out.print(w[i] + " ");
		}
		System.out.println();
		int sum = 0;
		for(int i=1; i<w.length-1; i++) {
			int tmp = Math.min(left[i], right[i]);
			if(tmp>w[i]) sum += tmp-w[i];
		}
		return sum;
	}

	public int getWaterEfficient(int[] w) {
		int max = 0;
        int rmax = 0;
        left[0] = 0;
        right[right.length-1]=0;
        for(int i=1; i<w.length; i++) {
            if(w[i-1]>max) {
                //max = left[i];
                max = w[i-1];
                left[i] = w[i-1];
            } else {
                left[i] = max;
            }
        }
	}

	public static void main(String[] args) {
		int[] w = {3, 0, 1, 3, 0, 5};
		left = new int[w.length];
		right = new int[w.length];
		WaterWall wall = new WaterWall();
		System.out.println(wall.getWater(w));
	}
}
