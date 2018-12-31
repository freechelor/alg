// TO THINK ABOUT : Time/Space Complexity
package alg.rcs;

import java.util.*;
public class Permutation {
	int cnt = 1;
	static Hashtable<Character, Integer> tbl = new Hashtable<Character, Integer>();
	private  void permute(String input, int l, int r) {
		if(l==r) {
			System.out.printf("result[%d] =============[%s] ", cnt++,  input);
		}
		else {
			for(int i = l; i<=r; i++) {
				input = swap(input, l, i);
				System.out.println("input 1: " + input);
				permute(input, l+1, r);
				System.out.println("input interim: " + input);
				input = swap(input, l, i);		
				System.out.println("input 2: " + input);
			}
		}
	}

	private String swap(String str, int i, int j) {

		char[] chars = str.toCharArray();
		char tmp = chars[i];
		chars[i] = chars[j];
		chars[j] = tmp;
		System.out.println("String = " + String.valueOf(chars));
		return String.valueOf(chars);
	}

	private void permute(String pre, String rest, ArrayList<String> result) {
		if(rest.length()==0) {
			result.add(pre);
		} else {
			for(int i = 0; i < rest.length(); i++) {
				permute(pre+rest.charAt(i), rest.substring(0,i)+rest.substring(i+1), result);
			}
		}
		return;
	}

	static private void init(String s) {
		char[] chr = s.toCharArray();
		for(char c : chr) {
			if(tbl.get(c)==null) tbl.put(c,0);
			tbl.put(c, tbl.get(c)+1);
		}				
		Object[] keys = tbl.keySet().toArray();
		for( int i = 0; i < keys.length; i++ ) {
			System.out.println((char)keys[i] + " , " + tbl.get((char)keys[i]));
		}
	}

	private void permuteDup(String pre, int len, ArrayList<String> result) {
		if(pre.length()==len) {
			result.add(pre);
		} else {
			Object[] keys = tbl.keySet().toArray();
			// TO THINK ABOUT : when picking one of duplicte elements in string, this will prevent you from selecting the same element in the same position
			// because you have to be able to choose just one of keys in the hashtable
			for(int i = 0; i < keys.length; i++ ) {
				keys = tbl.keySet().toArray();
				Character c = (Character)keys[i];
				int cnt = tbl.get(c)==null? 0 : (int)tbl.get(c);
				if(cnt>0) {
					tbl.put(c, cnt-1);
					permuteDup(pre+c, len, result);
					tbl.put(c, cnt);
				} 
			}
		}
		return;
	}


	//1221
	private void revisitPermDups(String pre, int len, ArrayList<String> result) {
		if(pre.length()==len) {
			result.add(pre);
			// NEED return? why don't need return?
		} else {
			Object[] keys = tbl.keySet().toArray();
			for(int i = 0; i < keys.length; i++) {
				Character c = (Character)keys[i];	
				int cnt = tbl.get(c)==null? 0 : (int)tbl.get(c);
				if(cnt > 0) {
					tbl.put(c, cnt-1);
					revisitPermDups(pre+c, len, result);
					tbl.put(c, cnt);
				}
			}
		}
	}

	public static void main(String args[]) {
		Permutation p = new Permutation();
//		p.permute(args[0], 0, args[0].length()-1);
		init(args[0]);
		ArrayList<String> hdr = new ArrayList<String>();
		p.permute("", args[0], hdr);
		System.out.println("result size : " + hdr.size());
		for(String str : hdr) {
			System.out.print(str + " ,");
		}
		System.out.println();
		ArrayList<String> hdr2 = new ArrayList<String>();
		p.permuteDup("", args[0].length(), hdr2);
		System.out.println("result size : " + hdr2.size());
		for(String str : hdr2) {
			System.out.print(str + " ,");
		}
	}
}
