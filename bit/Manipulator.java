package alg.bit;

public class Manipulator {

	private void setBit(int num, int i) {
		int org = num;
		num = num | 1 << i;
		System.out.printf("set %dth bit of %d => %s", i, org, Integer.toBinaryString(num));
		System.out.println();
	}

	private void updateBit(int num, int i, int j) {
		int org = num;
		if(j==0) num = num & (~(1<<i));
		else if(j==1) num = num | (1<<i);
		else return;
		System.out.printf("update %dth bit of %d to %d => %s", i, org, j, Integer.toBinaryString(num));
		System.out.println();
	}

	private void removeBit(int num, int i) {
		int org = num;
		num = num &(~(1<<i));
		System.out.printf("remove %dth bit of %d => %s", i, org, Integer.toBinaryString(num));
		System.out.println();
	}

	private void maskUpperBit(int num, int i) {
		int org = num;
		num = (num & ((1<<i) - 1));
		System.out.printf("mask upper bits of %dth bit of %d => %s", i, org, Integer.toBinaryString(num));
		System.out.println();
	}

	private void maskLowerBit(int num, int i) {
		int org = num;
		num = (num & (~((1<<(i)) - 1)));
		System.out.printf("maks lower bits of %dth bit of %d => %s", i, org, Integer.toBinaryString(num));
		System.out.println();
	}

	public static void main(String args[]) {
		Manipulator man = new Manipulator();
		int a = 1789;
		int b = 12379;
		System.out.printf("Original number %d: %s", a,  Integer.toBinaryString(a));
		System.out.println();
		System.out.printf("Original number %d: %s", b,  Integer.toBinaryString(b));
		System.out.println();
		man.setBit(a, 1);		
		man.updateBit(a, 2, 0);
		man.removeBit(a, 5);
		man.maskUpperBit(b, 4);
		man.maskLowerBit(b, 4);
	}
}
