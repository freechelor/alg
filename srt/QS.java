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
package alg.srt;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;
import java.util.Scanner;

public class QS {
	public static void qsort(Integer[] arr, int s, int e) {
		int p = e;
		qsort(p, arr, s, e);
	}

	public static void qsort(int p, Integer[] arr, int s, int e) {
		if(s>e) return;
		int norm = s;
		for(int i = s; i < e; i++ ) {
			if(arr[p]>arr[i]) {
				int tmp = arr[i];
				arr[i] = arr[norm];
				arr[norm] = tmp;
				norm++;	
			} else {
			}
		}
		int tmp = arr[e];
		arr[e] = arr[norm];
		arr[norm] = tmp;
		qsort( norm-1, arr, s, norm-1);
		qsort( e, arr, norm+1, e);
	}

	public static void main(String[] args) {
		System.out.println("[count] [elements...]");
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<Integer>();
		int cnt = sc.nextInt();
		while(cnt-->0) {
			list.add(sc.nextInt());
		}
		Integer[] arr = new Integer[list.size()];
		list.toArray(arr);
		for(int a : arr) System.out.print(a + " ");
		System.out.println();
		qsort(arr, 0, arr.length-1);
		for(int a : arr) System.out.print(a + " ");
		System.out.println();
	}
}
