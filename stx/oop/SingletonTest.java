package alg.stx.oop;

public class SingletonTest {
	public static void main(String args[]) {
		try {
			Thread.sleep(5000L);
		} catch(Exception ex) {
			ex.printStackTrace();
		}
		BillPughSingleton.getInstance();
	}
}
