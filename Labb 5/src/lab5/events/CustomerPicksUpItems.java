package lab5.events;

import lab5.shop.Customer;
import lab5.shop.PickUpTimeCalc;
import lab5.shop.ShopState;
import lab5.simulator.SimState;

public class CustomerPicksUpItems extends ShopEvent {

	private Customer customer;
	

	public CustomerPicksUpItems(SimState state, EventQueue queue, Customer customer) {

		super(state, queue);
		this.customer = customer;
		this.description = "Shopping";
	
	}

	@Override
	public void effect() {

		if(shopState.getRegisterCount() == shopState.getOpenRegisterCount()) {

			shopState.decrementOpenRegisterCount();
			new CustomerPays(state, queue, customer);

		} else if(shopState.getOpenRegisterCount() == 0) {

			shopState.addCustomerToQueue(customer);
		
		}

	}

	public double getTime() {
		//Kolla på den här casten senare
		double[] interval = ((ShopState) state).getPickUpTimeInterval();

		return state.getSeed() != null ? 
			state.getTime() + new PickUpTimeCalc(interval[0], interval[1], state.getSeed()).next()
			:
			state.getTime() + new PickUpTimeCalc(interval[0], interval[1]).next();

	}

}
