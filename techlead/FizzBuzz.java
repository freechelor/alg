package alg.techlead;

public class FizzBuzz {
	public static void printFizzBuzz(int n) {
		int i=1;
		while(i<n) {
			System.out.print(i + " ===> "  );
			if(i%3==0&&i%5==0) {
				System.out.print("FizzBuzz");
			} else if(i%3==0) {
				System.out.print("Fizz");
			} else if(i%5==0) {
				System.out.print("Buzz");
			} else System.out.print(i);
			System.out.println();
			i++;
		}
	}

	public static void main(String args[]) {
		printFizzBuzz(100);
	}
}

