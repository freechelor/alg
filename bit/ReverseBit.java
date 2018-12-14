package alg.bit;

public class ReverseBit {
	public static int reversebit(int n) {
		int rev = 0;
		while(n>0) {
			rev <<= 1;
			if((n&1)==1) {
				rev += 1;
			}
			n >>= 1;
		}
		return rev;
	}

	public static void main(String args[]) {
		int a = 1234;
		String s = Integer.toBinaryString(a);
		System.out.println(s);
		StringBuffer rv = new StringBuffer();
		for(int i = s.length()-1; i >=0; i--) {
			rv.append(s.charAt(i));
		}
		System.out.println(rv.toString());

		System.out.println(Integer.toBinaryString(reversebit(a)));
	}
}
