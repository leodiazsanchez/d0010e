package lab5.events;

import lab5.shop.ArrivalTimeCalc;
import lab5.shop.Customer;
import lab5.simulator.SimState;

public class CustomerArrives extends ShopEvent {

	private Customer customer;
	
	public CustomerArrives(SimState state, EventQueue queue) {
		
		super(state, queue);

		this.description = "Arrives";
		
	}
	
	@Override
	public void effect() {
		
		if (shopState.isOpen() && (shopState.getCustomerCount() == shopState.getMaxCustomerCount())) {

			shopState.incrementFailures();
		
		} else if (shopState.isOpen() && (shopState.getCustomerCount() != shopState.getMaxCustomerCount())) {
		
			customer = shopState.newCustomer();
			new CustomerPicksUpItems(state, queue, customer);
		
		}
		

	}

	public double getTime() {
		
		return state.getSeed() != null ? 
			state.getTime() + new ArrivalTimeCalc(state.getLambda(), state.getSeed()).next() 
			: 
			state.getTime() + new ArrivalTimeCalc(state.getLambda()).next();

	}


}
