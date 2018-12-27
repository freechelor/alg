package alg.etc;

import java.util.ArrayList;
import java.util.Arrays;

public class Queen {
	static ArrayList<boolean[][]> list = new ArrayList<>();
	static ArrayList<boolean[][]> getCombi(boolean[][] map) {
		for(int col=0; col<map[0].length; col++) {
			checkValidation(map, 0, i);
		}
		return list;
	}

	static void checkValidation(boolean[][] map, int row, int col) {
		if(row>=map.length||col>=map[0].length)
		if(map[row][col]) {
			if(row==map.length-1) list.add(map);
			checkValidation(map, row+1, col);
		} else {
			checkValidation(map, row, col+1);
		}
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
		print(init);
		ArrayList<boolean[][]> result = getCombi(init);
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
