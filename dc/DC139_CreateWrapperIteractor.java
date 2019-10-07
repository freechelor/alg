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
This problem was asked by Google.

Given an iterator with methods next() and hasNext(), create a wrapper iterator, PeekableInterface, which also implements peek(). peek shows the next element that would be returned on next().

Here is the interface:

class PeekableInterface(object):
    def __init__(self, iterator):
        pass

    def peek(self):
        pass

    def next(self):
        pass

    def hasNext(self):
        pass

We will be sending the solution tomorrow, along with tomorrow's 
**/
public class DC139_CreateWrapperIterator {
	static Iterator iter = null;

	public static void init(Iterator itr) {
		this.iter = itr;
	}

	public Object peek() {
		this.iter.
	}

	public Object next() {
		return this.iter.next();
	}

	public boolean hasNext() {
		if(this.iter.next()!=null) {
			return true;
		}
		return false;
	}

	public static void main(String[] args) {
			
	}
}
