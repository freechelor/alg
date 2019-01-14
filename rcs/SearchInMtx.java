package alg.rcs;

public class SearchInMtx {

	/**
	 *	elements relation : 
	 *	in the same row, if column index is bigger, the value is bigger
	 *	in the same column, if row index is bigger, the value is bigger
	 *	A00 A01 A02 A03 A04
	 *	A10 A11 A12 A13 A14
	 *	A20 A21 A22 A23 A24
	 *	A30 A31 A32 A33 A34
	 */

	// 1. Search in A00~A34 -> Search in A01~A34 and Search in A10~A34 
	// and (A02~A34 and A11~A34) and (A11~A34 and A20~A34)
	// --> Recursive and DP required
	//
	// 2. try to find in the first row. if it is greater than A0x, keep going.
	// but if it is less than A0x, don't need to go further, because every element in the right column and lower row must be bigger thant A0x
	// --> follow the sequence in a row and a column from the smaller to the bigger and rule out the rest of matrix elements
	// TC : O(n)
	//
	// 3. traverse along with diagonal axis.
	// if the target is bigger than Aii and smaller than A(i+1)(i+1)
	// the target should be existing in the upper right plane or the lower left plane.
	// For example, if tg > A11 and tg < A22, every element in the plane(A00~A11) must be smaller than tg.
	// and every element in the plane(A22~A34) must be bigger than tg by the relation among elements
	// --> follow elements in the diagonal axis and rule out the rest of elements falling into impossibilities
	// --> if it reduces to a single row or single column, just do binary search
	// TC : O(log n)

	//2nd way
	static Pair getPos(int[][] arr, int tg, int rs, int cs, int re, int ce) {
		if(arr==null|| (arr.length==0 && arr[0].length==0)) return null;
		if(rs>re ||cs>ce || ce <0 || re < 0) return null;
		for(int i=cs; i<=ce; i++) {
			if(arr[rs][i] == tg) return new Pair(rs,i);
			else if(arr[rs][i] > tg) { 
				ce = i-1;	
			}
		}
		for(int i=rs; i<=re; i++) {
			if(arr[i][cs] == tg) return new Pair(i,cs);
			else if(arr[i][cs] > tg) { 
				re = i-1;
			}
		}
		return getPos(arr, tg, rs+1, cs+1, re, ce);
	}

	static Pair getPos(int[][] arr, int tg, Pair s, Pair e) {
		if(arr==null||(arr.length==0&&arr[0].length==0)) {
			System.out.println("null 1");
			return null;
		}
		if(isReverse(s,e)) {
			System.out.println("null 2");
			return null;
		}
		Pair mid = getMid(s, e);
		if(arr[mid.r][mid.c]==tg) return new Pair(mid.r, mid.c);
		if(arr[mid.r][mid.c]<tg && mid.r+1 < arr.length && mid.c+1 < arr[0].length && arr[mid.r+1][mid.c+1] > tg) {
			Pair r1 = getPos(arr, tg, new Pair(mid.r+1, s.c), new Pair(e.r, mid.c));
			if(r1 != null) return r1;
			Pair r2 = getPos(arr, tg, new Pair(s.r, mid.c ), new Pair(mid.r, e.c));
			if(r2 != null) return r2;
			System.out.println("null 3");
			return null;
		} else if(arr[mid.r][mid.c]>tg) {
			Pair r1 = getPos(arr, tg, s, new Pair(mid.r-1, e.c));
			if(r1 != null) return r1;
			Pair r2 = getPos(arr, tg, new Pair(mid.r, s.c), new Pair(e.r, mid.c-1));
			if(r2 != null) return r2;
			System.out.println("null 4");
			return null;
		} else {
			Pair r1 = getPos(arr, tg, new Pair(s.r, mid.c+1), new Pair(e.r, e.c));
			if(r1 != null) return r1;
			Pair r2 = getPos(arr, tg, new Pair(mid.r+1, s.c), new Pair(e.r, mid.c));
			if(r2 != null) return r2;
			System.out.println("null 5");
			return null;
		}
	}

	static Pair getMid(Pair a, Pair b) {
		if(Math.abs(a.c-b.c)>Math.abs(a.r-b.r)) {
			return new Pair((a.r+b.r)/2, (a.r+b.r)/2);
		} 
		if(a.c==b.c) {
			return new Pair((a.r+b.r)/2, a.c);
		} else if(a.r==b.r) {
			return new Pair(a.r, (a.c+b.c)/2);
		}
		return new Pair((a.c+b.c)/2, (a.c+b.c)/2);
	}

	static boolean isReverse(Pair a, Pair b) {
		if(a.r>b.r||a.c>b.c) return false;
		return true;
	}

	public static void main(String[] args) {
		int[][] arr = new int[][]
		{{11, 31, 51, 71, 91},
		{16, 36, 56, 76, 96},
		{21, 41, 61, 81, 101},
		{26, 46, 66, 86, 106}};
		for(int[] a : arr) {
			for(int b : a) {
				System.out.print(b + " , " );
			}
			System.out.println();
		}

		Pair p = getPos(arr, 66, 0, 0, 3, 4);
		System.out.println("66 : " + p.r + " , " + p.c);
		p = getPos(arr, 16, 0, 0, 3, 4);
		System.out.println("16 : " + p.r + " , " + p.c);
		p = getPos(arr, 91, 0, 0, 3, 4);
		System.out.println("91 : " + p.r + " , " + p.c);
		p = getPos(arr, 106, 0, 0, 3, 4);
		System.out.println("106 : " + p.r + " , " + p.c);
		
		System.out.println("Binary");
		p = getPos(arr, 66, new Pair(0,0), new Pair(3,4));
		System.out.println("66 : " + p.r + " , " + p.c);
	}
}

class Pair {
	public int r;
	public int c;
	public Pair(int r, int c) {
		this.r = r;
		this.c = c;
	}
}
