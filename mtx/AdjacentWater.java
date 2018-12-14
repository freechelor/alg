package alg.mtx;

public class AdjacentWater {
	static int getMaxWaters(int[][] map) {
		int MAX = Integer.MIN_VALUE;
		for(int r = 0; r < map.length; r++) {
			for(int c = 0; c < map[r].length; c++) {
				if(map[r][c]==0) {
					System.out.println("it's water");
					int size = getSize(map, r, c);
					if(size>MAX) MAX = size;
				}
			}
		}
		return MAX;
	}

	static int getSize(int[][] map, int r, int c) {
		if(r<0||c<0||r>=map.length||c>=map[0].length||map[r][c]!=0) return 0;
		map[r][c] = -1;	// visited
		int size = 1;
		for(int dr = -1; dr <=1; dr++) {
			for(int dc = -1; dc <=1; dc++) {
				size += getSize(map, r+dr, c+dc);
			}
		}
		return size;
	}

	static int[][] map = new int[][] {
		{1, 1, 1, 0, 0, 1, 1, 1 },
		{1, 1, 0, 0, 0, 0, 0, 1 },
		{1, 1, 1, 0, 0, 0, 1, 1 },
		{1, 1, 1, 1, 1, 1, 0, 1 },
		{1, 1, 1, 1, 1, 1, 1, 1 },
		{0, 0, 1, 1, 1, 1, 1, 0 },
		{0, 0, 0, 0, 0, 1, 1, 1 },
		{0, 1, 1, 1, 0, 1, 1, 1 },
		{1, 1, 1, 1, 1, 0, 0, 0 }
	};

	public static void main(String args[]) {
		System.out.println(getMaxWaters(map));
	}
}
