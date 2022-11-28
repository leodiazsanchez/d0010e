package lab5.events;

import lab5.simulator.SimState;

public class ShopCloses extends ShopEvent {

	private double time;

	public ShopCloses(SimState state, EventQueue queue, double time) {
		
		super(state, queue);
		this.description = "Closing";
		this.time = time;
	
	}


	@Override
	public void effect() {

		shopState.closeShop();

	}

	@Override
	public double getTime() {

		return time;
		
	}

}
