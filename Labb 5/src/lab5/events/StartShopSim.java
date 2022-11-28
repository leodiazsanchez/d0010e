package lab5.events;

import lab5.simulator.SimState;

public class StartShopSim extends Event {
	
	public StartShopSim(SimState state, EventQueue queue) {

		super(state, queue);
		this.description = "Start";
		
	}

	@Override
	public void effect() {

		new CustomerArrives(state, queue);

	}

	@Override
	public double getTime() {
		
		return 0;
	
	}

}
