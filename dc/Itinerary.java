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

public class Itinerary {
	public String getPath(String s, Path[] p) {
	}

	public static void main(String[] args) {
//HNL -> AKL
//YUL -> ORD
//ORD -> SFO
//SFO -> HNL
		Path[] p = {new Path("HNL", "AKL"), new Path("YUL", "ORD"), new Path("ORD", "SFO"), new Path("SFO", "HNL")};	
		Itinerary i = new Itinerary();

	}
}

class Path {
	public String org;
	public String des;

	public Path(String o, String d) {
		this.org = o;
		this.des = d;
	}
}
