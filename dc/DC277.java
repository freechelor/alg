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
This problem was asked by Google.

UTF-8 is a character encoding that maps each symbol to one, two, three, or four bytes.

For example, the Euro sign, E, corresponds to the three bytes 11100010 10000010 10101100. 
The rules for mapping characters are as follows:

    For a single-byte character, the first bit must be zero.
    For an n-byte character, the first byte starts with n ones and a zero. The other n - 1 bytes all start with 10.

Visually, this can be represented as follows.

 Bytes   |           Byte format
-----------------------------------------------
   1     | 0xxxxxxx
   2     | 110xxxxx 10xxxxxx
   3     | 1110xxxx 10xxxxxx 10xxxxxx
   4     | 11110xxx 10xxxxxx 10xxxxxx 10xxxxxx

Write a program that takes in an array of integers representing byte values, 
and returns whether it is a valid UTF-8 encoding.
*/
public class DC277 {
	public static boolean isValid(int[] arr) {
		if(arr==null||arr.length==0) return true;
		int remBytes = arr[0];
		int cnt = 0;
		int a = 0b10000000;
		int b = 0b10111111;
		while((remBytes&a)!=0) {
			cnt++;
			remBytes<<=1;
		}
		if(cnt==0) {
			if(arr.length==1) return true;
			else return false;
		}
		if(cnt>4) return false;
		if(cnt-1!=arr.length-1) return false;
		for(int i=1; i<arr.length; i++) {
			if((b&arr[i])!=arr[i]) return false;
		}
		return true;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {0b11110101};
		int[] arr2 = new int[] {0b11011100, 0b11111010};
		int[] arr3 = new int[] {0b11101100, 0b10101010, 0b10001100};
		int[] arr4 = new int[] {0b11110100, 0b10101010, 0b10001100, 0b10110110};
		int[] arr5 = new int[] {0b11111100, 0b10101010, 0b10001100, 0b10110110};
		System.out.println(isValid(arr));
		System.out.println(isValid(arr2));
		System.out.println(isValid(arr3));
		System.out.println(isValid(arr4));
		System.out.println(isValid(arr5));
	}
}
