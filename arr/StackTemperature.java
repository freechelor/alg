package alg.arr;

import java.util.Stack;

public class StackTemperature {
//	static int[] arr = new int[] { 73, 74, 75, 71, 69, 73, 79, 76 };
//	static int[] arr = new int[] { 73, 74, 75, 71, 69, 73, 79, 76, 90, 73, 91, 83, 78, 99, 34, 67};
	static int[] arr = new int[] { 99, 98, 97, 80, 78, 73, 65, 55, 43, 43, 41, 39, 20, 100};
	Stack<Integer> s = new Stack<Integer>();
	static int[] res = new int[arr.length];
	private void nearestWarmer(int[] T) {
		s.push(0);
		for(int i=1; i<T.length; i++) {
			int idx = 0;
			while(!s.isEmpty()&&T[s.peek()]<T[i]) {
				idx = s.pop();
				res[idx] = i-idx;
			} 
			s.push(i);
		}
	}

	public static void main(String args[]) {
		StackTemperature t = new StackTemperature();
		for(int i : arr) {
			System.out.printf("%2d  ", i);	
		}
		System.out.println();
		t.nearestWarmer(arr);
		for(int i : res) {
			System.out.printf("%2d  ", i);	
		}
		System.out.println();
	}
}
