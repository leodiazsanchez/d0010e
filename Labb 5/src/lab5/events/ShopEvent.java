package lab5.events;


import lab5.shop.Customer;
import lab5.shop.ShopState;
import lab5.simulator.SimState;

public abstract class ShopEvent extends Event {

	protected ShopState shopState;
	protected Customer customer;

	public ShopEvent(SimState state, EventQueue queue) {

		super(state, queue);
		this.shopState = ((ShopState) state);

	}

	 public String toString() {
	 	return String.format(
	 		"%.2f\t %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %-10s %s",
	 		state.getTime(),
	 		description,
	 		"-",
	 		shopState.isOpen(),
	 		shopState.getOpenRegisterCount(),
	 		shopState.getCustomerCount(), 
	 		shopState.getSuccesses(),
	 		shopState.getFailures(),
	 		shopState.getCustomerQueue().maxSize(),
	 		shopState.getCustomerQueue().size(),
	 		shopState.getCustomerQueue()
	 	);
	 }

}
