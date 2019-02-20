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

public class QSort {
	public static int selectPivot(Integer[] arr, int s, int e) {
		int p = (s+e)/2;
		//int p = e;
		return p;
	}

	// 1. rightmost pivot
	// Big O
	// TC : 
	// worst : O(n2) - sorted, invert sorted
	// avg : O(nlogn)
	// SC :
	// TODO : figure out answer is O(n), O(1) is wrong
	public static void qSort(Integer[] arr, int s, int e) {
		int p;
		if(s<e) p = selectPivot(arr, s, e);
		else return;
		int start = s;
		int idx = s;
		while(s<e) {
			if(arr[s] > arr[p] ) {
				//idx = s;
			} else {
				int tmp = arr[s];
				arr[s] = arr[idx];
				arr[idx] = tmp;	
				idx++;
			}
			s++;
		}
		int tmp = arr[e];
		arr[e] = arr[idx];
		arr[idx] = tmp;	
		qSort(arr, start, idx-1);
		qSort(arr, idx+1, e);
	}

	// 2. middle pivot
	public static void qSortByMiddle(int mode, Integer[] arr, int s, int e) {
		System.out.println("called parameters = " + s + " , " + e);
		if(arr==null|| arr.length==0) return;
		int p;
		if(s<e) p = selectPivot(arr, s ,e);
		else return;

		int i = s;
		int j = e;
		/*
		 * TODO : this code looks very similar to the working code below except the locations of equals symbols,
		 * 			however it doesn't work
		 * 			*/
		if(mode==1) {
			System.out.println("Mode1, pivot = " + p);
			/*
			//2nd round - 1st set
			//s=0, e=2
			7, 9, 1 i=0, j=2, p=9 at 1
			7, 9, 1 i=1, j=2, swap
			7, 1, 9 i=2, j=1
			
			//s=0, e=1
			7,1 i=0, j=1, p=7 at 0, swap
			1,7 
			*/

			while(i<j) {
				System.out.println("1");
				System.out.println("i="+i + " , p = " + p);
				while(arr[i]<arr[p]) {
					i++;
				}
				System.out.println("2");
				System.out.println("j="+j + " , p = " + p);
				System.out.println("j="+arr[j]);
				System.out.println("p="+arr[p]);
				while(arr[j]>=arr[p]) {
					j--;
				}
				System.out.println("3");
				//swap
				if(i<j) {
				System.out.println("4");
					int tmp = arr[j];
				System.out.println("1");
					arr[j] = arr[i];
				System.out.println("2");
					arr[i] = tmp;
					i++;
					j--;
				}
			}

			System.out.println("interim result");
			for(int a: arr) {
				System.out.print(a + " ");
			}
			System.out.println();
			if(s<j)
				qSortByMiddle(mode, arr, s, j);
			if(i<e)
				qSortByMiddle(mode, arr, i, e);
		} else {
		
			while(i<=j) {
				while(arr[i]<arr[p]) {
					i++;
				}
				while(arr[j]>arr[p]) {
					j--;
				}
				//swap
				if(i<=j) {
					int tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
					i++;
					j--;
				}
			}

			if(s<j)
				qSortByMiddle(mode, arr, s, j);
			if(i<e)
				qSortByMiddle(mode, arr, i, e);
		}
	}

	public static void print(Integer[] arr) {
		for(int a: arr) {
			System.out.print(a + " ");
		}	
		System.out.println();
	}

	public static void main(String[] args) {
		Integer[] arr = new Integer[] {10, 25, 30, 1, 9, 51, 7, 109, 62, 23 };
		/*
		//1st round
		10, 25, 30, 1, 9, 51, 7, 109, 62, 23 i=0, j=9, p=9 at 4
		10, 25, 30, 1, 9, 51, 7, 109, 62, 23 i=0, j=6, swap 
		7, 25, 30, 1, 9, 51, 10, 109, 62, 23 i=1, j=4, swap 
		7, 1, 30, 25, 9, 51, 10, 109, 62, 23 i=2, j=2, swap

		//2nd round - 1st set
		7, 9, 1 i=0, j=2, p=9 at 1
		7, 9, 1 i=1, j=1, swap
		7, 9, 1 i=2, j=0

		30, 25, 51, 10, 109, 62, 23



		*/
		//qSort(arr, 0, arr.length-1);
		qSortByMiddle(1, arr, 0, arr.length-1);
		print(arr);
	}
}
