package alg.rcs;

public class MagicIdx {

	public static int getMgIdx(int[] arr,int s, int e) {
		if(s>e) return -1;
		int mid = (s+e)/2;
		/*
		if(mid==arr[mid]) {
			return mid;
		} else if(mid < arr[mid]) {
			return getMgIdx(arr, s, mid-1);	
		} else {
			return getMgIdx(arr, mid+1, e);
		}
		*/
		if(mid==arr[mid]) {
			return mid;
		} else {
			int left = getMgIdx(arr, s, mid-1);	
			int right = getMgIdx(arr, mid+1, e);
			if(left!=-1) return left;
			if(right!=-1) return right;
			return -1;
		}
	}

	public static void main(String args[]) {
							// 0, 1,  2,  3, 4, 5, 6, 7, 8
		int[] a = new int[] { -7, -5, -3, 1, 2, 5, 7, 9, 10 };
		int[] b = new int[] { -7, -5, -3, 1, 7, 7, 7, 7, 10 };
		System.out.println(MagicIdx.getMgIdx(a, 0, a.length-1));
		System.out.println(MagicIdx.getMgIdx(b, 0, b.length-1));
	}
}
