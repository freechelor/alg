package alg.dc;

public class PowerfulPizza {
 
    private PowerfulPizzaStatus status;
    public enum PowerfulPizzaStatus {
        ORDERED (5){
            @Override
            public boolean isOrdered() {
                return true;
            }
        },
        READY (2){
            @Override
            public boolean isReady() {
                return true;
            }
        },
        DELIVERED (0){
            @Override
            public boolean isDelivered() {
                return true;
            }
        };
 
        private int timeToDelivery;
 
        public boolean isOrdered() {return false;}
 
        public boolean isReady() {return false;}
 
        public boolean isDelivered(){return false;}
 
        public int getTimeToDelivery() {
            return timeToDelivery;
        }
 
        PowerfulPizzaStatus (int timeToDelivery) {
            this.timeToDelivery = timeToDelivery;
        }
    }
 
    public boolean isDeliverable() {
        return this.status.isReady();
    }

	public void setStatus(PowerfulPizzaStatus s) {
		this.status = s;
	}

	public PowerfulPizzaStatus getStatus() {
		return this.status;
	}
 
    public void printTimeToDeliver() {
        System.out.println("Time to delivery is " + 
          this.getStatus().getTimeToDelivery());
    }
     
    // Methods that set and get the status variable.
}
