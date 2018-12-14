package alg.arr;

public class Temperature {
	//static int[] arr = new int[] { 73, 74, 75, 71, 69, 73, 79, 76};
	//static int[] arr = new int[] { 73, 74, 75, 71, 69, 73, 79, 76, 90, 73, 91, 83, 78, 99, 34, 67};
	static int[] arr = new int[] { 99, 98, 97, 80, 78, 73, 65, 55, 43, 43, 41, 39, 20, 100};
	boolean find = false;
	int days = 0;

	private void nearestWarmer(int[] T) {
		for(int i = 0; i < T.length; i++) {
			for(int j = i+1; j < T.length; j++) {
				if(T[i]<T[j]) {
					days = j-i;
					find = true;
					break;
				}
			}
			if(find) {
				System.out.printf("%2d  ",days); // + "  ");
				find = false;
			} else {
				System.out.printf("%2d  ", 0);
			}
		}
	}

	public static void main(String args[]) {
		Temperature t = new Temperature();
		for(int i : arr) {
			System.out.print(i + "  ");	
		}
		System.out.println();
		t.nearestWarmer(arr);
		System.out.println();
	}
}
