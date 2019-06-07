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
package alg.climate;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class FizzBuzz {
	public static void main(String[] args) {
		for(int i=1; i <=100; i++) {
			System.out.print(i + " ::: " );
			if(i%3==0) { 
				System.out.print("Fizz");
			} 
			if(i%5==0) {
				System.out.print("Buzz");
			} 
			if(i%3!=0 && i%5!=0) {
				System.out.print(i);
			}
			System.out.println(" ");
		}
	}
}
