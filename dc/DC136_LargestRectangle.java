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
This question was asked by Google.

Given an N by M matrix consisting only of 1's and 0's, 
find the largest rectangle containing only 1's and return its area.

For example, given the following matrix:

[[1, 0, 0, 0],
 [1, 0, 1, 1],
 [1, 0, 1, 1],
 [0, 1, 0, 0]]

Return 4.

This is solution code
===========================================================
public infer_area(cache):
    max_area = 0
    for i in range(len(cache)):
        for j in range(i + 1, len(cache) + 1):
            current_rectangle = min(cache[i:j]) * (j - i)
            max_area = max(max_area, current_rectangle)
    return max_area


def largest_rectangle(matrix):
    n, m = len(matrix), len(matrix[0])
    max_so_far = 0

    cache = [0 for _ in range(m)]
    for row in matrix:
        for i, val in enumerate(row):
            if val == 0:
                cache[i] = 0
            elif val == 1:
                cache[i] += 1
        max_so_far = max(max_so_far, infer_area(cache))
	return max_so_far
===========================================================
getMax : TC : O(N*M^2)
getLargestBySolution : TC : O(N)
Total TC : O((NM)^2), SC : O(M)

*/

public	class DC136_LargestRectangle {
	static int[][] matrix = {
		{1,0,0,0,1,0,0,0,0}, 
		{1,0,1,1,1,1,0,0,1}, 
		{1,0,1,1,0,1,0,0,1}, 
		{1,1,1,1,1,1,1,1,1}, 
		{1,0,1,1,0,1,0,0,1}, 
		{0,1,1,1,1,1,0,0,1}};
	static int max = 0;
	static int consecutive = 0;
	static int rowMin = Integer.MAX_VALUE;

	// this gives Wrong Answer : my solution
	public static void getLargest(int[][] mtx) {
		int[] r = new int[mtx[0].length];
		for(int j=0; j<mtx[0].length; j++) {
			r[j] = mtx[0][j];
			if(max<r[j]) max = r[j];
		}
		for(int i=1; i<mtx.length; i++) {
			rowMin = Integer.MAX_VALUE;
			consecutive = 0;
			for(int j=0; j<mtx[0].length; j++) {
				if(mtx[i][j]!=0) {
					r[j] = r[j] + mtx[i][j];
					if(r[j]>max) max = r[j];
					consecutive++;
					if(rowMin>r[j]) rowMin = r[j];
					if(max <rowMin * consecutive) max = rowMin * consecutive;
				} else if(mtx[i][j]==0) {
					r[j] = 0;
					consecutive = 0;
					rowMin = Integer.MAX_VALUE;
				}
			}
		}
	}

	static int localMax = Integer.MIN_VALUE;
	static int cacheMin = Integer.MAX_VALUE;
	public static int getMax(int[] cache) {
		for(int i=0; i<cache.length; i++) {
			for(int j=i; j<cache.length; j++) {
				cacheMin = Integer.MAX_VALUE;
				for(int k=i; k<=j; k++) {
					if(cacheMin>cache[k]) cacheMin = cache[k];
				}
				if(localMax<cacheMin*(j-i+1)) {
					localMax = cacheMin*(j-i+1);
				}
			}
		}
		return localMax;
	}

	public static void getLargestBySolution(int[][] mtx) {
		int[] cache = new int[mtx[0].length];
		for(int i=0; i<mtx.length; i++) {
			for(int j=0; j<mtx[0].length; j++) {
				if(mtx[i][j]==0) cache[j] = 0;
				else if(mtx[i][j]==1) cache[j] = cache[j]+1;
			}
			max = Math.max(max, getMax(cache));
		}
	}

	public static void main(String[] args) {
		max = 0;
		getLargest(matrix);
		System.out.println(max);	
		max = 0;
		getLargestBySolution(matrix);
		System.out.println(max);	
	}
}
