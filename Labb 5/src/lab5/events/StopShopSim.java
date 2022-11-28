package lab5.events;

import lab5.shop.ShopState;

public class StopShopSim extends Event {

	public StopShopSim(ShopState state, EventQueue queue) {
		super(state, queue);
		this.description = "Stop";
	}


	@Override
	public void effect() {
		
		state.pause();
		
	}

	@Override
	public double getTime() {
		// TODO Auto-generated method stub
		return 999;
	}

}
