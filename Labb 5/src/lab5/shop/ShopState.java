package lab5.shop;

import lab5.events.Event;
import lab5.simulator.SimState;

public class ShopState extends SimState {

	//private double stopAtTime;
	private int registerCount, maxCustomerCount, customerCount = 0, successes = 0, failures = 0, openRegisters;
	private Long seed;
	private Event event;
	private boolean isOpen = true;
	private CustomerFactory factory = new CustomerFactory();
	private CustomerQueue customerQueue = new CustomerQueue();
	private double timeNotInUse, lambda, pickUpTimeMin, pickUpTimeMax, payTimeMin, payTimeMax;

	public ShopState(
        int registerCount, 
        int maxCustomerCount, 
        double lambda, 
        double pickUpTimeMin,	
        double pickUpTimeMax, 
        double payTimeMin, 
        double payTimeMax, 
        double stopAtTime,
        Long seed
        
    ) {

		super(seed, lambda);
		this.maxCustomerCount = maxCustomerCount;
		this.registerCount = registerCount;
		this.pickUpTimeMax = pickUpTimeMax;
		this.pickUpTimeMin = pickUpTimeMin;
		this.openRegisters = registerCount;
		this.payTimeMin = payTimeMin;
		this.payTimeMax = payTimeMax;

	}

	public Customer newCustomer() {

		Customer customer = new Customer(factory);
		customerCount++;
		return customer;
	
    }
	
	public CustomerQueue getCustomerQueue() {

		return customerQueue;
		
	}

	public boolean isOpen() {

		return isOpen;
	
    }
	
	public void closeShop() {

		isOpen = false;
	
    }


	public int getCustomerCount() {
	
        return customerCount;
	
    }

	public void decrementCustomerCount() {
	
        customerCount--;

	
    }

	public int getMaxCustomerCount() {
	
        return maxCustomerCount;
	
    }

	public void addCustomerToQueue(Customer customer) {
        
        if (customerCount + 1 <= maxCustomerCount) {

            customerQueue.add(customer);

        }
	
    }

	public void incrementFailures() {
	
        failures++;
	
    }

	public int getRegisterCount() {

		return registerCount;
	
	}

	public int getOpenRegisterCount() {
	
		return registerCount;
	
	}

	public void incrementOpenRegisterCount() {
	
		openRegisters++;

	}

	public void decrementOpenRegisterCount() {

		openRegisters--;

	}

	public void incremnetSuccesses() {

		successes++;

	}

	public double[] getPickUpTimeInterval() {
		
		double[] interval = { pickUpTimeMin, pickUpTimeMax };
		return interval;

	}

	public double[] getPayTimeInterval() {
		
		double[] interval = { payTimeMin, payTimeMax };
		return interval;

	}

	public int getFailures() {

		return failures;

	}

	public int getSuccesses() {

		return successes;

	}
	
}