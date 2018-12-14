package alg.math;

import java.util.HashMap;

public class SwapSum {
	static int[] a1 = new int[] {13, 9, 3, 6, 8, 33, 1, 7, 4, 20};
	static int[] a2 = new int[] {1, 2, 3, 5, 7, 12, 15, 29, 16, 4, 34, 8};
	static int start = 0;
	static HashMap<Integer,Integer> map = new HashMap<>();
	static void pourInHash() {
		int[] tmp = null;
		// shorter array will be a1
		if(a1.length>a2.length) {
			tmp = a2;
			a2 = a1;
			a1 = tmp;
		}
		start = a1[0];
		for(int i=0; i < a1.length; i++) {
			map.put(a1[i]-start, i);
		}
	}

	static int getDiff(int[] a1, int[] a2) {
		int sum = 0;
		for(int i : a1) {
			sum += i;
		}
		int sum2 = 0;
		for(int i : a2) {
			sum2 += i;
		}

		return sum2-sum;
	}

	static int idxA1 = -1;
	static int idxA2 = -1;
	static void find(int diff) {
		System.out.println("start : " + start);
		for(int i=0; i<a2.length; i++) {
			if(map.get((diff-2*(a2[i]-start))/2)!=null) {
				idxA2 = i;
				idxA1 = map.get((diff-2*(a2[i]-start))/2);
			}
		}
	}

	public static void main(String args[]) {
		int sum = 0;
		for(int i : a1) {
			sum += i;
		}
		System.out.println(sum);
		sum = 0;
		for(int i : a2) {
			sum += i;
		}
		System.out.println(sum);
		pourInHash();
		int diff = getDiff(a1, a2);
		System.out.println("diff : " + diff);
		find(diff);
		System.out.println("result : " + a1[idxA1] + " , " + a2[idxA2]);
	}
}
