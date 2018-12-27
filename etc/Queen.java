package alg.etc;

import java.util.ArrayList;
import java.util.Arrays;

public class Queen {
	static ArrayList<boolean[][]> list = new ArrayList<>();
	static ArrayList<boolean[][]> getComb(boolean[][] map) {
		for(int col=0; col<1; col++) {
		// select a point for a queen in current row
			for(boolean[] b : map) {
				Arrays.fill(b, true);
			}
			if(map[0][col]) {
				checkValidation(map, 0, col);	
				list.add(map);
			}
		}
		return list;
	}

	static void checkValidation(boolean[][] map, int row, int col) {
		// set false to all elements in the same row, column, and diagonal except element at [row][col]	
		if(row>=map.length||col>=map[0].length) return;
		if(!map[row][col]) checkValidation(map, row, col+1);
		for(int i=0; i<map[0].length; i++) {
			if(i!=col) map[row][i] = false;
		}	
		for(int j=0; j<map.length; j++) {
			if(j!=row) map[j][col] = false;
		}
		for(int i=0; i<map.length; i++) {
			for(int j=0; j<map[0].length; j++) {
				if(row==i&&col==j) continue;
				if(Math.abs(row-i)==Math.abs(col-j)) map[i][j]=false;
			}
		}
		checkValidation(map, row+1, col);
	}

	static void print(boolean[][] p) {
			for(int y = 0; y < p.length; y++) {
				for(int x = 0; x <p[0].length; x++) {
					System.out.print(p[y][x]? "T" + "  ": "F" + "  ");
				}
				System.out.println();
			}
	}
	public static void main(String args[]) {
		boolean[][] init = new boolean[8][8];
		for(boolean[] b : init) {
			Arrays.fill(b, true);
		}
		ArrayList<boolean[][]> result = getComb(init);
		System.out.println(result.size());
		for(boolean[][] r : result) {
			for(int y = 0; y < r.length; y++) {
				for(int x = 0; x <r[0].length; x++) {
					System.out.print(r[y][x]? "T" + "  ": "F" + "  ");
				}
				System.out.println();
			}
		System.out.println();
		}
		System.out.println();
		System.out.println();
	}
}
