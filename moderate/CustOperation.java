package alg.moderate;

import java.util.Scanner;

public class CustOperation {
	public int multiply(int a, int b) {
		if(a<b) {
			int tmp = a;
			a = b;
			b = tmp;
		}
		int res = 0;
		for(int i = 0; i <b; i++) {
			res += a;
		}
		return res;
	}

	public int devide(int a, int b) {
		int res = a;
		int quotient = 0;
		int remainder = 0;
		while(res>b) {
			res -= b;
			quotient++;
		}
		return quotient;
	}

	public static void main(String args[]) {
		CustOperation cOp = new CustOperation();
		Scanner sc = new Scanner(System.in);
		while(true) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(cOp.multiply(a,b));
			System.out.println(cOp.devide(a,b));
		}
	}
}
