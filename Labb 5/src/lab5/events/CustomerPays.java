package lab5.events;

import lab5.shop.Customer;
import lab5.shop.PayTimeCalc;
import lab5.shop.ShopState;
import lab5.simulator.SimState;

public class CustomerPays extends ShopEvent {

	private Customer customer;
	
	public CustomerPays(SimState state, EventQueue queue, Customer customer) {

		super(state, queue);
		this.description = "Paying";

	}


	@Override
	public void effect() {

		shopState.decrementCustomerCount();
		shopState.incremnetSuccesses();
		shopState.incrementOpenRegisterCount();
		
		if (!shopState.getCustomerQueue().isEmpty()) {
    
			Customer c = (Customer) shopState.getCustomerQueue().first();
			shopState.decrementOpenRegisterCount();
			queue.removeFirst();
			new CustomerPays(state, queue,c);

		} else {

			shopState.incrementOpenRegisterCount();
		}

	}

	@Override
	public double getTime() {
		//Kolla på den här casten senare
		double[] interval = ((ShopState) state).getPayTimeInterval();

		return state.getSeed() != null ? 
			state.getTime() + new PayTimeCalc(interval[0], interval[1], state.getSeed()).next()
			:
			state.getTime() + new PayTimeCalc(interval[0], interval[1]).next();
	
	}

}
