package alg.etc;

public class Coins {
	static int getWays(int[] types, int amount, int type) {
		if(amount>0 && type >= types.length) return 0;
		if(0==amount) return 1;
		int ways = 0;
			int cnt = 0;
			while(amount-cnt*types[type]>=0) {
				ways += getWays(types, amount-cnt*types[type], type+1);
				cnt++;
			}
		return ways;
	}

	public static void main(String args[]) {
		int[] types = new int[]{25, 10, 5, 1};
		int amount = 89;
		System.out.println(getWays(types, amount, 0));
	}
}
