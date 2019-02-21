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
package alg.;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class RSort {
	// A utility function to get maximum value in arr[] 
     static int getMax(int arr[], int n) 
	 { 
		 int mx = arr[0]; 
		 for (int i = 1; i < n; i++) 
			 if (arr[i] > mx) 
				 mx = arr[i]; 
		return mx; 
	} 

    static void countSort(int arr[], int n, int exp) 
		    { 
				        int output[] = new int[n]; // output array 
						        int i; 
								        int count[] = new int[10]; 
										        Arrays.fill(count,0); 
												  
 Store count of occurrences in count[] 
         for (i = 0; i < n; i++) 
                     count[ (arr[i]/exp)%10 ]++; 
                       
                               // Change count[i] so that count[i] now contains 
                                       // actual position of this digit in output[] 
                                               for (i = 1; i < 10; i++) 
                                                           count[i] += count[i - 1]; 
                                                             
                                                                     // Build the output array 
                                                                             for (i = n - 1; i >= 0; i--) 
                                                                                     { 
                                                                                                 output[count[ (arr[i]/exp)%10 ] - 1] = arr[i]; 
                                                                                                             count[ (arr[i]/exp)%10 ]--; 
                                                                                                                     } 
                                                                                                                       
                                                                                                                               
                                                                                                                               // Copy the output array to arr[], so that arr[] now 
                                                                                                                                       // contains sorted numbers according to curent digit 
                                                                                                                                               for (i = 0; i < n; i++) 
                                                                                                                                                           arr[i] = output[i]; 
//                                                                                                                                                               } 

	public static void main(String[] args) {
	}
}
