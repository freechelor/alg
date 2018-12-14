package alg.bit;

import java.util.HashMap;
import java.util.Set;

public class FlipBit {
	static HashMap<Integer, Integer> map = new HashMap<>();
	static int max = Integer.MIN_VALUE;
	public int reversebit(int n) {
		int rev = 0;
		while(n>0) {
			rev <<= 1;
			if((n&1)==1) {
				rev += 1;
			}
			n >>= 1;
		}
		return rev;
	}
	public void index1s(int a) {
		System.out.println(Integer.toBinaryString(a));
		int previous = -1;
		int idx = 0;
		int keepgoIdx = 0;
		for(int i=a; i>0; i>>>=1) {
			System.out.println(i);
			if((i&1)==1) {
				if(previous==-1) {
					if(max < 1) max = 1;
					idx = keepgoIdx;
					map.put(idx,1);
					previous = 0;
				} else {
					int tmp = map.get(idx)+1;
					if(max<tmp) { 
						max = tmp;
					}
					map.put(idx, tmp);
				}
			} else {
				previous = -1;
			}
			keepgoIdx++;
		}		
		max++;
	}

	public void mergeLen() {
		// get max len from values of HashMap before merging
		Set<Integer> set = map.keySet();
		for(int k : set) {
			int l = map.get(k);
			if(map.get(k+l+1)!=null) {
				int len = l + map.get(k+l+1)+1;
				if(max<len) max = len;
			}
		}
	}

	public static void main(String args[]) {
		String bit = "10001001001001001001";
		int b = Integer.parseInt(bit,2);
		int a = 4452;
		FlipBit fBit = new FlipBit();
		System.out.println(Integer.toBinaryString(a));
		System.out.println("b : " + bit);
		fBit.index1s(b);
		Set<Integer> set = map.keySet();
		for(int k : set) {
			System.out.println("idx : " + k + " , len :" + map.get(k));
		}
		fBit.mergeLen();
		System.out.println(max);
	}
}
