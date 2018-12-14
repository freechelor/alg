package alg.mtx;

import java.util.HashMap;

public class ZeroMatrix {
	HashMap<Integer, Integer> mapR = new HashMap<>();
	HashMap<Integer, Integer> mapC = new HashMap<>();
	public void reset(int[][] m) {
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++ ) {
				if(m[i][j] == 0 ) {
					mapR.put(i, 1);	
					mapC.put(j, 1);
				}
			}
		}
		for(int i = 0; i < m.length; i++) {
			for(int j = 0; j < m[0].length; j++ ) {
				if((mapR.get(i)!=null && mapR.get(i)==1 )|| (mapC.get(j)!=null && mapC.get(j)==1)) {
					m[i][j] = 0;
				}
			}
		}
	}
	public static void main(String args[]) {
		ZeroMatrix z = new ZeroMatrix();
		int[][] arr = new int[][] { {1,2,3,4}, {5,6,0,8}, {0,10,11,12}, { 13, 14, 15, 16}};
		z.reset(arr);
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[0].length; j++ ) {
				System.out.print(arr[i][j] + " ");
			}
		}
	}
}
