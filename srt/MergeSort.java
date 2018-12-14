package alg.srt;

public class MergeSort {
	public void merge(int[] arr, int l, int m, int r) {
		int[] tmp = new int[r-l+1];
		int i = l;
		int j = m+1;
		int idx = 0;
		for(int c=0; c < tmp.length && i<=m && j<=r; c++) {
			while(i<m && arr[i]<arr[j]) {
				tmp[idx] = arr[i];
				idx++; i++;
			}
			while(j<=r && arr[i]>=arr[j]) {
				tmp[idx] = arr[j];
				idx++; j++;
			}
		}
		for(int c=i; c < m; c++) {
			tmp[idx] = arr[c];
			idx++;
		}
		for(int c=0; c < idx; c++) {
			arr[l+c] = tmp[c];
		}
	}

	public void mergeSort(int[] arr, int l, int r) {
		if(l>r) {
			return;
		}
		int m = (l+r)/2;
		mergeSort(arr, l, m);
		mergeSort(arr, m+1, r);
		merge(arr, l, m, r);
	}

	public static void main(String args[]) {
		MergeSort s = new MergeSort();
		int[] arr = new int[] { 10, 30, 15, 1, 9 ,6 ,7, 34, 2, 105, 22};
		s.mergeSort(arr, 0, arr.length-1);
		for(int a: arr) {
			System.out.print(a + " ");
		}
	}
}
