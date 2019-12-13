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
package alg.category;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.Stack;
import java.util.Queue;

public class PartitionPalindrome {
// from solution or discussion
    public List<List<String>> partition(String s) {
        int len = s.length();
        List<List<String>> dp[] = new List[len + 1];
        dp[0] = Arrays.asList(Collections.emptyList());
        boolean b[] = new boolean[len];
        for (int l = 1; l <= len; l++) {
            int i = l - 1;
            dp[l] = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                b[j] = j == i || (j + 1 == i || b[j + 1]) && s.charAt(j) == s.charAt(i);
                if (b[j]) {
                    for (List<String> prefix : dp[j]) {
                        List<String> cur = new ArrayList<>(prefix);
                        cur.add(s.substring(j, i + 1));
                        dp[l].add(cur);
                    }
                }
            }
        }
        return dp[len];
    }

/*
	public boolean getPalindromeSet(String s, List<String> cur, List<String> res) {
		if(s==null||s.length()==0) return true;
		if(isPalindrome(s)) return true;
		for(int i=1, i<s.length()-1; i++) {
			if(isPalindrome(s.substring(0,i)) ) {
				cur.add(s.substring(0,i));
				if(isPalindrome(s.substring(i)) {
					cur.add(s.substring(i));
					res.add(cur);
				} else {
					getPalindromeSet(s.substring(i), cur, res);
				}
			}	
		}
	}

	private boolean isPalindrome(String s) {
		int i=0;
		int j=s.length()-1;
		while(i<j) {
			if(s.charAt(i)!=s.charAt(j)) return false;
			i++;
			j--;
		}
		return true;
	}
*/

	public static void main(String[] args) {
	}
}
