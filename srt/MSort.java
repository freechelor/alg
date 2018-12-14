package alg.srt;

public class MSort {
	public static void merge(int[] a, int l, int m, int r) {
		int[] subL = new int[m-l+1];
		int[] subR = new int[r-m];
		// copy data to temporary array
		for(int i = 0; i < m-l+1; i++) {
			subL[i] = a[l+i];
		}
		for(int i = 0; i < r-m; i++) {
			subR[i] = a[m+1+i];
		}
	
		int i = 0;
		int j = 0;
		int k = l;
		while( i<subL.length && j<subR.length) {
			if(subL[i]<subR[j]) {
				a[k] = subL[i];
				i++;
			} else {
				a[k] = subR[j];
				j++;
			}
			k++;
		}
																																																																						
		// all of the rest of either of arrays should be poured into the merged array
		while(i<subL.length) {
			a[k++] = subL[i++];
		}

		while(j<subR.length) {
			a[k++] = subR[j++];
		}
	}

	public static void mergesort(int[] a, int l, int r) {
		System.out.println("=======> " + l + " : " + r);
		if(l>=r) return;
		int m = (l+r)/2;
		mergesort(a, l, m);
		mergesort(a, m+1, r);
		merge(a, l, m, r);
		/* infinit loop WHY????????????
		mergesort(a, l, m-1);
		mergesort(a, m, r);
		merge(a, l, m-1, r);
		*/
	}

	public static void main(String args[]) {
		int[] arr = new int[] { 66, 1314, 12, 643, 34,8,64865,2341,3,51,1,67,78,24,
		23,64,457,34512,642,647,4246,246,451,3,756,867,4,2, 867,9,43,8,5,62,35,378453,623,743, 63, 1245, 436,3994,34,12,856,7,95675,47,835,564,78,6458,456,57,
		723,8,6,9,42,8,3,6,8,9,346,45,74,346,8,586,5643,68,98,57,967,9,68,436,423,79,6,7,56,2438,9,6,34,4,7,5469,64,6,563,7,8,45,6,34,7,57,34,6,
		4136,436,632,4,56,77776,97,9,90,7,88,9,8,4567,645,85,6,4,4658,3,64,7,56,45,8456,7,567,48,4,64,8,456,856,6,4,9,945,63,5,458,567,90,780,3568,24};
		long t1 = System.currentTimeMillis();
		mergesort(arr, 0, arr.length-1);
		System.out.println((System.currentTimeMillis()-t1));
		for( int a : arr) {
			System.out.println(a + " ");
		}
		System.out.println();
	}
}

