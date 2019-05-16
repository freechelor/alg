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

public class RunLen {

	public String enc(String s) {
		if(s==null|s.length()==0) return null;
		String res = "";
		String c = "";
		int cnt = 0;
		for(int i=0; i<s.length(); i++) {
			String tmp = s.charAt(i)+"";
			if(c.equals("")) { 
				c=tmp;
				cnt++;
				continue;
			}
			if(c.equals(tmp)) {
				cnt++;
			} else {
				res += cnt+tmp;
			}
			if(i==s.length()-1) {
				res +=
			}
		}

		return res;
	}

	public String dec(String s) {
		String res = "";
		for(int i=0; i<s.length(); i=i+2) {
			int c = s.charAt(i)-'0';
			String s2 = s.charAt(i+1)+"";
			for(int j=0; j<c; j++) {
				res += s2;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		String inenc = "aabbccssrrrrrqprtff";
		String indec = "4t5r1q2e";
		RunLen r = new RunLen();
		System.out.println(indec + ":"+ r.dec(indec));
	}
}
