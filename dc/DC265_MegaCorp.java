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
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

/**
 * DC#265_Easy
 * refer to DC#256
This problem was asked by Atlassian.

MegaCorp wants to give bonuses to its employees based on how many lines of codes they have written. 
They would like to give the smallest positive amount to each worker consistent with the constraint that 
if a developer has written more lines of code than their neighbor, they should receive more money.

Given an array representing a line of seats of employees at MegaCorp, determine how much each one should get paid.

For example, given [10, 40, 200, 1000, 60, 30], you should return [1, 2, 3, 4, 2, 1].
 */
/**
 * TC : O(n)
 * SC : O(1)
 */
public class DC265_MegaCorp {
	// this is a Wrong answer
	public static Integer[] giveBonuses(Integer[] lines) {
		if(lines==null|lines.length==0) return new Integer[0];
		int min = Integer.MAX_VALUE;
		Integer[] res = new Integer[lines.length];
		res[0] = 1;
		for(int i=0; i<res.length-1; i++) {
			if(lines[i]<lines[i+1]) {
				res[i+1] = res[i]+1;
			} else if(lines[i]==lines[i+1]) {
				res[i+1] = res[i];
			} else {
				if(res[i]<=1) {
					res[i+1] = res[i]-1;
					if(min>res[i+1]) min = res[i+1];
				} else {
					res[i+1] = 1;
				}
			}
		}
		if(min<1) {
			for(int i=0; i<res.length; i++) {
				res[i] += (1-min);
			}
		}
		return res;
	} 

	// if a current element is bigger than previous element, simply increase bonus by 1.
	// if a current element is smaller than previous element, 
	// 		if mark index is -1, set mark index as previous index and set bonus to 1 for a current employee
	// 		if already mark index is there, keep moving to next one until it sees a increase
	// 		when it sees a increase, increase element at the mark index to a value which makes current value 1.
	public static Integer[] giveBonusesV2(Integer[] lines) {
		if(lines==null|lines.length==0) return new Integer[0];
		int markIdx = -1;
		Integer[] res = new Integer[lines.length];
		res[0] = 1;
		for(int i=0; i<res.length-1; i++) {
			if(lines[i]<lines[i+1]) {
				if(markIdx==-1) res[i+1] = res[i]+1;
				else {
					for(int j=markIdx; j<=i; j++) {
						if(j==markIdx) {
							res[j] = Math.max((i-j)+1, res[j]);
						} else res[j] = (i-j)+1;
					}
					res[i+1] = 2;
					markIdx = -1;
				}
			} else if(lines[i].equals(lines[i+1])) {		// TODO : HAVE TO BE Careful. when you compare Integer
				System.out.println(i+"th : " + lines[i]);
				if(markIdx!=-1) {
					for(int j=markIdx; j<=i; j++) {
						if(j==markIdx) {
							res[j] = Math.max((i-j)+1, res[j]);
						} else res[j] = (i-j)+1;
					}
					markIdx = -1;
				}
				res[i+1] = res[i];
			} else {
				if(markIdx==-1) {
					markIdx = i;
					res[i+1] = 1;
				} else if(i==res.length-2) {
					for(int j=markIdx; j<=i+1; j++) {
						if(j==markIdx) {
							res[j] = Math.max((i-j)+2, res[j]);
						} else res[j] = (i-j)+2;
					}
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Integer[] lines = new Integer[] {10, 40, 200, 1000, 60, 30, 30};
		Integer[] lines2 = new Integer[] {10, 40, 200, 1000, 60, 30, 50, 70};
		Integer[] lines3 = new Integer[] {10, 40, 200, 1000, 60, 30, 50, 70, 10};
		Integer[] lines4 = new Integer[] {10, 40, 200, 1000, 60, 30, 30};
		Integer[] lines5 = new Integer[] {10, 40, 200, 1000, 60, 30, 20, 10};
		Integer[] lines6 = new Integer[] {10000, 10, 40, 200, 1000, 60, 30, 30};
		Integer[] lines7 = new Integer[] {10, 40, 200, 200, 1000, 60, 30, 10, 40, 20, 30, 50, 1};
		Integer[] res = giveBonuses(lines);
		for(int b:res) {
			System.out.print(b+",");
		}
		System.out.println();
		List<Integer[]> list = new ArrayList<>();
		list.add(lines);
		list.add(lines2);
		list.add(lines3);
		list.add(lines4);
		list.add(lines5);
		list.add(lines6);
		list.add(lines7);
		for(Integer[] iArr:list) {
			Arrays.stream(iArr).forEach(x->System.out.print(x+","));
			System.out.println();
			res = giveBonusesV2(iArr);
			for(int b:res) {
				System.out.print(b+",");
			}
			System.out.println();
		}
	}
}
