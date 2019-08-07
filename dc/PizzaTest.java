package alg.dc;

public class PizzaTest {
	public static void main(String args[]) {
		Pizza p = new Pizza();
		p.setStatus(Pizza.PizzaStatus.ORDERED);
		if(p.getStatus().equals(Pizza.PizzaStatus.ORDERED)) {
			System.out.println("matched");
		} else {
			System.out.println("not matched");
		}
		if(p.getStatus() == Pizza.PizzaStatus.ORDERED) {
			System.out.println("matched");
		} else {
			System.out.println("not matched");
		}
		if(p.getStatus().equals(Color.GREEN)) {
			System.out.println("color matched");
		} else {
			System.out.println("color not matched");
		}
		/*
		if(p.getStatus()==Color.GREEN) {
			System.out.println("color matched");
		} else {
			System.out.println("color not matched");
		}*/

		PowerfulPizza pp = new PowerfulPizza();
		pp.setStatus(PowerfulPizza.PowerfulPizzaStatus.READY);
		if(pp.isDeliverable()) {
			System.out.println("Powerful Pizza is ready and deliverable");
		}

		if(pp.isOrdered()) {
			System.out.println("Powerful Pizza is ordered");
		}
	}
}
