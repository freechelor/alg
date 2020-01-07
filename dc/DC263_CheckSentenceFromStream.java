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
import java.util.Scanner;
/**
DC#263_Medium
 Create a basic sentence checker that takes in a stream of characters 
	and determines whether they form valid sentences. If a sentence is valid, the program should print it out.

    We can consider a sentence valid if it conforms to the following rules:

    The sentence must start with a capital letter, followed by a lowercase letter or a space.
    All other characters must be lowercase letters, separators (,,;,:) or terminal marks (.,?,!).
    There must be a single space between each word.
    The sentence must end with a terminal mark immediately following a word.

 */
public class DC263_CheckSentenceFromStream {
	static int state = 0; // before beginning
	static int started = 1; // uppercase letter
	static int inProgress = 2; // no issues
	static int space = 3; // see a single space
	static int terminated = 4; // see a terminal
	static String stc = "";

	public static void checkSentence(char c) {
		if(state==0&&!isUpper(c)) {
			return;
		}

		if(isUpper(c)) {
			stc += c;
			state = 1;

		} else if(isTerminal(c)&&state==2) {
			System.out.println(stc);
			stc = "";
			state = 0;

		} else if(isLower(c)&&(state==1||state==2||state==3)) {
			stc += c;
			state = 2;

		} else if(c==' ') {
			if(state==1||state==2) {
				stc += " ";
				state = 3;
			} else if(state==3) {
				state = 0;
				stc = "";
			}
		} else {
			stc = "";
			state = 0;
		}
	}

	static boolean isUpper(char c) {
		if(c>='A' && c<='Z') return true;
		return false;
	}

	static boolean isLower(char c) {
		if((c>='a'&&c<='z')||c==','||c==';'||c==':') return true;
		return false;
	}

	static boolean isTerminal(char c) {
		if(c=='.'||c=='?'||c=='!') {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		while(true) {
			Scanner sc = new Scanner(System.in);
			while(sc.hasNext()) {
				String str = sc.nextLine();
				int len = str.length();
				for(int i=0; i<len; i++) {
					checkSentence(str.charAt(i));
				}
			}
			System.out.println();
		}
	}
}
