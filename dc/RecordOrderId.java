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
	You run an e-commerce website and want to record the last N order ids in a log. 
	Implement a data structure to accomplish this, with the following API:

	record(order_id): adds the order_id to the log
	get_last(i): gets the ith last element from the log. i is guaranteed to be smaller than or equal to N.
	You should be as efficient with time and space as possible.
 **/
public class RecordOrderId {
	
	public void record(int orderId) {
	}

	public int getLast(int i) {
	}

	public static void main(String[] args) {
		RecordOrderId recorder = new RecordOrderId();
		for(int i = 0; i < N; i++) {
			recorder.record(getLast(i))
		}
	}
}
