package alg.rcs;

import java.util.List;
import java.util.ArrayList;
public class SearchPath {
	static List<Position> list = new ArrayList<Position>();
	static List<Object> total = new ArrayList<Object>();

	static int[][] map = new int[][] {
		{0, 1, 1, 0, 0, 1, 1, 1 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{1, 1, 1, 1, 1, 0, 1, 0 },
		{1, 0, 0, 0, 0, 0, 1, 0 },
		{1, 1, 0, 0, 0, 0, 1, 0 },
		{0, 0, 1, 0, 1, 0, 1, 0 },
		{0, 0, 0, 0, 0, 0, 1, 0 },
		{0, 0, 0, 0, 0, 0, 0, 0 },
		{1, 0, 0, 1, 1, 0, 1, 0 }
	};

	// TODO : how to solve this problem with BFS approach
	static boolean isValid(int[][] map, int r, int c) {
		if(map == null) return false;
		if(r>=map.length||c>=map[0].length||map[r][c]!=0) return false;
		if(r==map.length-1&&c==map[0].length-1) {
			list.add(new Position(r,c));
			return true;
		}
		list.add(new Position(r,c));
//		if(!isValid(map,r+1,c)&&!isValid(map,r,c+1)) {
//			Position pos = list.get(list.size()-1);
//			map[pos.x][pos.y] = 1;
//			list.remove(list.size()-1);
//			return false;
//		}
		boolean valid = isValid(map, r+1, c)||isValid(map, r, c+1);
		if(!valid) {
			Position pos = list.get(list.size()-1);
			map[pos.x][pos.y] = 1;
			list.remove(list.size()-1);
		}
		return valid;
	}

	public static void main(String args[]) {
		System.out.println(isValid(map, 0, 0));
		for(Position p : list) {
			System.out.println("(" + p.x + ", "+ p.y + ")");
		}
	}
}

class Position {
	public int x;
	public int y;

	public Position(int r, int c) {
		this.x = r;
		this.y = c;
	}
}
