package alg.dc;

public class Pizza {
    private PizzaStatus status;
    public enum PizzaStatus {
        ORDERED,
        READY,
        DELIVERED;
    }
 
    public boolean isDeliverable() {
        if (getStatus() == PizzaStatus.READY) {
            return true;
        }
        return false;
    }
     
	public void setStatus(PizzaStatus s) {
		this.status = s;
	}

	public PizzaStatus getStatus() {
		return this.status;
	}
    // Methods that set and get the status variable.
}

