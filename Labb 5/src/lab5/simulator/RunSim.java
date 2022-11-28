package lab5.simulator;

import lab5.events.EventQueue;
import lab5.events.ShopCloses;
import lab5.events.StartShopSim;
import lab5.events.StopShopSim;
import lab5.gui.ShopView;
import lab5.shop.ShopState;

public class RunSim {

	public static void main(String[] args) throws Exception {

		// 8 50 2 4 8 4 8 43 8

		int registerCount = 0;
		int maxCustomerCount = 0;
		double arrivalSpeed = 0;
		double pickUpTimeMin = 0;
		double pickUpTimeMax = 0;
		double payTimeMin = 0;
		double payTimeMax = 0;
		double stopAtTime = 0;
		Long seed = null;	

		try {

			registerCount = Integer.parseInt(args[0]);
			maxCustomerCount = Integer.parseInt(args[1]);
			arrivalSpeed = Double.parseDouble(args[2]);
			pickUpTimeMin = Double.parseDouble(args[3]);
			pickUpTimeMax = Double.parseDouble(args[4]);
			payTimeMin = Double.parseDouble(args[5]);
			payTimeMax = Double.parseDouble(args[6]);
			stopAtTime = Double.parseDouble(args[7]);
			seed = Long.parseLong(args[8]);
			

		} catch (Exception e) {

			throw new Exception(e);
		
		}

		ShopState state = new ShopState(
			registerCount, 
			maxCustomerCount, 
			arrivalSpeed, 
			pickUpTimeMin, 
			pickUpTimeMax,
			payTimeMin, 
			payTimeMax, 
			stopAtTime,
			seed
		);

		EventQueue queue = new EventQueue();
		
		new StartShopSim(state, queue);
		new ShopCloses(state, queue, stopAtTime);
		new StopShopSim(state, queue);

		ShopView view = new ShopView(state);
		Simulator shopSimulator = new Simulator(view, state, queue);

		shopSimulator.run();
	}

}
