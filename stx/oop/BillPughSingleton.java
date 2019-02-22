package alg.stx.oop;

public class BillPughSingleton {

	private BillPughSingleton() { System.out.println("BillPughSingleton initialized!");}
		
	private static class SingletonHelper {
		private static final BillPughSingleton INSTANCE = new BillPughSingleton();
	}
	
	public static BillPughSingleton getInstance() {
		return SingletonHelper.INSTANCE;
	}
}
