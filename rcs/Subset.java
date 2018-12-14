package alg.rcs;

public class Subset {
	static int count = 0;

	public static void getSubsets(int[] arr, int idx, String r) {
		if(arr.length<=idx) {
			System.out.println(count++ + ": " +  r.toString());
			return;
		}
		getSubsets(arr, idx+1, r+","+arr[idx]);
		getSubsets(arr, idx+1, r);
	}
	public static void main(String args[]) {
		int[] a = new int[] { 1, 3, 5, 2, 4, 6, 8};
		getSubsets(a, 0, "");
		System.out.println("=======END============");
	}
}
