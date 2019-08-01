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
 
  DailyCoding_Q31
@TODO : What if when you change a character to other character every the same character changes?
		That should be not the case.

The edit distance between two strings refers to the minimum number of 
character insertions, deletions, and substitutions required to change one string to the other. 
For example, the edit distance between kitten and sitting is three: substitute the k for s, 
substitute the e for i, and append g.

Given two strings, compute the edit distance between them.

def distance(s1, s2):
    if len(s1) == 0 or len(s2) == 0:
        return max(len(s1), len(s2))

    return min(distance(s1[1:], s2) + 1,
               distance(s1, s2[1:]) + 1,
               distance(s1[1:], s2[1:]) if s1[0] == s2[0] else distance(s1[1:], s2[1:]) + 1)

BY DP
def distance(s1, s2):
    x = len(s1) + 1 # the length of the x-coordinate
    y = len(s2) + 1 # the length of the y-coordinate

    A = [[-1 for i in range(x)] for j in range(y)]
    for i in range(x):
        A[0][i] = i

    for j in range(y):
        A[j][0] = j

    for i in range(1, y):
        for j in range(1, x):
            if s1[j- 1] == s2[i - 1]:
                A[i][j] = A[i - 1][j - 1]
            else:
                A[i][j] = min(
                        A[i - 1][j] + 1,
                        A[i][j - 1] + 1,
                        A[i - 1][j - 1] + 1
                        )
    return A[y - 1][x - 1] # return the edit distance between the two strings
*/
public class EditDistance {
	public static int[][] cache = null;
	public static int aLen = 0;
	public static int bLen = 0;
	public int findDistance(String a, String b) {
		if(a.length()==0||b.length()==0) return Math.max(a.length(), b.length());
		//if(cache[aLen-a.length()][bLen-b.length()]!=-1) return cache[aLen-a.length()][bLen-b.length()];
		if(cache[a.length()][b.length()]!=-1) return cache[a.length()][b.length()];
		else {
			int case1 = findDistance(a, b.substring(1))+1; 
			int case2 = findDistance(a.substring(1), b)+1;
			int case3 = (a.charAt(0)==b.charAt(0))? 
				findDistance(a.substring(1), b.substring(1)): findDistance(a.substring(1), b.substring(1))+1;
			//cache[aLen-a.length()][bLen-b.length()] =  Math.min(Math.min(case1, case2), case3);
			cache[a.length()][b.length()] =  Math.min(Math.min(case1, case2), case3);
			return cache[a.length()][b.length()];
		}
	}

	public static void main(String[] args) {
		EditDistance eD = new EditDistance();
		String a = "kittenworkkitten"; 
		aLen = a.length();
		String b = "sittingrorksitting"; 
		bLen = b.length();
		//cache = new int[a.length()][b.length()];
		cache = new int[a.length()+1][b.length()+1];
		for(int i=0; i<=aLen; i++) {
			Arrays.fill(cache[i],-1);
		}
		System.out.println(eD.findDistance(a,b));
	}
}
